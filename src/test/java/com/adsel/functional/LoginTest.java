package com.adsel.functional;

import com.adsel.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(groups = {"smoke", "regression"})
    public void testValidLogin(){
        loginAsStandardUser();

        Assert.assertEquals(loginPage.getTitle(), "Products", "Login failed!");
    }

    @Test(groups = {"regression"})
    public void testInvalidLoginWithWrongUsername(){
        loginPage.enterUsername("wrong-username");
        loginPage.enterPassword("wrong-password");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Invalid Login with wrong username is Failed!");
    }

    @Test(groups = {"regression"})
    public void testInvalidLoginWithCorrectUsernameAndWrongPassword(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("wrong-password");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Invalid Login with wrong username is Failed!");
    }
}
