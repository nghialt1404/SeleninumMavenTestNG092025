package Bai16_ThucHanhCRM;

import Bai11_Assert.common.LocatorsCRM;
import Bai11_Assert.common.BaseTest;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashBoardTest extends BaseTest {

    @Test

    public void testDashboard_ProjectTotal() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");

        WebUI.setText(driver, By.xpath(LocatorsCRM.inputEmail), "admin@example.com");

        WebUI.setText(driver, By.xpath(LocatorsCRM.inputPassword), "123456");

        WebUI.clickElement(driver, By.xpath(LocatorsCRM.buttonLogin), 5);

        //Get label Project Total
        String totalProjectOnDashBoard = driver.findElement(By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span")).getText();
        System.out.println("Project Total: " + totalProjectOnDashBoard);

        WebUI.clickElement(driver,By.xpath("//span[normalize-space()='Projects']"),5);
        //Get label Project Total in Project menu
        String totalonprojectpage_NotStarted = driver.findElement(By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='Not Started'])/preceding-sibling::span")).getText();
        System.out.println("totalproject_NotStarted: " + totalonprojectpage_NotStarted);

        String totalonprojectpage_InProgress  = driver.findElement(By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='In Progress'])/preceding-sibling::span")).getText();
        System.out.println("totalproject_InProgress: " + totalonprojectpage_InProgress);

        String totalonprojectpage_Finish = driver.findElement(By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='Finished'])/preceding-sibling::span")).getText();
        System.out.println("totalproject_Finish: " + totalonprojectpage_Finish);

        String totalonprojectpage_OnHold  = driver.findElement(By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='On Hold'])/preceding-sibling::span")).getText();
        System.out.println("totalproject_OnHold: " + totalonprojectpage_OnHold);

        String totalonprojectpage_Cancel  = driver.findElement(By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='Cancelled'])/preceding-sibling::span")).getText();
        System.out.println("totalproject_Cancel: " + totalonprojectpage_Cancel);

        //Calculate total projects from Project page
        int totalProjectCalculated = Integer.parseInt(totalonprojectpage_NotStarted) +
                Integer.parseInt(totalonprojectpage_InProgress) +
                Integer.parseInt(totalonprojectpage_Finish) +
                Integer.parseInt(totalonprojectpage_OnHold) +
                Integer.parseInt(totalonprojectpage_Cancel);
        System.out.println("Total Project Calculated: " + totalProjectCalculated);
        System.out.println("Total Project:" + totalonprojectpage_InProgress + " / " + totalProjectCalculated);

        Assert.assertEquals(totalProjectOnDashBoard,totalonprojectpage_InProgress + " / " + totalProjectCalculated,"Verify Project Total on Dashboard is correct");

    }

}
