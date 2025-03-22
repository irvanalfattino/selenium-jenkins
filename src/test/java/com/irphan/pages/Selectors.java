package com.irphan.pages;


import org.openqa.selenium.By;

public class Selectors {

    // Gunakan By.cssSelector atau By.xpath sesuai kebutuhan

    public static final By PID = By.cssSelector("input[placeholder='e.g. EX2002']");
    public static final By CONTINUE_BUTTON = By.xpath("//button[normalize-space()='Continue']");
    public static final By PASSWORD = By.cssSelector("input[placeholder='Password']");
    public static final By SUBMIT_BUTTON = By.xpath("//button[normalize-space()='Login']");
    public static final By ERROR_PASSWORD = By.cssSelector("div.my-2.text-xs.text-danger");


    // Tambahkan locator lain di sini, jika diperlukan
}
