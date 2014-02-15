package cucumber.examples.java.account;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by SG0216561 on 11/02/14.
 */
public class WithdrawStepDefs {
    Account a;


    @When("^i withdraw the amount (\\d+) from the account$")
    public void i_withdraw_the_amount_from_the_account(int arg1) throws Throwable {
        a.withdraw(arg1);
    }


    @Then("^the balance after withdraw should be (\\d+)$")
    public void the_balance_after_withdraw_should_be(int arg1) throws Throwable {
        assertEquals(a.getBalance(),arg1);
    }

    @Given("^an valid account with balance (\\d+) to withdraw$")
    public void an_valid_account_with_balance_to_withdraw(int arg1) throws Throwable {
        a = new SavingsAccount(12345);
        a.setBalance(arg1);
    }

    @When("^try to withdraw (\\d+) should throw error$")
    public void try_to_withdraw_should_throw_error(int arg1) throws Throwable {
        try {
            a.withdraw(arg1);
            fail();
        } catch(IllegalStateException e) {

        }

    }

}
