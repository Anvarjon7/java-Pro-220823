package de.telran.example_001;

public class Example_001 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new HelloRunnable()).start(); // создание объекта по слабой ссылке
        }
        System.out.println("Hello from main thread!");
    }

    private static class HelloThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + getName()); // имя потока присваивается автоматически, если мы его саме не задали
        }
    }

    private static class HelloRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }
}
