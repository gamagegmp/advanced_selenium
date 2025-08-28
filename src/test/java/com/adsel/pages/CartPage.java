package com.adsel.pages;

import com.adsel.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By pageTitle = By.className("title") ;

    public CartPage(WebDriver driver){
        super(driver);
    }
    public String getTitle(){
            return driver.findElement(pageTitle).getText();
        }



}
