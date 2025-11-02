package Bai18_PageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private WebDriver driver;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements chung cho tất cả các page

    @FindBy(xpath = "//span[normalize-space()='Dashboard']")
    private WebElement menuDashboard;

    @FindBy(xpath = "//span[normalize-space()='Customers']")
    private WebElement menuCustomers;

    @FindBy(xpath = "//span[normalize-space()='Contracts']")
    private WebElement menuContracts;

    @FindBy(xpath = "//span[normalize-space()='Projects']")
    private WebElement menuProjects;

    @FindBy(xpath = "//span[normalize-space()='Tasks']")
    private WebElement menuTasks;

    @FindBy(xpath = "//li[@class='icon header-user-profile']//img")
    private WebElement iconProfile;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement optionLogOut;


    // Các hàm xử lý chung cho tất cả các trang
    public void logoutsystem() {
        iconProfile.click();
        optionLogOut.click();

    }

    public void clickMenuDashboard() {
        menuDashboard.click();
    }

    public void clickMenuCustomers() {
        menuCustomers.click();
    }

    public void clickMenuProject() {

        menuProjects.click();
    }
    public void clickMenuTasks() {

        menuTasks.click();
    }


}

