package Bai19_NavigationPage.testcases;

import Bai11_Assert.common.BaseTest;
import Bai19_NavigationPage.pages.DashboardPage;
import Bai19_NavigationPage.pages.LoginPage;
import Bai19_NavigationPage.pages.ProjectsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    private LoginPage loginpage;
    private DashboardPage dashboardpage;
    private ProjectsPage projectsPage;

    @Test
    public void testLabelProjectInProgress(){
        loginpage = new LoginPage(driver);

        dashboardpage = loginpage.loginCRM();

        dashboardpage.verifyDashBoardPageDisplay();

        String totalProjectOnDashBoard = dashboardpage.getTotalProjectinPropress();

        projectsPage = dashboardpage.clickMenuProject(); // chuyển sang trang Project

        //
        Assert.assertEquals(totalProjectOnDashBoard,projectsPage.getTotalProjectInProgress() + " / " + projectsPage.getTotalProjects(),"Total Project on Dashboard does not match with Total Project in Projects page");
    }



}
