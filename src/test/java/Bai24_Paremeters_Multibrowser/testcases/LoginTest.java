package Bai24_Paremeters_Multibrowser.testcases;

import Bai11_Assert.common.BaseTest;
import Bai24_Paremeters_Multibrowser.pages.BasePage;
import Bai24_Paremeters_Multibrowser.pages.LoginPage;
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
        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
    }

    @Test(priority = 3)
    public void testLoginFailWithInvalidPassword() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456789");
        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
    }

    @Test(priority = 4)
    public void testLoginFailWithEmailNull() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("", "123456789");
        loginPage.verifyLoginFailureWithEmailNull();
    }

    @Test(priority = 5)
    public void testLoginFailWithPasswordNull() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "");
        loginPage.verifyLoginFailureWithPasswordNull();
    }

    @Test(priority = 6)
    public void testLogoutSuccess() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        basePage = new BasePage(driver);
        basePage.logoutsystem();
        loginPage.verifyLoginPageDisplayed();

    }

}
