package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email
 * or password.’
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";          //Base url

    @Before
    public void setUp() {               //Browser open code
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {               //Navigate login page test
        driver.findElement(By.linkText("Sign In")).click();                 //Click on sign in
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("User is not navigated to sign in page.", expectedText, actualText);     //Comparing 2 strings
    }

    @Test
    public void verifyTheErrorMessage() {                                   //Login with invalid data test
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("user[email]")).sendKeys("prime123@gmail.com");    //Enter invalid email
        driver.findElement(By.id("user[password]")).sendKeys("prime123");           //Enter invalid password
        driver.findElement(By.xpath("//button[@type='submit']")).click();         //Click on submit button
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("User not able to login with invalid data.", expectedText, actualText);      //Comparing 2 strings
    }

    @After
    public void tearDown() {                    //Browser closing code
        closeBrowser();
    }
}
