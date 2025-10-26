package Bai13_Alert_PopupWindow_Iframe;

import Bai11_Assert.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class Demo_PopupWindow extends BaseTest {

    @Test
    public void demoOpenNewTabWindow() throws InterruptedException {
        driver.get("https://anhtester.com");
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://google.com");
    }

    @Test
    public void demoOpenNewWindow() throws InterruptedException {
        driver.get("https://anhtester.com");
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://google.com");
    }

    @Test //Cách 1 - Dùng vòng lặp for each
    public void demoHandlePopupTypeTab() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Thread.sleep(1000);
        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Lấy tất cả các mã định danh Tab Window.
        Set<String> windows = driver.getWindowHandles();

        //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.
        //Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        for (String window : windows) {
            System.out.println(window);
            if (!MainWindow.equals(window)) {
                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
                //Chuyển hướng driver đến Tab mới (Tab con)
                driver.switchTo().window(window);
                Thread.sleep(1000);
                System.out.println("Đã chuyển đến Tab Window mới");

                //Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());

                Thread.sleep(1000);
                //Sau khi chuyển hướng sang Tab mới thì getText cái header
                System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

                // Tắt cái Tab Window mới.
                Thread.sleep(1000);
                driver.close();
            }
        }
        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        Thread.sleep(1000);
    }

    @Test // Cách 2 - Dùng index
    public void demoHandlePopupTypeTab_Index() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Thread.sleep(1000);


        Set<String> allWindowHandles = driver.getWindowHandles();

        String mainWindow = (String) allWindowHandles.toArray()[0];
        String seccondWindow = (String) allWindowHandles.toArray()[1];

        driver.switchTo().window(seccondWindow);
        Thread.sleep(1000);
        System.out.println("Đã chuyển đến Tab Window mới");

        //Một số hàm hỗ trợ
        System.out.println(driver.switchTo().window(seccondWindow).getTitle());
        System.out.println(driver.switchTo().window(seccondWindow).getCurrentUrl());

        Thread.sleep(1000);
        //Sau khi chuyển hướng sang Tab mới thì getText cái header
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

        // Tắt cái Tab Window mới.
        Thread.sleep(1000);
        driver.close();

        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(mainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        Thread.sleep(1000);
    }


}
