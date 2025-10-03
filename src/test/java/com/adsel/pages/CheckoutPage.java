package com.adsel.pages;

import com.adsel.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private final By pageTitle  = By.className("title");
    public CheckoutPage(WebDriver driver){
        super(driver);
    }
    public String getTitle(){
        return driver.findElement(this.pageTitle).getText();
    }
}
