package cucumber.examples.java.webdriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
 * Created by SG0216561 on 15/02/14.
 */
public class WebDriverStepDefs {
    WebDriver driver;
    private By googleBy = By.xpath("//div[@id='hplogo']");
    private By yahooBy = By.className("logo-container");
    private By gmailLoginBoxBy = By.className("signin-card");
    private By emailInputtBy = By.xpath("//input[@id='Email']");
    private By passwordBy = By.xpath("//input[@id='Passwd']");
    private By signInBy = By.xpath("//input[@id='signIn']");
    private By composeBy = By.className("Di");
    private By errormsgBy = By.className("error-msg");
    private By signoutBy = By.className("error-msg");


    @Given("^A webdriver$")
    public void A_webdriver() throws Throwable {
        driver = createChromeDriver("");
    }

    @When("^I enter \"([^\"]*)\"$")
    public void I_enter(String arg1) throws Throwable {
        driver.get(arg1);
    }


    @Then("^\"([^\"]*)\" page should appear$")
    public void page_should_appear(String arg1) throws Throwable {
        By by = null;
        if(arg1.equalsIgnoreCase("google")) {
            by = googleBy;
        } else if(arg1.equalsIgnoreCase("yahoo")) {
            by = yahooBy;
        }
        try {
            driver.findElement(by);
        } catch(NoSuchElementException e) {
            fail();
        }
    }


    @Then("^Login box should appear$")
    public void login_box_should_appear() throws Throwable {
        try {
            driver.findElement(gmailLoginBoxBy);
        } catch(NoSuchElementException e) {
            fail();
        }

    }

    @When("^I enter the login details$")
    public void I_enter_the_login_details() throws Throwable {
        try {
            WebElement email = driver.findElement(emailInputtBy);
            email.sendKeys("quarkqa5@gmail.com");

            WebElement password = driver.findElement(passwordBy);
            password.sendKeys("m0b1le123");
        } catch(NoSuchElementException e) {
            fail();
        }
    }

    @And("^Click on sign in$")
    public void Click_on_sign_in() throws Throwable {
        try {
            WebElement signin = driver.findElement(signInBy);
            signin.click();
        } catch(NoSuchElementException e) {
            fail();
        }
    }


    @Then("^I should see error message$")
    public void I_should_see_error_message() throws Throwable {
        try {
            WebElement errormessage = driver.findElement(errormsgBy);
            assertTrue(errormessage.getText().contains("incorrect"));

        } catch(NoSuchElementException e) {
            fail();
        }
    }

    @When("^I enter invalid login details$")
    public void I_enter_invalid_login_details() throws Throwable {
        try {
            WebElement email = driver.findElement(emailInputtBy);
            email.sendKeys("quarkqa5@gmail.com");

            WebElement password = driver.findElement(passwordBy);
            password.sendKeys("m0b1le12xxx3");
        } catch(NoSuchElementException e) {
            fail();
        }
    }

    @Then("^I should see all my mails$")
    public void I_should_see_all_my_mails() throws Throwable {
        try {
            Thread.sleep(2000);
            driver.findElement(composeBy);
        } catch(NoSuchElementException e) {
            fail();
        }
    }

    private WebDriver createChromeDriver(String chromeDriverPath) {
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

    @And("^I close the browser$")
    public void I_close_the_browser() throws Throwable {
        driver.close();
    }

    @Then("^I signout from gmail$")
    public void I_signout_from_gmail() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
