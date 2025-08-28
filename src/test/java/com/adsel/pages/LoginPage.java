package com.adsel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By title = By.className("title");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterUsername(String username){
        driver.findElement(this.usernameField).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(this.passwordField).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(this.loginButton).click();
    }
    public String getTitle(){
        return driver.findElement(this.title).getText();
    }
    public String getErrorMessage(){
        return driver.findElement(this.errorMessage).getText();
    }
}
