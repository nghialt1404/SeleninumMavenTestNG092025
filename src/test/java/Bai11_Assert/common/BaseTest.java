package Bai11_Assert.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public SoftAssert softAssert;


    @BeforeMethod
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softAssert = new SoftAssert();

    }
    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            softAssert.assertAll();
        }
    }
}
