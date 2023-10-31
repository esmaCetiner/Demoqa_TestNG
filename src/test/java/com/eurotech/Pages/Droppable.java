package com.eurotech.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Droppable extends BasePage {

    @FindBy(id = "draggable")
    public WebElement dragMe;

    @FindBy(xpath = "(//div[@id='droppable'])[1]")
    public WebElement dropHere;
    @FindBy(xpath = "//p[text()='Dropped!']")
    public WebElement verifyMessage;
}
