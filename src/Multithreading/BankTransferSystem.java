package Multithreading;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class BankTransferSystem {
    static int totalBalance = 0;
    static void main(String[] args) {

        var A = new Account(0,"A");
        var B = new Account(1,"B");
        var C = new Account(2,"C");
        Account[] list = {A,B,C};


        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {

            es.submit(() -> {
                for (int j = 0; j < 10; j++) {
                    Random r = new Random();
                    int fromAccount = r.nextInt(3);
                    int toAccount = r.nextInt(3);
                    while(fromAccount == toAccount ){
                        toAccount = r.nextInt(3);
                    }
                    int rAmount = r.nextInt(200)+1;
                    transfer(list[fromAccount], list[toAccount], rAmount);
                }
            });
        }

        es.shutdown();
        try {
            es.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        totalBalance = A.balance+ B.balance+C.balance;
        IO.println("Total balance: "+totalBalance);

    }
    static void transfer(Account from, Account to, int amount){
        Account first = from.id < to.id ? from:to;
        Account second = from.id > to.id ? to:from;
        first.lock.lock();
        try{
            second.lock.lock();
            try{
                if(amount < from.balance){
                    from.withdraw(amount);
                    to.deposit(amount);
                }
            }finally {
                second.lock.unlock();
            }
        }finally {
            first.lock.unlock();
        }
        System.out.println(from +" to "+ to+ " : $"+ amount);
    }


}
class Account{
    ReentrantLock lock = new ReentrantLock(true);
    //to fix dead lock we have id to prioritize account
    // with lower ID first. to stop the cycle calling

    String name;
    int id;
    Account(int id,String name){
        this.id=id;
        this.name=name;
    }
    int balance = 1000;
    void deposit(int amount){
        balance += amount;
    }
    void withdraw(int amount){
        balance-=amount;
    }
    public String toString(){return name + "($" + balance + ")";}

    }
