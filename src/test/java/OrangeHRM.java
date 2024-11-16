import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRM
{
    WebDriver driver;


    @BeforeClass
    void preconditions(){
        driver=new EdgeDriver();
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
        driver.findElement(By.xpath("//span[text()='Claim']")).click();
        driver.findElement(By.xpath("//span[text()='Buzz']")).click();

    }
    @Test(priority = 3)
    void VerifyAbleToCheckMaintance() {
        driver.findElement(By.xpath("//span[text()='Maintenance']")).click();
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[text()=' Confirm ']")).click();
    }
   @Test(priority = 4)
    void VerifyAbleToDownloadPersonalData() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Access Records']")).click();
        WebElement Serach = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        Serach.sendKeys("siva");
        Thread.sleep(2000);
        Serach.sendKeys(Keys.ARROW_DOWN);
        Serach.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//button[text()=' Search ']")).click();
        driver.findElement(By.xpath("//button[text()=' Download ']")).click();
    }
    @Test(priority = 5)
    void VerifyAllOptionDisplayingAdminTab(){
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        driver.findElement(By.xpath("//span[text()='User Management ']")).click();
        driver.findElement(By.xpath("//span[text()='Job ']")).click();
        driver.findElement(By.xpath("//span[text()='Organization ']")).click();
        driver.findElement(By.xpath("//span[text()='Qualifications ']")).click();
        driver.findElement(By.xpath("//a[text()='Nationalities']")).click();
        driver.findElement(By.xpath("//a[text()='Corporate Branding']")).click();
        driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
    }
   @AfterClass
    void PostConditions(){
        driver.quit();
    }

}
