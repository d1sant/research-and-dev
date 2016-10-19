package com.my.research.and.dev.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

    public static void main(final String[] args) throws Exception {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);
        final Producer producer = new Producer(queue);
        final Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
        Thread.sleep(4000);
    }

    private static class Producer implements Runnable {
        final BlockingQueue<String> queue;
        Producer(final BlockingQueue<String> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            try {
                queue.put("1");
                Thread.sleep(1000);
                queue.put("2");
                Thread.sleep(1000);
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Consumer implements Runnable {
        final BlockingQueue<String> queue;
        Consumer(final BlockingQueue<String> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            try {
                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
