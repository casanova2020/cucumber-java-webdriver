package cucumber.examples.java.account;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.joda.time.DateTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Sameer
 * Date: 15/02/2014
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
public class validateMyStepdefs {
    Cheque c;
    Account a;

    @Given("^A cheque with amount zero$")public void A_cheque_amount_zero() throws Throwable {
        c = new Cheque();
        c.chequeDate = new DateTime().plusDays(1);
        c.setChequeNumber(12345);
        c.setAmount(0);
    }

    @Given("^A cheque amount less than account balance and not zero$")
    public void A_cheque_amount_less_than_account_balance_and_not_zero() throws Throwable {
        a = new SavingsAccount(12345);
        a.setBalance(2000);

        c = new Cheque();
        c.setChequeNumber(12345);
        c.chequeDate = new DateTime().plusDays(1);
        c.setAmount(1000);
    }

    @When("^Cheque is deposited$")
    public void Cheque_is_deposited() throws Throwable {
            c.validateCheque();

        if (a != null ) {
            a.withdraw(c);
        }
    }

    @Then("^Cheque should pass$")
    public void Cheque_should_pass() throws Throwable {
        assertThat(c.getStatus(), is("PASS"));

    }

    @Given("^A cheque greater than account balance$")
    public void A_cheque_greater_than_account_balance() throws Throwable {
        a = new SavingsAccount(12345);
        a.setBalance(2000);

        c = new Cheque();
        c.setChequeNumber(12345);
        c.chequeDate = new DateTime().plusDays(1);
        c.setAmount(3000);


    }

    @Then("^Cheque should bounce$")
    public void Cheque_should_bounce() throws Throwable {
        assertThat(c.getStatus(), is("BOUNCE"));
    }

    @Given("^A cheque amount less than zero$")
    public void A_cheque_amount_less_than_zero() throws Throwable {
        c = new Cheque();
        c.setChequeNumber(12345);
        c.chequeDate = new DateTime().plusDays(1);
        c.setAmount(-3000);
    }

}
