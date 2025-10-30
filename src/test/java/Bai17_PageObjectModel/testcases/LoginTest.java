package Bai17_PageObjectModel.testcases;

import Bai11_Assert.common.BaseTest;
import Bai17_PageObjectModel.pages.BasePage;
import Bai18_PageFactory.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private BasePage basePage;

    @Test(priority = 1)
    public void testLoginSuccess() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

    }

    @Test(priority = 2)
    public void testLoginFailWithInvalidEmail() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFailWithEmailOrPasswordInvalid();
    }

    @Test(priority = 3)
    public void testLoginFailWithInvalidPassword() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456789");
        loginPage.verifyLoginFailWithEmailOrPasswordInvalid();
    }

    @Test(priority = 4)
    public void testLoginFailWithEmailNull() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("", "123456789");
        loginPage.verifyLoginFailWithEmailNull();
    }

    @Test(priority = 5)
    public void testLoginFailWithPasswordNull() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "");
        loginPage.verifyLoginFailWithPasswordNull();
    }

    @Test(priority = 6)
    public void testLogoutSuccess(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com","123456");
        loginPage.verifyLoginSuccess();

        basePage = new BasePage(driver);
        basePage.logoutsystem();
        loginPage.verifyLoginPageDisplay();

    }

}
