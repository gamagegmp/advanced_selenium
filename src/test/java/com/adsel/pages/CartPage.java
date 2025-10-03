package com.adsel.pages;

import com.adsel.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By pageTitle = By.className("title") ;
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");
    private final By qtyLabel = By.className("cart_quantity_label");
    private final By descriptionLable = By.className("cart_desc_label");
    private final By inventoryItem = By.className("cart_item");
    private final By itemQty = By.className("cart_quantity");

    public CartPage(WebDriver driver){
        super(driver);
    }
    public String getTitle(){
        return driver.findElement(pageTitle).getText();
    }
    public void clickContinueShoppingButton(){
        driver.findElement(this.continueShoppingButton).click();
    }
    public void clickCheckoutButton(){
        driver.findElement(this.checkoutButton).click();
    }
    public boolean isQtyLabelVisible(){
        return driver.findElement(this.qtyLabel).isDisplayed();
    }
    public boolean isDescriptionLableVisible(){
        return driver.findElement(this.descriptionLable).isDisplayed();
    }
    public boolean isCartItemVisible(){
        return driver.findElement(this.inventoryItem).isDisplayed();
    }
    public String getItemQtyOnCard(){
        return getText(this.itemQty);
    }

}
