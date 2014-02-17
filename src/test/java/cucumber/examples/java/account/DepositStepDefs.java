package cucumber.examples.java.account;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by SG0216561 on 11/02/14.
 */
public class DepositStepDefs {
    Account a;

    @Given("^an account with account number zero$")
    public void an_account_with_account_number_zero() throws Throwable {
       a = new SavingsAccount(0);
        a.setBalance(100);
    }

    @When("^i validateCheque the amount (\\d+) into the account$")
    public void i_deposit_the_amount_into_the_account(int arg1) throws Throwable {
        a.deposit(arg1);
    }

    @Given("^an valid account with balance (\\d+)$")
    public void an_valid_account_with_balance(int arg1) throws Throwable {
        a = new SavingsAccount(12345);
        a.setBalance(arg1);
    }

    @Then("^the balance should be (\\d+)$")
    public void the_balance_should_be(int arg1) throws Throwable {
        assertEquals(a.getBalance(),arg1);
    }

    @Then("^the account should not accept any validateCheque$")
    public void the_account_should_not_accept_any_deposit() throws Throwable {
        try {
            a.deposit(100);
            fail();
        } catch (IllegalStateException e) {
            assertEquals(100, a.getBalance());
        }
    }
}
