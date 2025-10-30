package Bai17_PageObjectModel.testcases;

import Bai11_Assert.common.BaseTest;
import Bai17_PageObjectModel.pages.DashboardPage;
import Bai18_PageFactory.pages.LoginPage;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    private LoginPage loginpage;
    private DashboardPage dashboardpage;

    @Test
    public void testLabelProjectInProgress(){
        loginpage = new LoginPage(driver);
        loginpage.loginCRM("admin@example.com", "123456");
        loginpage.verifyLoginSuccess();

        dashboardpage = new DashboardPage(driver);
        dashboardpage.verifyDashBoardPageDisplay();
        dashboardpage.verifyTotalProjectinPropress();


    }




}
