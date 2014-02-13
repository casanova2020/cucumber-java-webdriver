package cucumber.examples.java.account;

/**
 * Created by SG0216561 on 11/02/14.
 */
public abstract class Account {

    private int number;
    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) throws IllegalStateException {
        if(number <= 0) {
            throw new IllegalStateException();
        }

        if(amount <= 0) {
            throw new IllegalStateException("Invalid deposit amount.");
        }
        balance = balance + amount;
    }


    public void withdraw(int amount) throws IllegalStateException {
        if(number <= 0) {
            throw new IllegalStateException("invalid account number");
        }
        if(balance - amount <= 0) {
            throw new IllegalStateException("No enough funds");
        }
        balance = balance - amount;
    }
}
