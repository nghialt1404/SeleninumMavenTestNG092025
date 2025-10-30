package Bai18_PageFactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import java.util.List;

public class DashboardPage extends BasePage {

    // Khai báo driver
    private WebDriver driver;

    // Constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBys(@FindBy(xpath = "//ul[@id='side-menu']/li[contains(@class,'menu-item')]"))
    private List<WebElement> listMenu;

    // Khai báo các element của trang Dashboard

    @FindBy(xpath = "//div[@class='screen-options-btn']")
    private WebElement buttonDashboardOption;

    @FindBy(xpath = "//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span")
    private WebElement labelTotalProjectsInProgress;

    // Khai báo các hàm xử lý trong nội bộ trang Dashboard

    public void checkListmenuDisplayed() {
        boolean isElementDisplayed = false;
        try {
            isElementDisplayed = listMenu.size() > 0;
        } catch (Exception e) {
            isElementDisplayed = false;
        }
        Assert.assertTrue(isElementDisplayed, " Dashboard page is not displayed");

        System.out.println("List Menu is display with" +  listMenu.size() + " items ");

        System.out.println("List of menu items :");
        for (WebElement menu : listMenu){
            System.out.println(menu.getText());
        }
    }

    public void verifyDashBoardPageDisplay() {

        boolean isDashboardOptionDisplayed = false;
        try {
            isDashboardOptionDisplayed = buttonDashboardOption.isDisplayed();
        } catch (Exception e) {
            isDashboardOptionDisplayed = false;
        }
        Assert.assertTrue(isDashboardOptionDisplayed, " Dashboard page is not displayed");
    }

    public void verifyTotalProjectinPropress() {
        String totalProjectOnDashBoard = labelTotalProjectsInProgress.getText();
        System.out.println("Project Total: " + totalProjectOnDashBoard);

        clickMenuProject();

        ProjectsPage projectsPage = new ProjectsPage(driver);

        Assert.assertEquals(totalProjectOnDashBoard, projectsPage.getTotalProjectInProgress() + " / " + projectsPage.getTotalProjects(), "Total Project on Dashboard does not match with Total Project in Projects page");
    }

}
