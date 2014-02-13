package cucumber.examples.java.account;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by SG0216561 on 11/02/14.
 */
public class AccountStepDefs {
    Account a;

    @Given("^A valid Account$")
    public void A_valid_Account() throws Throwable {
        a = new SavingsAccount(10);
        a.deposit(100);
    }

    @Then("^Account number should not be zero$")
    public void Account_number_should_not_be_zero() throws Throwable {
        assertThat(a.getNumber()>0, is(true));
    }

    @Then("^Balance should be greater than zero$")
    public void Balance_should_be_greater_than_zero() throws Throwable {
        assertTrue(a.getBalance() > 0);
    }
}
