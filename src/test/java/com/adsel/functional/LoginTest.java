package com.adsel.functional;

import com.adsel.base.BaseTest;
import com.adsel.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "excelLoginData", dataProviderClass = TestData.class,
            groups = {"smoke","regression"})
    public void testLogin(String username, String password, boolean valid){

        login(username,password);

        if(valid){
            Assert.assertEquals(loginPage.getTitle(),"Products");
        }else{
            Assert.assertTrue(loginPage.getErrorMessage().contains("locked out"));
        }
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


