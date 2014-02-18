package cucumber.examples.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

/**
 * Created by SG0216561 on 17/02/14.
 */
public class FlatPlanPage {
    private By byTableList = By.xpath("//*[@id=\"issue_list\"]");
    private By firstIssueBy = By.xpath("//*[@id=\"issue_list\"]/tbody/tr[1]/td[1]/div/a");

    public boolean iAmOnFlatPlanPage(WebDriver driver) {
        try {
            driver.findElement(byTableList);
            return true;

        } catch(NoSuchElementException e) {
                        return false;
        }
    }


    public void clickOnFirstIssue(WebDriver driver) {
        WebElement firstIssue = driver.findElement(firstIssueBy);
        firstIssue.click();
    }

}
