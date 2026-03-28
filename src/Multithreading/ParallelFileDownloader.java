package Multithreading;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;
import static java.util.Collections.list;

public class ParallelFileDownloader {
    static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<CompletableFuture<String>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            //CompletableFuture when you want maximum throughput and don't care about order
            CompletableFuture completableFuture = CompletableFuture.supplyAsync(()->{
                try {
                    Random r = new Random();
                    Thread.sleep((r.nextInt(5)+1)*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "File" + finalI;
                },executorService)
                    .thenAccept(result ->IO.println(result))
                    .exceptionally(e->{return  null;});
            futures.add(completableFuture);
        }
        //wait for all to finish before shutting down
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[10])).join();
        executorService.shutdown();
    }

}
