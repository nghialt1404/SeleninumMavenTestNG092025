package Bai19_NavigationPage.pages;

import keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Elements chung cho tất cả các page

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public By menuContracts = By.xpath("//span[normalize-space()='Contracts']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks']");

    public By iconprofile = By.xpath("//li[@class='icon header-user-profile']//img");
    public By optionLogOut = By.xpath("//a[text()='Logout']");


    // methods
    public void logoutsystem(){
        WebUI.clickElement(driver,iconprofile);
        WebUI.clickElement(driver,optionLogOut);

    }
    public void clickMenuDashboard() {
        WebUI.clickElement(driver, menuDashboard);
    }

    public void clickMenuCustomers() {
        WebUI.clickElement(driver, menuCustomers);
    }

    public ProjectsPage clickMenuProject() {

        WebUI.clickElement(driver, menuProjects);
        return new ProjectsPage(driver);
    }




}

