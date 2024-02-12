package de.telran.example_006;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Example_011 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("Submit worker 1");
        Future<String> future1 = executor.submit(new Worker("worker1"));

        System.out.println("Submit worker 2");
        Future<String> future2 = executor.submit(new Worker("worker2"));

        System.out.println("Result from worker1: " + future1.get());
        System.out.println("Result from worker2: " + future2.get());

        System.out.println("Submit workers using invokeAll()");
        List<Future<String>> futures = executor.invokeAll(Arrays.asList(new Worker("worker3"), new Worker("worker4"),new Worker("worker5")));

        System.out.println("Exited invokeAll()");
        for (Future<String> future : futures) {
            System.out.println("Result from worker: " + future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10L, TimeUnit.SECONDS);

    }

    private static class Worker implements Callable<String> {
        private final String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            long sleepTime = (long) (Math.random() * 10000L);
            System.out.println(name + " started, going to sleep for " + sleepTime + " ms.");
            Thread.sleep(sleepTime);
            System.out.println(name + " finished");
            return name;
        }
    }
}
