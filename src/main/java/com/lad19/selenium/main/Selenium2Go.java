/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lad19.selenium.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author ADMIN
 */
public class Selenium2Go {

    static WebDriver myBrowser;
    //biến trỏ đến tab trình duyệt
    //trong OOP, cái gì cũng là object, phải new, tốn ram
    //1 tab trình duyệt là 1 object trong RAM, có UI ra bên ngoài
    
    //muốn có trình duyệt xuất hiện thì phải new()
    
    
    public static void main(String[] args) throws InterruptedException {
        //Nạp cái driver là file.exe vào máy ảo Java để lắng nghe
        //những hành dộng code của mình và nó chuyển lại cho trình duyệt
        //tương đương câu lệnh Class.forName(jdbc driver); môn JavaWeb
        System.out.println();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        
        
        //mở trình duyệt ẩn danh
        ChromeOptions opt = new ChromeOptions();
//        opt.addArguments("--incognito");
//        opt.addArguments("--lang=ar-AE");
        //gọi trình duyệt xuất hiện
        myBrowser = new ChromeDriver(opt);
        
        //lúc này myBrowser sẻ trỏ thằng vào tab mình vừa mở
        //chấm là bắt trình duyệt làm việc gì đó
        
        //bung full màn hình
        myBrowser.manage().window().maximize();
        
        //duyệt web tải trang về
        myBrowser.get("https://google.com");
        
        //ta đi tìm các tags - thẻ, để sau đó gọi các event trên tag
        //hoặc là đưa data vào tag
        //mọi tag trong trang web đều là object: WebElement
        //tìm 1 tag trong trang web giống như select 1 dòng trong table
        //ta phải viết ra câu query để tìm tag như vieesy SQL tìm data trong CSDL
        //có nhiều cách để query 1 tag: query theo name của tag
        //                                         id, tên tag, css, html
        
        WebElement searchBox = myBrowser.findElement(By.name("q"));
        
        searchBox.sendKeys("Đất rừng phương nam");
        searchBox.submit();//nhấn enter để search
        
        //mỗi khi ta tắt tab trình duyệt, driver vẫn nằm trong RAM
        //ko đc xài đến, RAM giảm dung lượng dần dần - MEMORY LEAKING
        //TA PHẢI TẮT TRÌNH DUYỆT ĐÚNG CHUẨN ĐỂ FREE LUÔN CẢ DRIVER
        
        Thread.sleep(3000); //dừng cpu, đừng chạy đóng trình duyệt
                                 //sau hết 3s hãy làm
        
        myBrowser.quit(); //tắt trình duyệt và gỡ luôn driver khỏi ram
        
        
    }
}
