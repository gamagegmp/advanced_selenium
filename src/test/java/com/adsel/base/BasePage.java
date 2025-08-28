package com.adsel.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private static final int TIMEOUT = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitForElementToBeClickable(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitForElementToBeVisible(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean waitForElementToBeInVisible(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        waitForElementToBeClickable(locator).click();
    }

    protected String getText(By locator) {
        return waitForElementToBeVisible(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return waitForElementToBeVisible(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    protected boolean isNotDisplayed(By locator){
        return waitForElementToBeInVisible(locator);
    }
}

