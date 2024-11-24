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
    Actions action;


    @BeforeClass
    void preconditions(){
        driver=new EdgeDriver();
        action =new Actions(driver);
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
       @Test(priority = 9)
       void VerifyAllOptionDisplayingPIMTab(){

           //PIM Configuration Tab Dropdown Options
           driver.findElement(By.xpath("//span[text()='PIM']")).click();
           driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
           driver.findElement(By.xpath("//a[text()='Optional Fields']")).click();
           driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
           driver.findElement(By.xpath("//a[text()='Custom Fields']")).click();
           driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
           driver.findElement(By.xpath("//a[text()='Data Import']")).click();
           driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
           driver.findElement(By.xpath("//a[text()='Reporting Methods']")).click();
           driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
           driver.findElement(By.xpath("//a[text()='Termination Reasons']")).click();

           driver.findElement(By.xpath("//a[text()='Employee List']")).click();
           driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
           driver.findElement(By.xpath("//a[text()='Reports']")).click();

       }
       @Test(priority = 10)
       void VerifyAllOptionDisplayingLeaveTab(){
           driver.findElement(By.xpath("//span[text()='Leave']")).click();
           driver.findElement(By.xpath("//a[text()='Apply']")).click();
           driver.findElement(By.xpath("//a[text()='My Leave']")).click();

           //Entitlements Dropdown Options
           driver.findElement(By.xpath("//span[text()='Entitlements ']")).click();
           driver.findElement(By.xpath("//a[text()='Add Entitlements']")).click();
           driver.findElement(By.xpath("//span[text()='Entitlements ']")).click();
           driver.findElement(By.xpath("//a[text()='Employee Entitlements']")).click();
           driver.findElement(By.xpath("//span[text()='Entitlements ']")).click();
           driver.findElement(By.xpath("//a[text()='My Entitlements']")).click();

           //Reports Dropdown Options
           driver.findElement(By.xpath("//span[text()='Reports ']")).click();
           driver.findElement(By.xpath("//a[text()='Leave Entitlements and Usage Report']")).click();
           driver.findElement(By.xpath("//span[text()='Reports ']")).click();
           driver.findElement(By.xpath("//a[text()='My Leave Entitlements and Usage Report']")).click();

           //Configure Dropdown Options
           driver.findElement(By.xpath("//span[text()='Configure ']")).click();
           driver.findElement(By.xpath("//a[text()='Leave Period']")).click();
           driver.findElement(By.xpath("//span[text()='Configure ']")).click();
           driver.findElement(By.xpath("//a[text()='Leave Types']")).click();
           driver.findElement(By.xpath("//span[text()='Configure ']")).click();
           driver.findElement(By.xpath("//a[text()='Work Week']")).click();
           driver.findElement(By.xpath("//span[text()='Configure ']")).click();
           driver.findElement(By.xpath("//a[text()='Holidays']")).click();

           driver.findElement(By.xpath("//a[text()='Leave List']")).click();
           driver.findElement(By.xpath("//a[text()='Assign Leave']")).click();
       }
       @Test(priority = 11)
       void Verify_All_Option_Displaying_Time_Tab(){
           driver.findElement(By.xpath("//span[text()='Time']")).click();

           //Timesheets Dropdown Options
           driver.findElement(By.xpath("//span[text()='Timesheets ']")).click();
           driver.findElement(By.xpath("//a[text()='My Timesheets']")).click();
           driver.findElement(By.xpath("//span[text()='Timesheets ']")).click();
           driver.findElement(By.xpath("//a[text()='Employee Timesheets']")).click();


           //Attendance Dropdown Options
           driver.findElement(By.xpath("//span[text()='Attendance ']")).click();
           driver.findElement(By.xpath("//a[text()='My Records']")).click();
           driver.findElement(By.xpath("//span[text()='Attendance ']")).click();
           driver.findElement(By.xpath("//a[text()='Punch In/Out']")).click();
           driver.findElement(By.xpath("//span[text()='Attendance ']")).click();
           driver.findElement(By.xpath("//a[text()='Employee Records']")).click();
           driver.findElement(By.xpath("//span[text()='Attendance ']")).click();
           driver.findElement(By.xpath("//a[text()='Configuration']")).click();

           //Reports Dropdown Options
           driver.findElement(By.xpath("//span[text()='Reports ']")).click();
           driver.findElement(By.xpath("//a[text()='Project Reports']")).click();
           driver.findElement(By.xpath("//span[text()='Reports ']")).click();
           driver.findElement(By.xpath("//a[text()='Employee Reports']")).click();
           driver.findElement(By.xpath("//span[text()='Reports ']")).click();
           driver.findElement(By.xpath("//a[text()='Attendance Summary']")).click();

           //Project Info Dropdown Options
           driver.findElement(By.xpath("//span[text()='Project Info ']")).click();
           driver.findElement(By.xpath("//a[text()='Customers']")).click();
           driver.findElement(By.xpath("//span[text()='Project Info ']")).click();
           driver.findElement(By.xpath("//a[text()='Projects']")).click();
       }
       @Test(priority = 12)
       void Verify_AllOptions_Displaying_Recuritment(){
           driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
           driver.findElement(By.xpath("//a[text()='Candidates']")).click();
           driver.findElement(By.xpath("//a[text()='Vacancies']")).click();
       }
     @Test(priority = 13)
     void Verify_All_Option_Displaying_Performance() {
         driver.findElement(By.xpath("//span[text()='Performance']")).click();
         //Configure Dropdown Options
         driver.findElement(By.xpath("//span[text()='Configure ']")).click();
         driver.findElement(By.xpath("//a[text()='KPIs']")).click();
         driver.findElement(By.xpath("//span[text()='Configure ']")).click();
         driver.findElement(By.xpath("//a[text()='Trackers']")).click();


         //Manage Reviews Dropdown Options
         driver.findElement(By.xpath("//span[text()='Manage Reviews ']")).click();
         driver.findElement(By.xpath("//a[text()='Manage Reviews']")).click();
         driver.findElement(By.xpath("//span[text()='Manage Reviews ']")).click();
         driver.findElement(By.xpath("//a[text()='My Reviews']")).click();
         driver.findElement(By.xpath("//span[text()='Manage Reviews ']")).click();
         driver.findElement(By.xpath("//a[text()='Employee Reviews']")).click();


         //My Trackers Dropdown Options
         driver.findElement(By.xpath("//a[text()='My Trackers']")).click();
         //Employee Trackers Dropdown Options
         driver.findElement(By.xpath("//a[text()='Employee Trackers']")).click();

     }
    @Test(priority = 14)
    void Verify_All_Option_Displaying_Maintance(){
        driver.findElement(By.xpath("//span[text()='Maintenance']")).click();
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[text()=' Confirm ']")).click();
        driver.findElement(By.xpath("//span[text()='Purge Records ']")).click();
        driver.findElement(By.xpath("//a[text()='Employee Records']")).click();
        driver.findElement(By.xpath("//span[text()='Purge Records ']")).click();
        driver.findElement(By.xpath("//a[text()='Candidate Records']")).click();

        driver.findElement(By.xpath("//a[text()='Access Records']")).click();
    }
    @Test(priority = 15)
    void Verify_All_Option_Displaying_Claim(){
        //Configure Dropdown Options
        driver.findElement(By.xpath("//span[text()='Claim']")).click();
        driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
        driver.findElement(By.xpath("//a[text()='Events']")).click();
        driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
        driver.findElement(By.xpath("//a[text()='Expense Types']")).click();

        driver.findElement(By.xpath("//a[text()='Submit Claim']")).click();
        driver.findElement(By.xpath("//a[text()='My Claims']")).click();
        driver.findElement(By.xpath("//a[text()='Employee Claims']")).click();
        driver.findElement(By.xpath("//a[text()='Assign Claim']")).click();
    }
    @AfterClass
    void PostConditions(){
        driver.quit();
    }

}
