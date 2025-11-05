package Bai24_Paremeters_Multibrowser.testcases;

import Bai11_Assert.common.BaseTest;
import Bai24_Paremeters_Multibrowser.pages.DashboardPage;
import Bai24_Paremeters_Multibrowser.pages.LoginPage;
import Bai24_Paremeters_Multibrowser.pages.ProjectsPage;
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
