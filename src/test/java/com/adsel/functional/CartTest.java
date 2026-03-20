package com.adsel.functional;

import com.adsel.base.BaseTest;
import com.adsel.pages.CartPage;
import com.adsel.pages.CheckoutPage;
import com.adsel.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    private CartPage cartPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod(alwaysRun = true)
    public void loginToProductPage() {
        this.productPage = new ProductPage(driver);
        this.cartPage = new CartPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
        loginAsStandardUser();
    }

    @Test(groups = {"smoke", "regression"})
    public void statusChangingOfAddToCartButtonBackpack() {
        productPage.clickAddToCartButtonBackpack();

        Assert.assertEquals(productPage.getTextRemoveButtonBackpack(), "Remove", "Error of Status Changing Of the Add To Cart Button!");
    }

    @Test(groups = {"smoke", "regression"})
    public void statusChangingOfRemoveButtonBackpack() {
        productPage.clickAddToCartButtonBackpack();
        productPage.clickRemoveButtonBackpack();

        Assert.assertEquals(productPage.getTextAddToCartButtonBackpack(), "Add to cart", "Error of Status Changing Of the Remove Button!");
    }

    @Test(groups = {"smoke", "regression"})
    public void showTheCartCountWhenAddingSingleItem() {
        productPage.clickAddToCartButtonBackpack();

        Assert.assertEquals(productPage.getCartCount(), "1", "When Adding a Item Cart Count Should Not Update Correctly!");
    }

    @Test(groups = {"smoke", "regression"})
    public void checkTheCartCountWhenRemovingTheAddingItem() {
        productPage.clickAddToCartButtonBackpack();
        productPage.clickRemoveButtonBackpack();

        Assert.assertTrue(productPage.getCartCountRemovingAddingItem(), "Error of The Cart Count When Removing The Adding Item!");
    }

    @Test(groups = {"smoke", "regression"})
    public void checkTheCartCountWhenAddingMultipleItems() {
        productPage.clickAddToCartButtonBackpack();
        productPage.clickAddToCartBikeLight();

        Assert.assertEquals(productPage.getCartCount(), "2", "When Adding multiple Items Cart Count Should Not Update Correctly!");
    }

    @Test(groups = {"smoke", "regression"})
    public void checkCartPageTitle() {
        productPage.clickCartIcon();

        Assert.assertEquals(cartPage.getTitle(), "Your Cart", "Cart Page Title Error!");
    }

    @Test(groups = {"smoke", "regression"})
    public void checkFunctionalityOfContinueShoppingButton() {
        productPage.clickCartIcon();
        cartPage.clickContinueShoppingButton();

        Assert.assertEquals(productPage.getTitle(), "Products", "Continue Shopping Button Functioning Error!");
    }

    @Test(groups = {"smoke", "regression"})
    public void checkFunctionalityOfCheckoutButton() {
        productPage.clickCartIcon();
        cartPage.clickCheckoutButton();

        Assert.assertEquals(checkoutPage.getTitle(), "Checkout: Your Information", "Checkout Button Functionality Error!");
    }

    @Test(groups = {"smoke", "regression"})
    public void checkVisibilityOfQtyLable() {
        productPage.clickCartIcon();

        Assert.assertTrue(cartPage.isQtyLabelVisible(), "QTY Lable Visibility Error!");
    }

    @Test(groups = {"smoke", "regression"})
    public void checkVisibilityOfDescriptionLable() {
        productPage.clickCartIcon();

        Assert.assertTrue(cartPage.isDescriptionLableVisible(), "Description Lable Visibility Error!");
    }

    @Test(groups = {"smoke", "regression"})
    public void checkVisibilityOfCartItem() {
        productPage.clickAddToCartButtonBackpack();
        productPage.clickCartIcon();

        Assert.assertTrue(cartPage.isCartItemVisible(), "Inventory Item Visibility Error!");
    }

    @Test(groups = {"smoke", "regression"})
    public void checkItemQtyOnItemCard() {
        productPage.clickAddToCartButtonBackpack();
        productPage.clickCartIcon();

        Assert.assertEquals(cartPage.getItemQtyOnCard(), "1", "Item Count Is Wrong!");
    }

}
