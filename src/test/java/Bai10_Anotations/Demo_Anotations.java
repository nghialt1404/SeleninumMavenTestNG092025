package Bai10_Anotations;

import org.testng.annotations.*;

public class Demo_Anotations {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Chạy trước toàn bộ suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Chạy sau toàn bộ suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Chạy trước tất cả các test trong một thẻ <test>");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Chạy sau tất cả các test trong một thẻ <test>");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Chạy trước tất cả các test trong class này");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Chạy sau tất cả các test trong class này");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Chạy trước mỗi phương thức test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Chạy sau mỗi phương thức test");
    }

    @BeforeGroups("login")
    public void beforeGroup() {
        System.out.println("beforeGroup Chạy trước nhóm test login");
    }

    @Test(groups = {"login"})
    public void testLoginSuccess() {
        System.out.println("Thực hiện kiểm thử đăng nhập - Success");
    }

    @Test(groups = {"login"})
    public void testLoginFailWithEmailInvalid() {
        System.out.println("testLoginFailWithEmailInvalid");
    }

    @Test
    public void testLoginFailWithPasswordInvalid() {
        System.out.println("testLoginFailWithPasswordInvalid");
    }

    @Test
    public void testLoginFailWithEmailNull() {
        System.out.println("testLoginFailWithEmailNull");
    }

}
