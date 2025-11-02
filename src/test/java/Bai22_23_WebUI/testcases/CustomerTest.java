package Bai22_23_WebUI.testcases;

import Bai11_Assert.common.BaseTest;
import Bai22_23_WebUI.pages.CustomersPage;
import Bai22_23_WebUI.pages.LoginPage;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    private LoginPage loginPage;
    private CustomersPage customersPage;
    @Test
    public void testAddNewCustomerSuccess(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com","123456");

        customersPage = new CustomersPage(driver);
        customersPage.clickMenuCustomersPage();
        customersPage.verifyCustomersPageDisplayed();


        customersPage.clickAddNewCustomer();
        customersPage.fillDataNewCustomer("Airfeed Ltd","VIP","USD","Vietnamese","Vietnam");
        customersPage.clickSaveButton();

        customersPage.verifyAddNewCustomerSuccess();

        customersPage.verifyCustomerDetails("Airfeed Ltd","VIP","USD","Vietnamese","Vietnam");
    }

}
