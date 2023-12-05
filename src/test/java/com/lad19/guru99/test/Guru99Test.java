/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.lad19.guru99.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author ADMIN
 */
public class Guru99Test {

    static WebDriver myBrowser;
    
    //Test case #1: check the login process of Demo Guru99 in successful case
    //       Steps: 
    //              1.Open a certain browser, e.g.Chrome
    //              2.Navigate to Demo Guru99 login page
    //                by the url: https://demo.guru99.com/v4
    //              3.Input a valid account into the Login page
    //                  e.g. mngr533979/EjAnary
    //              4.Hit [login] button to process the login form
    //EXPECTED RESULT:
    //                  A new dashboard page is showed
    //                  with a welcome message is under the format of
    //                  Manger Id: <user-name>
    
    @Test  //code để test cái gì đó nằm ở đây
           //code để tự dộng hóa các test case nằm ở đây
           //assertEquals() nằm ở đây
    public void CheckLoginGivenValidAccountLoginSuccessfully() throws InterruptedException {
     
        myBrowser = new ChromeDriver();
        myBrowser.get("https://demo.guru99.com/v4");
        myBrowser.manage().window().maximize();
        //đưa valid account vào, ta phải đi tìm các tag của màn hình login
        WebElement txtUsername = myBrowser.findElement(By.xpath("//input[@name='uid']"));
        txtUsername.sendKeys("mngr533979");
        
        WebElement txtPassword = myBrowser.findElement(By.xpath("//input[@name='password']"));
        txtPassword.sendKeys("EjAnary");
        
        WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
        btnLogin.click(); //enter để submit là submit(), click mouse là 
        
        //đảm bảo bắt được tag ở trang mới, ta cần wait 1 chút
        //code cứ nhắm mắt chạy, trang thì ch kịp tải về do mạng lag
        //ko wait code ko ổn định: mạng nhanh oke, mạng chậm failed tìm tag
        Thread.sleep(1000);
        
        //chuyển trang, bắt tag welcome
        WebElement lblMessage = myBrowser.findElement(By.cssSelector("tr[class='heading3'] td"));
        String welcomeMessage = lblMessage.getText();
//        System.out.println("Message: " + welcomeMessage);
        assertEquals("Manger Id : mngr533979", welcomeMessage);
        
    }

    @BeforeAll  //hàm này sẽ chạy trước tất cả các @Test nếu có 
                //đi đầu tiên, dùng để thiết lập môi trường kiểm thử
                //khởi động các biến gì đó sẽ dùng ở @Test
    public static void setUpClass() {
        
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //mở ẩn danh, tiếng Hàn, Nhật ở đây
    }

    @AfterAll   //chạy tất cả, sau khi các @Test đã xong thì thằng này chạy
                //Nó dùng để dọn dẹp những thứ mà @Test bày ra
                //ví dụ xóa data trong table trong việc chạy @Test insert vào
    public static void tearDownClass() throws InterruptedException {
        
        Thread.sleep(3000); 
        myBrowser.quit(); //đóng trình duyệt, dọn dẹp ram
    }

}
