import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
    @Test(priority = 6)
    void VerifyAbleToAddAdminUser(){
       Actions action =new Actions(driver);
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        driver.findElement(By.xpath("//button[text()=' Add ']")).click();
        WebElement UserRoleDropDown = driver.findElement(By.xpath("(//div[text()='-- Select --'])[1]"));
        action.click(UserRoleDropDown).pause(1000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        WebElement HintTextField = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        action.sendKeys(HintTextField,"1").pause(2000).sendKeys(HintTextField,Keys.ARROW_DOWN).pause(2000).
                sendKeys(HintTextField,Keys.ENTER).sendKeys(HintTextField,Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).
                sendKeys(Keys.TAB).sendKeys("11223344").
                sendKeys(Keys.TAB).sendKeys("1234567890-q").sendKeys(Keys.TAB).sendKeys("1234567890-q").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }
    @Test(priority = 7)
    void VerifyAbleToDeletAllUser() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[1]")).click();
        WebElement DeleteCheckbox = driver.findElement(By.xpath("//button[text()=' Delete Selected ']"));
        if(DeleteCheckbox.isDisplayed()){
            DeleteCheckbox.click();
        }
        else {
            System.err.println("Delete Selected Button Is Not Displayed....");
        }

        WebElement DeleteButton = driver.findElement(By.xpath("//button[text()=' Yes, Delete ']"));
        if(DeleteButton.isDisplayed()){
            DeleteButton.click();
        }
        else {
            System.err.println("Delete Button Is Not Displayed....");
        }
    }
    @Test(priority = 8)
    void VerifyAdminTabAllDropDownAbleToSelectAllOption(){
        //Admin Page->Job DropDown Options
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        driver.findElement(By.xpath("//span[text()='Job ']")).click();
        driver.findElement(By.xpath("//a[text()='Job Titles']")).click();
        driver.findElement(By.xpath("//span[text()='Job ']")).click();
        driver.findElement(By.xpath("//a[text()='Pay Grades']")).click();
        driver.findElement(By.xpath("//span[text()='Job ']")).click();
        driver.findElement(By.xpath("//a[text()='Employment Status']")).click();
        driver.findElement(By.xpath("//span[text()='Job ']")).click();
        driver.findElement(By.xpath("//a[text()='Job Categories']")).click();
        driver.findElement(By.xpath("//span[text()='Job ']")).click();
        driver.findElement(By.xpath("//a[text()='Work Shifts']")).click();

        //Admin Tab->Organization Options
        driver.findElement(By.xpath("//span[text()='Organization ']")).click();
        driver.findElement(By.xpath("//a[text()='General Information']")).click();
        driver.findElement(By.xpath("//span[text()='Organization ']")).click();
        driver.findElement(By.xpath("//a[text()='Locations']")).click();
        driver.findElement(By.xpath("//span[text()='Organization ']")).click();
        driver.findElement(By.xpath("//a[text()='Structure']")).click();

        //Admin Tab->Qualifications Options
        driver.findElement(By.xpath("//span[text()='Qualifications ']")).click();
        driver.findElement(By.xpath("//a[text()='Skills']")).click();
        driver.findElement(By.xpath("//span[text()='Qualifications ']")).click();
        driver.findElement(By.xpath("//a[text()='Education']")).click();
        driver.findElement(By.xpath("//span[text()='Qualifications ']")).click();
        driver.findElement(By.xpath("//a[text()='Licenses']")).click();
        driver.findElement(By.xpath("//span[text()='Qualifications ']")).click();
        driver.findElement(By.xpath("//a[text()='Languages']")).click();
        driver.findElement(By.xpath("//span[text()='Qualifications ']")).click();
        driver.findElement(By.xpath("//a[text()='Memberships']")).click();


        //Admin Tab->Configuration Options
        driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
        driver.findElement(By.xpath("//a[text()='Email Configuration']")).click();
        driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
        driver.findElement(By.xpath("//a[text()='Email Subscriptions']")).click();
        driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
        driver.findElement(By.xpath("//a[text()='Localization']")).click();
        driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
        driver.findElement(By.xpath("//a[text()='Language Packages']")).click();
        driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
        driver.findElement(By.xpath("//a[text()='Modules']")).click();
        driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
        driver.findElement(By.xpath("//a[text()='Social Media Authentication']")).click();
        driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
        driver.findElement(By.xpath("//a[text()='Register OAuth Client']")).click();
        driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
        driver.findElement(By.xpath("//a[text()='LDAP Configuration']")).click();

    }
   @AfterClass
    void PostConditions(){
        driver.quit();
    }

}
