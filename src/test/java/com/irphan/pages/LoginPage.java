package com.irphan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void enterPid(String pid) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.PID)).sendKeys(pid);
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.CONTINUE_BUTTON)).click();
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.PASSWORD)).sendKeys(password);
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.SUBMIT_BUTTON)).click();
    }
}

