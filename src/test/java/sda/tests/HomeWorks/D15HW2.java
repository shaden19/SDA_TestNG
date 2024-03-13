package sda.tests.HomeWorks;

 /*
        Test Case2: Negative Username Test
        Open page https://practicetestautomation.com/practice-test-login/
        Type username incorrectUser into Username field.
        Type password Password123 into Password field.
        Click Submit button.
        Verify error message is displayed.
        Verify error message text is Your username is invalid!

*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utilities.TestBase;

public class D15HW2 extends TestBase {
    @Test
    public void test() {
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Step 2: Type the username and password
        String username = "iUser";
        String password = "Password123";
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Step 3: Click the submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Step 4: Verify the error message
        WebElement errorMessage = driver.findElement(By.id("error"));
        softAssert.assertFalse(errorMessage.isDisplayed());

        softAssert.assertAll();
    }
}

