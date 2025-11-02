package Bai20_ThucHanhPOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage {

    // khi báo driver trong từng trang

    private WebDriver driver;
    private String url_login = "https://crm.anhtester.com/admin/authentication";

    // Khai báo hàm xây dựng cho từng trang

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Khai báo đối tượng element thuộc về trang Login
    private By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    private By checkboxRememberMe = By.xpath("label[for='remember']");
    private By errorMessageInvalid = By.xpath("//div[@class='text-center alert alert-danger' and normalize-space()='Invalid email or password']");
    private By errorMessageRequiredEmail = By.xpath("//div[@class='alert alert-danger text-center' and normalize-space()='The Email Address field is required.']");
    private By errorMessageRequiredPassword = By.xpath("//div[@class='alert alert-danger text-center' and normalize-space()='The Password field is required.']");

    // Khai báo các hàm xử lý trong nội bộ trang Login

    private void enterEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void enterPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickLoginButton() {
        driver.findElement(buttonLogin).click();
    }

    public void navigateToLoginPage() {
        driver.get(url_login);
    }

    public void loginCRM(String email, String password) {
        navigateToLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
    public DashboardPage loginCRM() {
        navigateToLoginPage();
        enterEmail("admin@example.com");
        enterPassword("123456");
        clickLoginButton();

        return new DashboardPage(driver);
    }

    public void verifyLoginSuccess() {
        boolean isDashboardDisplayed = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(menuDashboard));
            isDashboardDisplayed = driver.findElement(menuDashboard).isDisplayed();
        } catch (NoSuchElementException e) {
            isDashboardDisplayed = false;
        }

        Assert.assertTrue(isDashboardDisplayed, "Login CRM Fail - Dashboard menu is not displayed");
    }

    public void verifyLoginFailWithEmailOrPasswordInvalid() {
        boolean isErrorMessageDisplayed = driver.findElements(errorMessageInvalid).size() > 0;
        Assert.assertTrue(isErrorMessageDisplayed, "Login CRM Fail - Invalid Error Message is not displayed");
    }

    public void verifyLoginFailWithEmailNull() {
        boolean isErrorMessageDisplayed = driver.findElements(errorMessageRequiredEmail).size() > 0;
        Assert.assertTrue(isErrorMessageDisplayed, "Login CRM Fail - Required Email Error Message is not displayed");
    }

    public void verifyLoginFailWithPasswordNull() {
        boolean isErrorMessageDisplayed = driver.findElements(errorMessageRequiredPassword).size() > 0;
        Assert.assertTrue(isErrorMessageDisplayed, "Login CRM Fail - Required Password Error Message is not displayed");
    }

    public void verifyLoginPageDisplay(){
        boolean loginPageDisplayed = driver.findElements(headerLoginPage).size() > 0;
        Assert.assertTrue(loginPageDisplayed, "Login page is not displayed");
    }


}
