package Bai12_Actions_Robot;

import Bai11_Assert.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestActionClass extends BaseTest {
    @Test

    public void testSendKeys() throws InterruptedException {
        driver.get("https://cms.anhtester.com/");

        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Ok. I Understood']")).click();

        //Input search
        WebElement element = driver.findElement(By.xpath("//input[@id='search']"));

        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        //Dùng action để gọi hàm sendKeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Giày nữ").perform();

        Thread.sleep(2000);
    }
    @Test
    public void testPressEnterKey() throws InterruptedException {
        driver.get("https://cms.anhtester.com/");

        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Ok. I Understood']")).click();

        //Input search
        WebElement element = driver.findElement(By.xpath("//input[@id='search']"));

        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        //Dùng action để gọi hàm sendKeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Giày nữ").perform();

        Thread.sleep(2000);

        action.sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);
    }

    @Test
    public void testClick() throws InterruptedException {
        driver.get("https://cms.anhtester.com/");

        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Ok. I Understood']")).click();

        //Input search
        WebElement element = driver.findElement(By.xpath("//input[@id='search']"));

        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        //Dùng action để gọi hàm sendKeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Giày nữ").perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("(//a[contains(text(),'Giày nữ')])[1]"))).perform();

        Thread.sleep(2000);
    }
    // contextclick, double click
    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("(//h2[@class='section__title'])[1]"));

        Actions action = new Actions(driver);

        action.doubleClick(element).perform();
        Thread.sleep(2000);
    }
    @Test
    public void contextClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("(//h2[@class='section__title'])[1]"));

        Actions action = new Actions(driver);

        action.contextClick(element).perform();
        Thread.sleep(2000);
    }
    //move to element
    @Test
    public void moveToElement() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));

        Actions action = new Actions(driver);

        //Move to element (di chuyển tới title Kiến thức Automation Testing)
        action.moveToElement(element).perform();

        Thread.sleep(2000);
    }
    //Kéo và thả
    @Test
    public void DragAndDropWithActionClass() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        Thread.sleep(1000);

        // Bắt element cần kéo
        WebElement elementFrom1 = driver.findElement(By.xpath("//span[normalize-space()='Draggable 1']"));
        WebElement elementFrom2 = driver.findElement(By.xpath("//span[normalize-space()='Draggable 2']"));
        // Bắt element cần thả đến
        WebElement elementTo = driver.findElement(By.xpath("//div[@id='mydropzone']"));

        Thread.sleep(1000);
        Actions action = new Actions(driver);
        // Kéo và thả
        action.dragAndDrop(elementFrom1, elementTo).perform();
        Thread.sleep(1000);
        action.dragAndDrop(elementFrom2, elementTo).perform();

        Thread.sleep(2000);
    }

    @Test
    public void scrollPageDownAndUp() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Scroll down
        action.keyDown(Keys.PAGE_DOWN).build().perform();
        action.keyUp(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);
        // Scroll up
        action.keyDown(Keys.PAGE_UP).build().perform();
        action.keyUp(Keys.PAGE_UP).build().perform();
        Thread.sleep(2000);
    }
    // Copty và Paste sử dụng Actions class
    @Test
    public void copyAndPaste() throws InterruptedException {
        driver.get("https://anhtester.com/blogs");
        Thread.sleep(2000);

        WebElement inputCourseElement = driver.findElement(By.xpath("//span[@class='la la-search search-icon']/preceding-sibling::input"));
        WebElement inputBlogElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm bài viết')]"));

        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Nhập text vào ô search course
        inputCourseElement.sendKeys("Selenium");
        Thread.sleep(1000);
        //Ctrl + a để bôi đen
        action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).build().perform();
        Thread.sleep(1000);
        //Ctrl + c để copy
        action.keyDown(Keys.COMMAND).sendKeys("x").keyUp(Keys.COMMAND).build().perform();
        Thread.sleep(1000);
        //click vào ô Blog search
        inputBlogElement.click();
        Thread.sleep(1000);
        //Ctrl + v để dán
        action.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).build().perform();

        Thread.sleep(2000);
    }
}
