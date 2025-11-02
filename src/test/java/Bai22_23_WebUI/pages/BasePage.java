package Bai22_23_WebUI.pages;

import keyword.WebUI;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
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
        WebUI.clickElement(iconprofile);
        WebUI.clickElement(optionLogOut);

    }
    public void clickMenuDashboard() {
        WebUI.clickElement( menuDashboard);
    }

    public CustomersPage clickMenuCustomers() {
        WebUI.clickElement( menuCustomers);
        return new CustomersPage(driver);
    }

    public ProjectsPage clickMenuProject() {

        WebUI.clickElement( menuProjects);
        return new ProjectsPage(driver);
    }

}

