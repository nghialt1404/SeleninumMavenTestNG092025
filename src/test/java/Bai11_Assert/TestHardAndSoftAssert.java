package Bai11_Assert;

import Bai10_Anotations.testcases.LocatorsCRM;
import Bai11_Assert.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestHardAndSoftAssert extends BaseTest {

    @Test(priority = 1)

    public void testAddNewCustomer() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        // Check customer page is displayed
        List<WebElement> checkHeaderCustomerPage = driver.findElements(By.xpath(LocatorsCRM.headerCustomerPage));
        System.out.println("checkHeaderCustomerPage = " + checkHeaderCustomerPage.size());
        softAssert.assertTrue(checkHeaderCustomerPage.size() > 0, "Customer page is displayed");
        String headerCustomerPageText = driver.findElement(By.xpath(LocatorsCRM.headerCustomerPage)).getText();
        softAssert.assertEquals(headerCustomerPageText, "Customers Summary 123", "Customer page is displayed");

        driver.findElement(By.xpath(LocatorsCRM.buttonNewCustomer)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys("Ray airfeeder");
        driver.findElement(By.xpath(LocatorsCRM.inputVatNumber)).sendKeys("14042924");
        driver.findElement(By.xpath(LocatorsCRM.inputphone)).sendKeys("0987654321");
        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("https://airfeeder.com");
        //Dropdown Group
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroup)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroup)).sendKeys("My Group Testing");
        driver.findElement(By.xpath("//span[contains(normalize-space(),'My Group Testing')]")).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroup)).click();

        //Dropdown Currency
        driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).sendKeys("USD");
        driver.findElement(By.xpath("//a[@id='bs-select-2-1']")).click();

        //Dropdown Default Language
        driver.findElement(By.xpath(LocatorsCRM.dropdownDefaultLanguage)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Vietnamese']")).click(); //Cách 1 dùng xpath
        //driver.findElement(By.xpath(LocatorsCRM.selectxpathLanguage("Vietnamese"))).click(); // Cách 2 gọi hàm truyền tham số language
        //driver.findElement(By.xpath(String.format(LocatorsCRM.optionLanguageDynamic,"Japanese"))).click(); // Cách 3 dùng String.format

        driver.findElement(By.xpath(LocatorsCRM.inputAddress)).sendKeys("123 ABC Street, New York, USA");
        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("New York");
        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("New York");
        driver.findElement(By.xpath(LocatorsCRM.inputZipcode)).sendKeys("10001");

        //Dropdown Country
        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Vietnam");
        driver.findElement(By.xpath("//span[normalize-space()='Vietnam']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRM.buttonSave)).click();
        Thread.sleep(2000);


        // Verify add customer susscessfully
        List<WebElement> checkRequiredCompany = driver.findElements(By.xpath("//p[@id='company-error']"));
        Assert.assertTrue(checkRequiredCompany.size() > 0, "Company field is not required ");

        softAssert.assertAll();
    }

}
