package com.irphan.tests;

import com.irphan.base.BaseTest;
import com.irphan.pages.LoginPage;
import com.irphan.pages.Selectors;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.irphan.utils.ConfigReader;


import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        // 1. Buka URL Login
        driver.get(ConfigReader.get("baseUrl"));

        // 2. Inisialisasi Page Object
        LoginPage loginPage = new LoginPage(driver);

        // 3. Interaksi Login
        loginPage.enterPid(ConfigReader.get("pid"));
        loginPage.clickContinueButton();
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickSubmitButton();

        // 4. Tunggu sampai URL mengarah ke halaman yang diharapkan
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://super-app.privy.id/document/list/todo"));

        // 5. Assertion: pastikan URL sudah sesuai
        String expectedUrl = "https://super-app.privy.id/document/list/todo";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl, "URL setelah login tidak sesuai");

        // (Opsional) Print log URL & Title
        System.out.println("✅ Login sukses!");
        System.out.println("Current URL : " + actualUrl);
        System.out.println("Page Title  : " + driver.getTitle());
    }

    @Test
    public void testInValidLogin() {
    // 1. Buka URL Login
    driver.get(ConfigReader.get("baseUrl"));

    // 2. Inisialisasi Page Object
    LoginPage loginPage = new LoginPage(driver);

    // 3. Interaksi Login
    loginPage.enterPid(ConfigReader.get("pid"));
    loginPage.clickContinueButton();
    loginPage.enterPassword("wqw");
    loginPage.clickSubmitButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(Selectors.ERROR_PASSWORD));


        Assert.assertEquals(driver.findElement(Selectors.ERROR_PASSWORD).getText(), "Enter your correct password");

}
}

