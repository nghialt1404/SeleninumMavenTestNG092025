package Bai10_Anotations.testcases;

import Bai11_Assert.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class DemoBeforeMethodTest extends BaseTest {

    @Test (priority = 1)
    public void testLoginSuccess() throws InterruptedException {
        System.out.println("Bắt đầu kiểm tra đănn nhập");

        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Thread.sleep(1000);

        System.out.println("Đăng nhập thành công CRM");
    }

    @Test (priority = 2)
    public void testLoginFailWithInvalidEmail() throws InterruptedException {
        System.out.println("testLoginFailWithInvalidEmail");

        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin123@example.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Thread.sleep(1000);

        System.out.println("Đăng nhập không thành công CRM");
    }

    @Test (priority = 3)
    public void testAddNewCustomer() throws InterruptedException {

        String CustomerName = "Ray airfeeder " + System.currentTimeMillis();

        System.out.println("Bắt đầu kiểm tra thêm mới khách hàng");

        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorsCRM.buttonNewCustomer)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys(CustomerName);
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

        System.out.println("Thêm mới khách hàng thành công: " + CustomerName);


    }
}
