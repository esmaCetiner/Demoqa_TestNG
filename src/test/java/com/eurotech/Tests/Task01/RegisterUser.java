package com.eurotech.Tests.Task01;

import com.eurotech.Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class RegisterUser {
    public static void main(String[] args) throws InterruptedException {

        /**Test Case 1: Register User
         1. Launch browser
         2. Navigate to url 'http://automationexercise.com'
         3. Verify that home page is visible successfully
         4. Click on 'Signup / Login' button
         5. Verify 'New User Signup!' is visible- atladik
         6. Enter name and email address
         7. Click 'Signup' button
         8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
         9. Fill details: Title, Name, Email, Password, Date of birth
         10. Select checkbox 'Sign up for our newsletter!'
         11. Select checkbox 'Receive special offers from our partners!'
         12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
         13. Click 'Create Account button'
         14. Verify that 'ACCOUNT CREATED!' is visible
         15. Click 'Continue' button
         16. Verify that 'Logged in as username' is visible
         17. Click 'Delete Account' button
         18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button*/

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://automationexercise.com");
        driver.manage().window().maximize();
        Faker faker = new Faker();

        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();


        Thread.sleep(1000);

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

        WebElement nameBox = driver.findElement(By.xpath("//input[@type='text']"));
        nameBox.sendKeys(faker.name().firstName());

        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        Thread.sleep(1000);
        String expectedTitle = "ENTER ACCOUNT INFORMATION";
        WebElement title = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        String actualTitle =  title.getText();
        System.out.println("actualTitle = " + actualTitle);

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(faker.internet().password());

        WebElement day1 = driver.findElement(By.id("days"));
        day1.click();

        WebElement dayEnter = driver.findElement(By.xpath("(//option[@value='9'])[1]"));
        dayEnter.click();

        Thread.sleep(1000);
        driver.findElement(By.id("months")).click();
        WebElement monthEnter = driver.findElement(By.xpath("(//option[@value='9'])[2]"));
        monthEnter.click();

        driver.findElement(By.id("years")).click();
        driver.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/div[5]/div/div[3]/div/select/option[31]")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#newsletter")).click();
        driver.findElement(By.cssSelector("#optin")).click();

        Thread.sleep(1000);
        WebElement firstName = driver.findElement(By.cssSelector("#first_name"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.cssSelector("#last_name"));
        lastName.sendKeys(faker.name().lastName());

        Thread.sleep(1000);
        WebElement companyName = driver.findElement(By.cssSelector("#company"));
        companyName.sendKeys(faker.company().name());

        WebElement address1 = driver.findElement(By.cssSelector("#address1"));
        address1.sendKeys(faker.address().streetAddress());

        Thread.sleep(1000);
        WebElement address2 = driver.findElement(By.cssSelector("[type='text'][data-qa='address2']"));
        address2.sendKeys(faker.address().streetAddress());

        driver.findElement(By.cssSelector("#country")).click();
        driver.findElement(By.cssSelector("[value='United States']")).click();

        Thread.sleep(1000);
        WebElement inputState = driver.findElement(By.cssSelector("[type='text'][data-qa='state'][class='form-control']"));
        inputState.sendKeys(faker.address().state());

        WebElement inputCity = driver.findElement(By.cssSelector("[type='text'][data-qa='city']"));
        inputCity.sendKeys(faker.address().cityName());

        Thread.sleep(1000);
        WebElement zipCode = driver.findElement(By.cssSelector("#zipcode"));
        zipCode.sendKeys(faker.address().zipCode());

        WebElement mobileNumber = driver.findElement(By.cssSelector("#mobile_number"));
        mobileNumber.sendKeys(faker.phoneNumber().cellPhone());

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[type='submit'][data-qa='create-account']")).click();

        Thread.sleep(1000);
        String expectedResult = "ACCOUNT CREATED!";
        String actualResult = driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();
        if (actualResult.equals(expectedResult)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='ns-n3p8m-e-7']/../..")).click();

        Thread.sleep(2000);
        //driver.close();
    }
}
