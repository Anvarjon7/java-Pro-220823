package de.telran.example_005;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example_010 {

    public static void main(String[] args) throws InterruptedException {

        AccountReentrantLock account = new AccountReentrantLock(0);
        System.out.println("Begin balance = " + account.getBalance());


       new DepositThread(account).start();

        account.waitAndwithdraw(500000000);

        System.out.println("End balance = " + account.getBalance());
    }



    private static class DepositThread extends Thread {

        private final AccountReentrantLock account;


        private DepositThread(AccountReentrantLock account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 60_000_000; i++) {
                account.deposit(i);
            }
        }
    }
}

class AccountReentrantLock {

    private final Lock lock = new ReentrantLock();
    private final Condition balanceIncreased = lock.newCondition();

    private  long balance;

    public AccountReentrantLock() {
        this(0L);
    }

    public AccountReentrantLock(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }

    }

    public void deposit(long amount) {
        checkAmountNonNegative(amount);
        lock.lock();
        try {
            balance += amount;
            balanceIncreased.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void withdraw(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);

        lock.lock();
        try {
            if (balance < amount) { // spurious wakeup
                throw new IllegalArgumentException("not enough money");
            }
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    public void waitAndwithdraw(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);

        lock.lock();
        try {
            while (balance < amount) { // Почему цикл? Нас могли разбудить, но баланс еще не пополнен, ждем дальше!
                balanceIncreased.await();
                System.out.println("awake");
            }
            balance -= amount;
        } finally {
            lock.unlock();
        }

    }


    private static void checkAmountNonNegative(long amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }
}
