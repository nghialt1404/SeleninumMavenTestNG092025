package Bai16_ThucHanhCRM;

import Bai11_Assert.common.LocatorsCRM;
import Bai11_Assert.common.BaseTest;
import keyword.WebUI_OLD;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAddCustomer extends BaseTest {

    private String CUSTOMER_NAME = "NghiaLT";
    private String WEBSITE = "https://cmcglobal.com.vn/vi/home-vi/";

    @Test
    public void testAddNewCustomer() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputEmail), "admin@example.com");

        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputPassword), "123456");

        WebUI_OLD.clickElement(driver, By.xpath(LocatorsCRM.buttonLogin), 5);

        WebUI_OLD.clickElement(driver, By.xpath(LocatorsCRM.menuCustomers), 5);
        WebUI_OLD.clickElement(driver, By.xpath(LocatorsCRM.buttonNewCustomer), 5);

        //Add customer details
        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputCompany), CUSTOMER_NAME);
        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputVatNumber), "124635");
        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputphone), "0948274626");
        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputWebsite), WEBSITE);
        //Dropdown Group
        WebUI_OLD.clickElement(driver, By.xpath(LocatorsCRM.dropdownGroup), 2);
        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputSearchGroup), "My Group Testing");
        WebUI_OLD.clickElement(driver, By.xpath("//span[contains(normalize-space(),'My Group Testing')]"));
        WebUI_OLD.clickElement(driver, By.xpath(LocatorsCRM.dropdownGroup), 2);

        //Dropdown Currency
        WebUI_OLD.clickElement(driver, By.xpath(LocatorsCRM.dropdownCurrency), 2);
        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputSearchCurrency), "USD");
        WebUI_OLD.clickElement(driver, By.xpath("//a[@id='bs-select-2-1']"));
        WebUI_OLD.clickElement(driver, By.xpath(LocatorsCRM.dropdownCurrency), 2);

        // Dropdown Default Language
        WebUI_OLD.clickElement(driver, By.xpath(LocatorsCRM.dropdownDefaultLanguage), 2);
        WebUI_OLD.clickElement(driver, By.xpath("//span[normalize-space()='Vietnamese']"),2);

        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputAddress), "Hanoi, Vietnam");
        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputCity), "Hanoi");
        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputState), "Ba Dinh");
        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputZipcode), "100000");
        //Dropdown Country
        WebUI_OLD.clickElement(driver, By.xpath(LocatorsCRM.dropdownCountry), 2);
        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputSearchCountry), "Vietnam");
        WebUI_OLD.clickElement(driver, By.xpath("//span[normalize-space()='Vietnam']"),2);

        WebUI_OLD.clickElement(driver, By.xpath(LocatorsCRM.buttonSave), 5);

        // Verify new customer added successfully
        WebUI_OLD.clickElement(driver, By.xpath(LocatorsCRM.menuCustomers));
        WebUI_OLD.setText(driver, By.xpath(LocatorsCRM.inputSearchCustomer), CUSTOMER_NAME);
        Thread.sleep(5000);


        String actualCustomer = driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
        System.out.println("actualCustomer = " + actualCustomer);
        Assert.assertEquals(actualCustomer, CUSTOMER_NAME, "New customer is added successfully");

        // Verify trong ProjectPage
        WebUI_OLD.clickElement(driver, By.xpath(LocatorsCRM.menuProjects), 5);
        WebUI_OLD.clickElement(driver, By.xpath(LocatorsCRM.buttonNewProject), 5);

        driver.findElement(By.xpath("//button[@data-id='clientid']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@data-id='clientid']/following-sibling::div//input")).sendKeys(CUSTOMER_NAME);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='bs-select-6']//ul[@role='presentation']")));


        boolean isCustomerPresent = driver.findElements(By.xpath("//button[@data-id='clientid']/following-sibling::div//input")).size() >0;
        System.out.println("isCustomerPresent = " + driver.findElements(By.xpath("//button[@data-id='clientid']/following-sibling::div//input")).size());
        Assert.assertTrue(isCustomerPresent, "New customer is displayed in the project client list");

    }
}


