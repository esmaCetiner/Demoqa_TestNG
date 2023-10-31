package com.eurotech.Tests.Task04_DragAndDrop;

import com.eurotech.Pages.DemoqaHomePage;
import com.eurotech.Pages.Droppable;
import com.eurotech.Pages.Interactions;
import com.eurotech.Tests.TestBase;
import com.eurotech.Utilities.BrowserUtils;
import com.eurotech.Utilities.ConfigurationReader;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends TestBase {

    //Url : https://demoqa.com/
    //Task-1
    //The user goes to tools home page
    //The user navigate to "Interactions"
    //The user click to "Droppable"
    //The user keeps dragging and dropping
    //The user verify the "Dropped!"
    DemoqaHomePage demoqaHomePage=new DemoqaHomePage();
    Interactions interactions=new Interactions();
    Droppable droppable=new Droppable();
    @Test
    public void interactions(){
        Actions actions=new Actions(driver);
        demoqaHomePage=new DemoqaHomePage();
        driver.get(ConfigurationReader.get("url"));
        BrowserUtils.scrollToElement(demoqaHomePage.interactions);
        demoqaHomePage.interactions.click();
        BrowserUtils.scrollToElement(interactions.droppable);
        interactions.droppable.click();

        actions.dragAndDrop(droppable.dragMe,droppable.dropHere).perform();

        Assert.assertEquals(droppable.verifyMessage.getText(),"Dropped!");



    }

}
