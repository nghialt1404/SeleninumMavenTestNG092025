package Bai20_ThucHanhPOM.testcases;

import Bai11_Assert.common.BaseTest;
import Bai20_ThucHanhPOM.pages.CustomersPage;
import Bai20_ThucHanhPOM.pages.LoginPage;

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

        customersPage.verifyAddNewCustomerSuccess();

        customersPage.verifyCustomerDetails("Airfeed Ltd","VIP","USD","Vietnamese","Vietnam");
    }

}
