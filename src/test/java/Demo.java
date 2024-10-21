import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;

public class Demo
{
   WebDriver driver;

   @BeforeMethod
   void preconditions(){
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   }
   //@Test
   void searchyoutubechannel() throws InterruptedException {

        driver.get("https://www.youtube.com/");
        Thread.sleep(1000);
        WebElement SearchTextField = driver.findElement(By.name("search_query"));
        SearchTextField.sendKeys("Sdet-QA");
        Thread.sleep(1000);
        WebElement SearchIcon = driver.findElement(By.id("search-icon-legacy"));
        SearchIcon.click();
    }
    @Test
    void placemobileonflipkart() throws InterruptedException {
       driver.get("https://www.flipkart.com/");
       Thread.sleep(1000);
       driver.findElement(By.xpath("//a[@aria-label='Mobiles & Tablets']")).click();
       Thread.sleep(1500);
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,2900)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(@href,'/realme-p1-s')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='12 GB']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("pincodeInputId")).sendKeys("636014");
        driver.findElement(By.xpath("//span[text()='Check']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//span[text()='Place Order']")).click();
    }
}
