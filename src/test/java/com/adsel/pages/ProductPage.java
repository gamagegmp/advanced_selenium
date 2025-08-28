package com.adsel.pages;

import com.adsel.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.PrivateKey;

public class ProductPage extends BasePage {
    private final By pageTitle = By.className("title");
    private final By filter = By.className("product_sort_container");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By productList = By.id("inventory_container");
    private final By productItem =  By.className("inventory_item");
    private final By burgerMenuIcon = By.id("react-burger-menu-btn");
    private final By addToCartButtonBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By removeButtonBackpack = By.id("remove-sauce-labs-backpack");
    private final By cartCount = By.className("shopping_cart_badge");
    private final By addToCartButtonBikeLight = By.id("add-to-cart-sauce-labs-bike-light");



    public ProductPage(WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return driver.findElement(pageTitle).getText();
    }
    public boolean isFilterVisible(){
        return driver.findElement(filter).isDisplayed();
    }
    public boolean isCartIconVisible(){
        return driver.findElement(cartIcon).isDisplayed();
    }
    public boolean isProductListVisible(){
        return driver.findElement(productList).isDisplayed();
    }
    public boolean areProductsAvailable(){
        return !driver.findElements(productItem).isEmpty();
    }
    public boolean isBurgerMenuIconVisible(){
        return driver.findElement(burgerMenuIcon).isDisplayed();
    }
    public void clickAddToCartButtonBackpack(){
        driver.findElement(this.addToCartButtonBackpack).click();
    }
    public String getTextRemoveButtonBackpack(){
        return driver.findElement(this.removeButtonBackpack).getText();
    }
    public void clickRemoveButtonBackpack(){
        click(this.removeButtonBackpack);
    }
    public String getTextAddToCartButtonBackpack(){
        return driver.findElement(this.addToCartButtonBackpack).getText();
    }
    public String getCartCount(){
        return getText(this.cartCount);
    }
    public boolean getCartCountRemovingAddingItem(){
        return isNotDisplayed(this.cartCount);
    }
    public void clickAddToCartBikeLight(){
        this.driver.findElement(this.addToCartButtonBikeLight).click();
    }
    public void clickCartIcon(){
        this.driver.findElement(this.cartIcon).click();
    }


}
