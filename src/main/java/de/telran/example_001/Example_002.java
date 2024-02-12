package de.telran.example_001;

public class Example_002 {

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Worker();
        Thread sleeper = new Sleeper();

        System.out.println("Starting threads");
        worker.start();
        sleeper.start();

//        Thread.sleep(100L);
//
//        System.out.println("Interrupting threads");
//        worker.interrupt();
//        sleeper.interrupt();
//
//        System.out.println("Joining threads");
//        worker.join();
//        sleeper.join();

        System.out.println("All done.");
    }

    private static class Worker extends Thread {
        @Override
        public void run() {
            long sum = 0;

            for (int i = 0; i < 1_000_000_000; i++) {
                sum += i;
                if(i % 100 == 0 && isInterrupted()) {
                    System.out.println("Loop interrupted at i = " + i);
                    break;
                }

            }
            try {
                Thread.sleep(3400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class Sleeper extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
        }
    }
}
