package Bai10_Anotations;

import org.testng.annotations.*;

public class Demo_Anotations_2 {

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass2 Chạy trước tất cả các test trong class này");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass2 Chạy sau tất cả các test trong class này");
    }

    @Test
    public void testLoginSuccess() {
        System.out.println("Thực hiện kiểm thử đăng nhập - Success");
    }

    @Test
    public void testLoginFail() {
        System.out.println("Thực hiện kiểm thử đăng nhập - Fail");
    }


}
