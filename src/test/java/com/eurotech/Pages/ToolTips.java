package com.eurotech.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolTips extends BasePage{
    @FindBy(id = "toolTipButton")
    public WebElement hoverMeButton;

    @FindBy(xpath = "//div[text()='You hovered over the Button']")
    public WebElement hoveredMeMessage;

    @FindBy(id = "toolTipTextField")
    public WebElement hoveredMeBox;

    @FindBy(xpath = "//div[text()='You hovered over the text field']")
    public WebElement getHoveredMeMessage2;

}
