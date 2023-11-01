package com.eurotech.Pages;

import com.eurotech.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaHomePage extends BasePage{
    @FindBy(xpath = "//h5[text()='Interactions']")
    public WebElement interactions;

    @FindBy(xpath = "//h5[text()='Widgets']")
    public WebElement widgets;
}
