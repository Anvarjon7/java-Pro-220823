package de.telran.example_002;

public class Example_003 {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(100_000);
        System.out.println("Begin balance = " + account.getBalance());

        Thread withdrawThread = new WithdrawThread(account);
        Thread depositThread = new DepositThread(account);

        withdrawThread.start();
        depositThread.start();

        withdrawThread.join();
        depositThread.join();

        System.out.println("End balance = " + account.getBalance());
    }

    private static class WithdrawThread extends Thread {

        private final Account account;


        private WithdrawThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.withdraw(i);
            }
        }
    }

    private static class DepositThread extends Thread {

        private final Account account;


        private DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.deposit(i);
            }
        }
    }
}

class Account {
    private  long balance;

    public Account() {
        this(0L);
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public synchronized void deposit(long amount) {
        checkAmountNonNegative(amount);
        synchronized(this) {
            balance += amount;
        }
    }

    public  void withdraw(long amount) {
        checkAmountNonNegative(amount);
        synchronized(this) {
            if (balance < amount) {
                throw new IllegalArgumentException("not enought money");
            }
            balance -= amount;
        }
    }

    private static void checkAmountNonNegative(long amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }
}