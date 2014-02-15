package cucumber.examples.java.account;

import org.joda.time.DateTime;

/**
 * Created with IntelliJ IDEA.
 * User: Sameer
 * Date: 13/02/2014
 * Time: 21:18
 * To change this template use File | Settings | File Templates.
 */
public class Cheque {
    public DateTime chequeDate;
    private String status;
    private int chequeNumber;
    private int amount;
    public String chequeName;

    public void validateCheque() {
        if (chequeDate.isBefore(DateTime.now())) {
            setStatus("BOUNCE");
            return;
        }
        if (chequeNumber <= 0) {
            setStatus("INVALID");
            return;
        }
        if(amount <= 0) {
            setStatus("BOUNCE");
            return;
        }
        setStatus("PASS");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(int chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
