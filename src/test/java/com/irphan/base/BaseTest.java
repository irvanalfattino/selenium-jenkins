package com.irphan.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Sesuaikan path ke chromedriver jika belum pakai WebDriverManager
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Gunakan "--headless=new" untuk versi terbaru Chrome
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu"); // Opsional untuk Linux
        options.addArguments("--no-sandbox");  // Opsional untuk CI

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Anda dapat menambahkan implicit wait, pageLoadTimeout, dsb. di sini
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Jika ingin langsung membuka URL tertentu:
        // driver.get("https://your-login-url.com");
    }

    @AfterMethod
    public void tearDown() {
        // Pastikan driver tidak null
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
