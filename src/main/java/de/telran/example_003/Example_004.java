package de.telran.example_003;

public class Example_004 {

    public static void main(String[] args) throws InterruptedException {
        AccountTmp account = new AccountTmp(100_000);
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

        private final AccountTmp account;


        private WithdrawThread(AccountTmp account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                try {
                    account.waitAndwithdraw(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class DepositThread extends Thread {

        private final AccountTmp account;


        private DepositThread(AccountTmp account) {
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

class AccountTmp {
    private  long balance;

    public AccountTmp() {
        this(0L);
    }

    public AccountTmp(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public synchronized void deposit(long amount) {
        checkAmountNonNegative(amount);
            balance += amount;
            notifyAll();
    }

    public synchronized void waitAndwithdraw(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);

            while (balance < amount) { // spurious wakeup
                wait();
                System.out.println("wakeup");
            }
            balance -= amount;

    }

    private static void checkAmountNonNegative(long amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }
}