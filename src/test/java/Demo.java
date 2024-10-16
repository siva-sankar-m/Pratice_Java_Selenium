import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.time.Duration;

public class Demo
{
   WebDriver driver;

   @Test
   void test() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
        Thread.sleep(1000);
        WebElement SearchTextField = driver.findElement(By.name("search_query"));
        SearchTextField.sendKeys("Sdet-QA");
        Thread.sleep(1000);
        WebElement SearchIcon = driver.findElement(By.id("search-icon-legacy"));
        SearchIcon.click();
    }
}
