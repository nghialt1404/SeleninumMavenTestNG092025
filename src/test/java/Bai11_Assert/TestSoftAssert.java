package Bai11_Assert;

import Bai11_Assert.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSoftAssert extends BaseTest {
    @Test(priority = 1)
    public void testSoftAssert() throws InterruptedException {

        driver.get("https://anhtester.com");

        SoftAssert softassert = new SoftAssert();

        String expectedTitle = "Anh Tester";
        String actualTitle = driver.getTitle();

        System.out.println("*** Checking For Homepage Title ***");

        softassert.assertEquals(actualTitle, expectedTitle);

        driver.findElement(By.xpath("//a[@id='btn-login']")).click();
        Thread.sleep(2000);

        System.out.println("*** Checking For Login Page Title ***");
        String actualloginpageTitle = driver.getTitle();

        softassert.assertEquals(actualloginpageTitle, "Login - Anh Tester");

        softassert.assertAll();
    }
}


