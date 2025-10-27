package Bai14_JavascriptExecutor;

import Bai11_Assert.common.BaseTest;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavacriptExecutor extends BaseTest {

    @Test

    public void demoClickElementWithJavacriptExecutor() throws InterruptedException {

        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(2000);

        // Khai báo JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));


        // Nhập văn bản vào hộp văn bản mà không sử dụng phương thức sendKeys ()

        js.executeScript("arguments[0].setAttribute('value','admin@example.com');", inputEmail);
        js.executeScript("arguments[0].setAttribute('value','123456');", inputPassword);

        WebElement buttonlogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        js.executeScript("arguments[0].click();", buttonlogin);
        Thread.sleep(2000);
    }

    @Test
    public void demoClickElementWithJavacriptExecutor_CMS() throws InterruptedException {

        driver.get("https://cms.anhtester.com/");
        Thread.sleep(2000);

        // Khai báo JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement menuBlog = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        js.executeScript("arguments[0].click();", menuBlog);
        Thread.sleep(2000);
    }

    @Test
    public void demoScrollToElementWithJavacriptExecutor() throws InterruptedException {

        driver.get("https://anhtester.com/");
        Thread.sleep(2000);

        // Khai báo JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Tất Cả Khóa Học')]"));
        // Scroll đến đầu của element
        //js.executeScript("arguments[0].scrollIntoView(true);", element);
        // Scroll đến cuối của element
        js.executeScript("arguments[0].scrollIntoView(false);", element);
        Thread.sleep(2000);
    }
    @Test
    public void highlightElementWithJavacriptExecutor() throws InterruptedException {

        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(2000);

        // Khai báo JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));

        // Highlight element
        WebUI.highlightElement(driver, inputEmail);
        Thread.sleep(2000);
        WebUI.highlightElement(driver, inputPassword,"green");
        Thread.sleep(2000);
    }

}
