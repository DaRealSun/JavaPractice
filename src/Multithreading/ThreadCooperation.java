package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation {
    private static Account account = new Account();

    static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.shutdown();

    }

    public static class DepositTask implements Runnable{
        public void run(){
            try {
                //Delayto let the withdraw method process
                while (true) {
                    account.deposit((int) (Math.random() * 10 )+ 1);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e){
            }
        }
    }
    public static class WithdrawTask implements Runnable{
        @Override
        public void run() {
            while (true){
                account.withDraw((int) (Math.random() * 10) + 1);
            }
        }
    }

    private static class Account{
        private static Lock lock = new ReentrantLock();
        private static Condition newDeposit = lock.newCondition();
        private int balance =0;
        public int getBalance(){
            return balance;
        }
        public void withDraw(int amount){
            lock.lock();
            try{
                while (balance<amount){
                    System.out.println("Wait for a deposit");
                    newDeposit.await();
                }

                balance -=amount;
                System.out.println("\tWithdraw"+ amount + "\t" +getBalance());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }

        public void deposit(int amount){
            lock.lock();
            try {
                balance += amount;
                System.out.println("Deposit "+amount + "   "+getBalance());
                newDeposit.signalAll();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }
    }


}
