package Bai16_ThucHanhCRM;

import Bai11_Assert.common.LocatorsCRM;
import Bai11_Assert.common.BaseTest;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test

    public void testLoginSuccess() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");

        WebUI.setText(driver, By.xpath(LocatorsCRM.inputEmail), "admin@example.com");

        WebUI.setText(driver, By.xpath(LocatorsCRM.inputPassword), "123456");

        WebUI.clickElement(driver, By.xpath(LocatorsCRM.buttonLogin), 5);

        boolean isDashboardDisplayed = driver.findElements(By.xpath("//span[normalize-space()='Dashboard']")).size() > 0;
        Assert.assertTrue(isDashboardDisplayed, "Login CRM Success - Dashboard menu is displayed");

    }
    @Test

    public void testLoginFailWithInvalidEmail() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");

        WebUI.setText(driver, By.xpath(LocatorsCRM.inputEmail), "admin2332@example.com");

        WebUI.setText(driver, By.xpath(LocatorsCRM.inputPassword), "123456");

        WebUI.clickElement(driver, By.xpath(LocatorsCRM.buttonLogin), 5);

        boolean errorMessage = driver.findElements(By.xpath("//div[@id='alerts']//div[normalize-space()='Invalid email or password']")).size() > 0;
        Assert.assertTrue(errorMessage, "Login Fail With Invalid Email - Error message is displayed");

    }
    @Test

    public void testLoginFailWithInvalidPassword() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");

        WebUI.setText(driver, By.xpath(LocatorsCRM.inputEmail), "admin@example.com");

        WebUI.setText(driver, By.xpath(LocatorsCRM.inputPassword), "123456");

        WebUI.clickElement(driver, By.xpath(LocatorsCRM.buttonLogin), 5);

        boolean errorMessage = driver.findElements(By.xpath("//div[@id='alerts']//div[normalize-space()='Invalid email or password']")).size() > 0;
        Assert.assertTrue(errorMessage, "Login Fail With Invalid Password - Error message is displayed");

    }
    @Test

    public void testLoginFailWithEmailNull() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");

        WebUI.setText(driver, By.xpath(LocatorsCRM.inputEmail), "");

        WebUI.setText(driver, By.xpath(LocatorsCRM.inputPassword), "123456");

        WebUI.clickElement(driver, By.xpath(LocatorsCRM.buttonLogin), 5);

        boolean errorMessage = driver.findElements(By.xpath("//div[normalize-space()='The Email Address field is required.']")).size() > 0;
        Assert.assertTrue(errorMessage, "Login Fail With Email Null - Error message is displayed");

    }
}
