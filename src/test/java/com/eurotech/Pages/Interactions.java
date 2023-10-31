package com.eurotech.Pages;

import com.eurotech.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Interactions extends BasePage {
    @FindBy(xpath = "(//li[@id='item-3'])[4]") //span[text()='Droppable']
    public WebElement droppable;
}
