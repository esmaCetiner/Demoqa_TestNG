package com.eurotech.Tests.Task02;

import com.eurotech.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginUserCorrectCredential {
    /**
     1. Launch browser
     2. Navigate to url 'https://automationexercise.com'
     3. Verify that home page is visible successfully
     4. Click on 'Signup / Login' button
     5. Verify 'Login to your account' is visible
     6. Enter correct email address and password
     7. Click 'login' button
     8. Verify that 'Logged in as username' is visible
     9. Click 'Delete Account' button
     10. Verify that 'ACCOUNT DELETED!' is visible
     */

    WebDriver driver;
    String email = "asasdasddaaa@gmail.com";
    String password = "12345";

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https://automationexercise.com/");
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        driver.findElement(By.cssSelector(".fa.fa-lock")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        Thread.sleep(1000);
        String actualText = driver.findElement(By.xpath("//a[text()=' Logged in as ']")).getText();
        System.out.println("actualText = " + actualText);
        if (actualText.contains("Logged")){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.findElement(By.linkText("Delete Account")).click();
    }
}
