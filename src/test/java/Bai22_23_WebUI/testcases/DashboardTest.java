package Bai22_23_WebUI.testcases;

import Bai11_Assert.common.BaseTest;
import Bai22_23_WebUI.pages.DashboardPage;
import Bai22_23_WebUI.pages.LoginPage;
import Bai22_23_WebUI.pages.ProjectsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    private LoginPage loginpage;
    private DashboardPage dashboardpage;
    private ProjectsPage projectsPage;

    @Test
    public void testLabelProjectInProgress() {
        loginpage = new LoginPage(driver);

        dashboardpage = loginpage.loginCRM();

        dashboardpage.verifyDashBoardPageDisplay();
        dashboardpage.verifyTotalProjectsInProgress();

    }



}
