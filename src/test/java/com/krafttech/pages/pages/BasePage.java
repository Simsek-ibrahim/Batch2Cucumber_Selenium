package com.krafttech.pages.pages;

import com.krafttech.utilities.BrowserUtils;

import com.krafttech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){

        PageFactory.initElements(Driver.get(),this);
    }

    public void naviagateToTab(String tabName){
        Driver.get();
        Driver.get().findElement(By.xpath("//nav//span[.='"+tabName+"']")).click();

    }

    public void navigateToModule(String tab, String module){

        String tabLocator= "//span[.='"+tab+"']";

        String moduleLocator="//span[.='"+module+"']";

        BrowserUtils.waitForClickablility(By.xpath(tabLocator),5);
        WebElement tabElement=Driver.get().findElement(By.xpath(tabLocator));
        tabElement.click();

        BrowserUtils.waitForClickablility(By.xpath(moduleLocator),5);
        Driver.get().findElement(By.xpath(moduleLocator)).click();


    }

    public String subTitle(String subTitle){

        String subTileLocator="//h1[.='"+subTitle+"']";

        BrowserUtils.waitForPresenceOfElement(By.xpath(subTileLocator),5);

        WebElement SubTile= Driver.get().findElement(By.xpath(subTileLocator));

        String actualSubTitle= SubTile.getText();
        return actualSubTitle;

    }

    public String getAccountName_mtd(String accountName){
        return Driver.get().findElement(By.xpath("//span[.='"+accountName+"']")).getText();
    }

}
