package Bai20_ThucHanhPOM.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends BasePage {

    // Khai báo driver
    private WebDriver driver;

    // Constructor
    public ProjectsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Khai báo các element của trang Projects
    private By labelProjectToNotStarted = By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='Not Started'])/preceding-sibling::span");
    private By labelProjectToInProgress = By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='In Progress'])/preceding-sibling::span");
    private By labelProjectToFinished = By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='Finished'])/preceding-sibling::span");
    private By labelProjectToOnHold = By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='On Hold'])/preceding-sibling::span");
    private By labelProjectToCancelled = By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='Cancelled'])/preceding-sibling::span");

    // Khai báo các hàm xử lý trong nội bộ trang Projects

    public String getTotalProjectNotStarted() {
        return driver.findElement(labelProjectToNotStarted).getText();
    }
    public String getTotalProjectInProgress() {
        return driver.findElement(labelProjectToInProgress).getText();
    }
    public String getTotalProjectFinished() {
        return driver.findElement(labelProjectToFinished).getText();
    }
    public String getTotalProjectOnHold() {
        return driver.findElement(labelProjectToOnHold).getText();
    }
    public String getTotalProjectCancelled() {
        return driver.findElement(labelProjectToCancelled).getText();
    }
    public String getTotalProjects(){
        int totalProjects = Integer.parseInt(getTotalProjectNotStarted()) +
                Integer.parseInt(getTotalProjectInProgress()) +
                Integer.parseInt(getTotalProjectFinished()) +
                Integer.parseInt(getTotalProjectOnHold()) +
                Integer.parseInt(getTotalProjectCancelled());
        return String.valueOf(totalProjects);
    }
}

