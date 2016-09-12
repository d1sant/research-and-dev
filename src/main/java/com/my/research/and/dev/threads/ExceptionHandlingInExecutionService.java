package com.my.research.and.dev.threads;

import java.util.concurrent.*;

public class ExceptionHandlingInExecutionService {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());
        executor.submit(() -> System.out.println("Ok 1"));
        Future<Integer> resultWithException = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Runtime Exception");
                throw new RuntimeException("Got an Runtime Exception");

            }
        });
        try {
            System.out.println(resultWithException.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        executor.submit(() -> System.out.println("Ok 2"));
        Future<Long> result = executor.submit(() -> System.currentTimeMillis() + 100);
        System.out.println(result.get());
        executor.shutdown();
    }
}
