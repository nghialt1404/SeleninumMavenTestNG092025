package Bai13_Alert_PopupWindow_Iframe;

import Bai11_Assert.common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Demo_Alert extends BaseTest {

    @Test
    public void HandleAlert() throws InterruptedException {

        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//button[text()='Click Me'])[1]")).click();
        Thread.sleep(2000);

        String text = driver.switchTo().alert().getText();
        System.out.println("Alert text is: " + text);
        driver.switchTo().alert().accept();

    }
    @Test
    public void HandleAlert2() throws InterruptedException {

        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//button[text()='Click Me'])[2]")).click();
        Thread.sleep(2000);

        String text = driver.switchTo().alert().getText();
        System.out.println("Alert text is: " + text);
//        driver.switchTo().alert().dismiss();
//        String textoption = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
//        System.out.println("Text after cancel is: " + textoption);

        driver.switchTo().alert().accept();
        String textoption = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
        System.out.println("Text after click ok: " + textoption);

    }
    @Test
    public void HandleAlertInputText() throws InterruptedException {

        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//button[text()='Click Me'])[3]")).click();
        Thread.sleep(2000);

        Alert alert3 = driver.switchTo().alert();
        Thread.sleep(2000);
        alert3.sendKeys("Anh tester");
        Thread.sleep(2000);
        alert3.accept();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText(), "You have entered 'Anh tester' !");

    }

    @Test
    public void demoHandleAlertInputTextOther() throws InterruptedException {

        driver.get("https://demoqa.com/alerts");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        Thread.sleep(1000);

        //Nhấn sendKeys vào ô text
        driver.switchTo().alert().sendKeys("Anh Tester");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        //Kiểm tra giá trị sendKeys
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='promptResult']")).getText(), "You entered Anh Tester");
        Thread.sleep(1000);
    }
}
