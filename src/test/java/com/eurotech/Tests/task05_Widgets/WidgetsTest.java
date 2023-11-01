package com.eurotech.Tests.task05_Widgets;

import com.eurotech.Pages.DemoqaHomePage;
import com.eurotech.Pages.ToolTips;
import com.eurotech.Pages.Widgets;
import com.eurotech.Tests.TestBase;
import com.eurotech.Utilities.BrowserUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.tools.Tool;

public class WidgetsTest extends TestBase {
    /**
     Url : https://demoqa.com/
     The user goes to tools home page
     The user navigate to "Widgets"
     The user click to "Tool Tips"
     user hovers over the Hover me to see button and verify message "You hovered over the Button"
     user hovers over the Hover me to see text field and verify message "You hovered over the text field"
     */

    DemoqaHomePage demoqaHomePage=new DemoqaHomePage();
    Widgets widgets = new Widgets();
    ToolTips toolTips = new ToolTips();
    @Test
    public void widgetTest(){
        BrowserUtils.scrollToElement(demoqaHomePage.widgets);
        demoqaHomePage.widgets.click();
        BrowserUtils.scrollToElement(widgets.toolTips);
        widgets.toolTips.click();
        BrowserUtils.hover(toolTips.hoverMeButton);
        Assert.assertEquals(toolTips.hoveredMeMessage.getText(),"You hovered over the Button");
        BrowserUtils.hover(toolTips.hoveredMeBox);
        Assert.assertEquals(toolTips.getHoveredMeMessage2.getText(),"You hovered over the text field");
    }
}
