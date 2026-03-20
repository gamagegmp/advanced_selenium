package com.adsel.base;

import com.adsel.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseTest {
    public static WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        this.loginPage = new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    // reusable login method
    protected void login(String username, String password){
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    // commonly used login
    protected void loginAsStandardUser(){
        login("standard_user","secret_sauce");
    }

}


