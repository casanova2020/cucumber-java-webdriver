package cucumber.examples.java.account;

/**
 * Created by SG0216561 on 11/02/14.
 */
public abstract class Account {

    private int number;
    private int balance;
    private String name;

    protected String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Account() {
    }

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
            throw new IllegalStateException("Invalid validateCheque amount.");
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

    public void withdraw(Cheque c) throws IllegalStateException {
        if(number <= 0) {
            c.setStatus("BOUNCE");
            return;
        }
        if(balance - c.getAmount() <= 0) {
            c.setStatus("BOUNCE");
            return;
        }
        balance = balance - c.getAmount();
        c.setStatus("PASS");


    }
}
