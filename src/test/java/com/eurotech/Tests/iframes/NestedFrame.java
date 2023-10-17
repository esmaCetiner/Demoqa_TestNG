package com.eurotech.Tests.iframes;


import com.eurotech.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFrame {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        // driver.close();

    }

    @Test
    public void sampleNestedIframe() {
        driver.switchTo().frame("frame1");
        WebElement actualText = driver.findElement(By.xpath("//body[text()='Parent frame']"));
        Assert.assertEquals(actualText.getText(),"Parent frame");

        driver.switchTo().frame(0);
        WebElement actualTextChild = driver.findElement(By.xpath("//p[text()='Child Iframe']"));
        Assert.assertEquals(actualTextChild.getText(),"Child Iframe");

        driver.switchTo().defaultContent();


    }
}
