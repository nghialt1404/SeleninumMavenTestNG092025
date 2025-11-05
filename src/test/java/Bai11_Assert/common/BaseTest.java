package Bai11_Assert.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    public WebDriver driver;
    public SoftAssert softAssert;


    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("chorme") String browserName) {
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                System.out.println("Launching Chrome browser...");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                System.out.println("Launching Firefox browser...");
                break;
            case "edge":
                driver = new EdgeDriver();
                System.out.println("Launching Edge browser...");
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
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
