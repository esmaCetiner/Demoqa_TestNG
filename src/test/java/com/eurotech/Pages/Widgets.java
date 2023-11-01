package com.eurotech.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Widgets extends BasePage{

    @FindBy(xpath = "//span[text()='Tool Tips']")
    public WebElement toolTips;
}
