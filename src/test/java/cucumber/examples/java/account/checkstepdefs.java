package cucumber.examples.java.account;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created with IntelliJ IDEA.
 * User: Sameer
 * Date: 13/02/2014
 * Time: 21:11
 * To change this template use File | Settings | File Templates.
 */
public class checkstepdefs {
    Cheque C;

    @Then("^the cheque should bounce$")
    public void the_cheque_should_bounce() throws Throwable {
        assertThat(C.getStatus(), is("BOUNCE"));
    }

    @Given("^a cheque with past date$")
    public void a_cheque_with_past_date() throws Throwable {
         C = new Cheque();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
//        System.out.println(dateFormat.format(cal.before(1)));
        C.chequeDate = new DateTime().minusDays(1);
    }

    @When("^the cheque is deposited$")
    public void the_cheque_is_deposited() throws Throwable {
             C.validateCheque();
    }

    @Given("^a cheque with invalid number$")
    public void a_cheque_with_invalid_number() throws Throwable {
        C = new Cheque();
        C.chequeDate = new DateTime().plusDays(1);
        C.setChequeNumber(0);
    }

    @Given("^a cheque with valid details$")
    public void a_cheque_with_valid_details() throws Throwable {
        C = new Cheque();
        C.chequeDate = new DateTime().plusDays(1);
        C.setChequeNumber(12345);
    }

    @Then("^the cheque should pass$")
    public void the_cheque_should_pass() throws Throwable {
        assertThat(C.getStatus(), is("PASS"));
    }

    @Then("^the cheque should be invalid$")
    public void the_cheque_should_be_invalid() throws Throwable {
        assertThat(C.getStatus(), is("INVALID"));
    }
}
