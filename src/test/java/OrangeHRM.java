import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRM
{
    WebDriver driver;

    @BeforeMethod
    void preconditions(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(priority = 1)
    void LoginToOrangeHRM(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();
    }
    @Test(priority = 2)
    void VerifyAbleToNavigateAllPages(){
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        driver.findElement(By.xpath("//span[text()='Leave']")).click();
        driver.findElement(By.xpath("//span[text()='Time']")).click();
        driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        driver.findElement(By.xpath("//span[text()='Performance']")).click();
        driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
        driver.findElement(By.xpath("//span[text()='Directory']")).click();
        driver.findElement(By.xpath("//span[text()='Maintenance']")).click();
        driver.findElement(By.xpath("//span[text()='Claim']")).click();
        driver.findElement(By.xpath("//span[text()='Buzz']")).click();

    }
}
