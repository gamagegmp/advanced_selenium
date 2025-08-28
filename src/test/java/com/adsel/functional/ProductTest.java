package com.adsel.functional;

import com.adsel.base.BaseTest;
import com.adsel.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    private ProductPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void loginToProductPage(){
        this.productPage = new ProductPage(driver);
        loginAsStandardUser();
    }
    @Test(groups = {"smoke", "regression"})
    public void titleVisibility(){
        Assert.assertEquals(productPage.getTitle(), "Products", "Title Visibility Error!" );
    }
    @Test
    public void filterVisibility(){
        Assert.assertTrue(productPage.isFilterVisible(), "Filter Visibility Error!");
    }
    @Test
    public void cartIconVisibility(){
        Assert.assertTrue(productPage.isCartIconVisible(),"Cart Visibility Error!");
    }
    @Test
    public void productListVisibility(){
        Assert.assertTrue(productPage.isProductListVisible(),"Product List Visibility Error!");
    }
    @Test
    public void productAvailability(){
        Assert.assertTrue(productPage.areProductsAvailable(), "No Products Available!");
    }
    @Test
    public void burgerMenuIconVisibility(){
        Assert.assertTrue(productPage.isBurgerMenuIconVisible(), "Burger Menu Icon Visibility Error!");
    }
}
