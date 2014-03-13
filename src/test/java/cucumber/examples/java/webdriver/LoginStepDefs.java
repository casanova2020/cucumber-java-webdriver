package cucumber.examples.java.webdriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.examples.java.pages.FlatPlanPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.NoSuchElementException;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Sameer
 * Date: 16/02/2014
 * Time: 11:36
 * To change this template use File | Settings | File Templates.
 */
public class LoginStepDefs {
    WebDriver driver;
    FlatPlanPage flatPlanPage;
    private By emailBy = By.className("input-xlarge");
    private By passwordBy = By.name("password");
    private By signInBy = By.xpath("//*[@id=\"signin\"]/div[1]/form/div[3]/div/button");
    private By composeBy = By.xpath("//*[@id=\"issue_list\"]/tbody/tr/td[1]/div/a/button");
    private By errormsgBy = By.cssSelector(".alert .alert-error");
    private By compileButtonBy = By.xpath("//*[@id=\"compile_btn\"]");


    @Given("^Im on the appstudio home page$")
    public void Im_on_the_appstudio_home_page() throws Throwable {
        driver = createChromeDriver("");
        driver.get("https://stage.appstudio.net/signin");
    }

    @And("^I close browser$")
    public void I_close_the_browser() throws Throwable {
        driver.close();
    }

    @When("^I enter email and password$")
    public void I_enter_email_and_password() throws Throwable {

        try {
            WebElement email = driver.findElement(emailBy);
            email.sendKeys("xxx");

            WebElement password = driver.findElement(passwordBy);
            password.sendKeys("xxxx");
        } catch (NoSuchElementException e) {
            fail();
        }

    }

    @Then("^I should be able to login$")
    public void I_should_be_able_to_login() throws Throwable {
        try {
            Thread.sleep(2000);
            driver.findElement(composeBy);
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    private ChromeDriver createChromeDriver(String chromeDriverPath) {
        if (StringUtils.isEmpty(chromeDriverPath)) {
            String os = System.getProperty("os.name").toLowerCase();
            boolean isMacOS = os.contains("mac");
            boolean isWinOS = os.contains("win");
            boolean isLinuxOS = os.contains("linux");
            String userDir = System.getProperty("user.dir");

            if (isMacOS) {
                chromeDriverPath = userDir + "/tools/mac/chromedriver";
            } else if (isWinOS) {
                chromeDriverPath = userDir + "/tools/win/chromedriver.exe";
            } else if (isLinuxOS) {
                chromeDriverPath = userDir + "/tools/linux64/chromedriver";
            }
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    @And("^I click Login button$")
    public void I_click_Login_button() throws Throwable {
        WebElement login = driver.findElement(signInBy);
        login.click();

    }

    @When("^I enter invalid email and password$")
    public void I_enter_invalid_email_and_password() throws Throwable {

        try {
            WebElement email = driver.findElement(emailBy);
            email.sendKeys("xxx@gmail.com");

            WebElement password = driver.findElement(passwordBy);
            password.sendKeys("xxx");

        } catch (NoSuchElementException e) {
            fail();
        }

    }

    @Then("^I should see error text$")
    public void I_should_see_errortext() throws Throwable {
        try {
            Thread.sleep(1000);
            WebElement errortext = driver.findElement(errormsgBy);
            assertTrue(errortext.getText().contains("incorrect"));
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    @And("^I click on create Organisation$")
    public void I_click_on_create_Organisation() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^I fill all the fields$")
    public void I_fill_all_the_fields() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^I click on Save button$")
    public void I_click_on_Save_button() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I should able to See an Organisation$")
    public void I_should_able_to_See_an_Organisation() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }


    @Given("^I am on flatplan$")
    public void I_am_on_flatplan() throws Throwable {
        flatPlanPage = new FlatPlanPage();
        boolean status = flatPlanPage.iAmOnFlatPlanPage(driver);
        if (!status) {
            fail("flat plan element missing");
        }
    }

    @Then("^I should be able to compile$")
    public void I_should_be_able_to_compile() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^click on compile button$")
    public void click_on_compile_button() throws Throwable {
        Thread.sleep(1000);
        WebElement compileButton = driver.findElement(compileButtonBy);
        compileButton.click();
    }

    @And("^click on the first issue$")
    public void click_on_the_first_issue() throws Throwable {
        flatPlanPage.clickOnFirstIssue(driver);
    }

    @Then("^I all the issues has to be compiled$")
    public void I_all_the_issues_has_to_be_compiled() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}