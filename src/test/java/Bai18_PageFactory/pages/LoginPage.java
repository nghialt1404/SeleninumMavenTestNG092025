package Bai18_PageFactory.pages;

import Bai17_PageObjectModel.pages.BasePage;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {

    // khi báo driver trong từng trang

    private WebDriver driver;
    private String url_login = "https://crm.anhtester.com/admin/authentication";

    // Khai báo hàm xây dựng cho từng trang

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Khai báo đối tượng element thuộc về trang Login
    @FindBy(xpath = "//h1[normalize-space()='Login']")
    private WebElement headerLoginPage;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//a[normalize-space()='Forgot Password?']")
    private WebElement linkForgotPassword;

    @FindBy(xpath = "label[for='remember']")
    private WebElement checkboxRememberMe;

    @FindBy(xpath = "//div[@class='text-center alert alert-danger' and normalize-space()='Invalid email or password']")
    private WebElement errorMessageInvalid;

    @FindBy(xpath = "//div[@class='alert alert-danger text-center' and normalize-space()='The Email Address field is required.']")
    private WebElement errorMessageRequiredEmail;

    @FindBy(xpath = "//div[@class='alert alert-danger text-center' and normalize-space()='The Password field is required.']")
    private WebElement errorMessageRequiredPassword;

    // Khai báo các hàm xử lý trong nội bộ trang Login

    private void enterEmail(String email) {
        //inputEmail.sendKeys(email);
        WebUI.setText(driver, inputEmail ,email);
    }

    private void enterPassword(String password) {
        //inputPassword.sendKeys(password);
        WebUI.setText(driver, inputPassword ,password);
    }

    private void clickLoginButton() {
        //buttonLogin.click();
        WebUI.clickElement(driver, buttonLogin);

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

    public void verifyLoginPageDisplay() {
        boolean loginPageDisplayed = false;
        try {
            loginPageDisplayed = headerLoginPage.isDisplayed();
        } catch (Exception e) {
            loginPageDisplayed = false;

        }

        Assert.assertTrue(loginPageDisplayed, "Login page is not displayed");
    }

    public void verifyLoginSuccess() {
        boolean isDashboardDisplayed = driver.findElements(By.xpath("//span[normalize-space()='Dashboard']")).size() > 0;
        Assert.assertTrue(isDashboardDisplayed, "Login CRM Fail - Dashboard menu is not displayed");
    }

    public void verifyLoginFailWithEmailOrPasswordInvalid() {
        boolean isErrorMessageDisplayed = false;
        try {
            isErrorMessageDisplayed = errorMessageInvalid.isDisplayed();
        } catch (Exception e) {
            isErrorMessageDisplayed = false;
        }

        Assert.assertTrue(isErrorMessageDisplayed, "Login CRM Fail - Invalid Error Message is not displayed");
    }

    public void verifyLoginFailWithEmailNull() {
        boolean isErrorMessageDisplayed = false;
        try {
            isErrorMessageDisplayed = errorMessageRequiredEmail.isDisplayed();
        } catch (Exception e) {
            isErrorMessageDisplayed = false;
        }

        Assert.assertTrue(isErrorMessageDisplayed, "Login CRM Fail - Required Email Error Message is not displayed");
    }

    public void verifyLoginFailWithPasswordNull() {
        boolean isErrorMessageDisplayed = false;
        try {
            isErrorMessageDisplayed = errorMessageRequiredPassword.isDisplayed();

        } catch (Exception e) {
            isErrorMessageDisplayed = false;
        }

        Assert.assertTrue(isErrorMessageDisplayed, "Login CRM Fail - Required Password Error Message is not displayed");
    }


}
