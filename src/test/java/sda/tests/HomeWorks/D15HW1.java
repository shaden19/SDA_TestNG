package sda.tests.HomeWorks;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utilities.TestBase;

/*
Test Case1: Positive Login Test
Open page https://practicetestautomation.com/practice-test-login/
Type username student into Username field
Type password Password123 into Password field
Click Submit button.
Verify new page URL contains practicetestautomation.com/logged-in-successfully/
Verify new page contains expected text ('Congratulations' or 'successfully logged in')
Verify button Log out is displayed on the new page.
*/
public class D15HW1 extends TestBase {
    @Test
    public void hardAssertion(){

        //Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //Type username student into Username field
        driver.findElement(By.id("username")).sendKeys("student");

        //Type password Password123 into Password field
        driver.findElement(By.id("password")).sendKeys("Password123");

        //Click Submit button.
        driver.findElement(By.id("submit")).click();

        //Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("practicetestautomation.com/logged-in-successfully"));

        //Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Congratulations"));

        //Verify button Log out is displayed on the new page.
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='wp-block-button aligncenter is-style-fill']")).isDisplayed());

    }

    @Test
    public void softAssertion() throws InterruptedException {

        //Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //Type username student into Username field
        driver.findElement(By.id("username")).sendKeys("student");

        //Type password Password123 into Password field
        driver.findElement(By.id("password")).sendKeys("Password123");

        //Click Submit button.
        driver.findElement(By.id("submit")).click();
        SoftAssert sa = new SoftAssert();

        //Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        String currentUrl = driver.getCurrentUrl();
        sa.assertTrue(currentUrl.contains("practicetestautomation.com/logged-in-successfully"));

        //Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String pageSource = driver.getPageSource();
        sa.assertTrue(pageSource.contains("Congratulations"));
        Thread.sleep(1000);

        //Verify button Log out is displayed on the new page.\n" +
        sa.assertTrue(driver.findElement(By.xpath("//div[@class='wp-block-button aligncenter is-style-fill']")).isDisplayed());


        // Perform all soft assertions
        sa.assertAll();


    }
}
