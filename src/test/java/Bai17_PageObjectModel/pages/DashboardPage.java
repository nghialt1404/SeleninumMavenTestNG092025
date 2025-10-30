package Bai17_PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage {

    // Khai báo driver
    private WebDriver driver;

    // Constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    // Khai báo các element của trang Dashboard
    private By buttonDashboardOption = By.xpath("//div[@class='screen-options-btn']");
    private By labelTotalProjectsInProgress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");

    // Khai báo các hàm xử lý trong nội bộ trang Dashboard
    public void verifyDashBoardPageDisplay() {
        boolean isDashboardOptionDisplayed = driver.findElements(buttonDashboardOption).size() > 0;
        Assert.assertTrue(isDashboardOptionDisplayed," Dashboard page is not displayed");
    }
    public void verifyTotalProjectinPropress(){
        String totalProjectOnDashBoard = driver.findElement((labelTotalProjectsInProgress)).getText();
        System.out.println("Project Total: " + totalProjectOnDashBoard);

        clickMenuProject();

        ProjectsPage projectsPage = new ProjectsPage(driver);

        Assert.assertEquals(totalProjectOnDashBoard,projectsPage.getTotalProjectInProgress() + " / " + projectsPage.getTotalProjects(),"Total Project on Dashboard does not match with Total Project in Projects page");
    }

}
