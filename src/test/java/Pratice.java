import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Pratice
{
	WebDriver driver;// Webdriver Interface Reference to Access Browser App and methods.

	@BeforeClass     //Before Annotations Execute the Test Methods
	void Preconditions() 
	{
		driver=new ChromeDriver();//Creation Of Chrome Driver Instance
		driver.manage().window().maximize();//Maximize the Browser Window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Synchronize the Scripts By Implicit Wait
		driver.get("https://app.germanyiscalling.com/common/login/");//Trigger The Url
	}
	
	//Verify User Should Be Able To Successful Login With Valid Credetails
	
	@Test(priority = 1)//priority annotation executes the test method according user input priority
	void Valid_Username_and_Password() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("siva29042003@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).submit();
		driver.findElement(By.id("dropdownUser1")).click();
		driver.findElement(By.xpath("//a[@href='/common/logout/']")).click();
		Thread.sleep(1000);
	}
	@Test(priority = 2)
	void Valid_Username_and_Password_with_Case_Sensitivity() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("SIVA29042003@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).submit();
		driver.findElement(By.id("dropdownUser1")).click();
		driver.findElement(By.xpath("//a[@href='/common/logout/']")).click();
		Thread.sleep(3000);
	}

	//Verify Error Message Should Be Display For Invalid Credentials
	@Test(priority = 3)
	void Invalid_Username() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("siva");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);//Thread.sleep methods stops exectution for 1 seconds for synchronize purpose

		driver.findElement(By.id("username")).sendKeys("12335464568");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("username")).sendKeys("!@#$%^^&*><>");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("username")).sendKeys("siva1234");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("username")).sendKeys("siva!@#$%");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
	}

	@Test(priority = 4)
	void Invalid_Password() throws InterruptedException {
		
		driver.findElement(By.id("username")).sendKeys("sivasankar");
		driver.findElement(By.id("password")).sendKeys("10092024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("sivasankar");
		driver.findElement(By.id("password")).sendKeys("Myjobistesting");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("sivasankar");
		driver.findElement(By.id("password")).sendKeys("@!@#$%^%2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("sivasankar");
		driver.findElement(By.id("password")).sendKeys("Myjob@---2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("sivasankar");
		driver.findElement(By.id("password")).sendKeys("Myjob2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);

	}
	@Test(priority = 5)
	void Both_Username_and_Password_Invalid() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("!@#$%^^&*><>");
		driver.findElement(By.id("password")).sendKeys("@!@#$%^%2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("siva1234");
		driver.findElement(By.id("password")).sendKeys("Myjob2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("12335464568");
		driver.findElement(By.id("password")).sendKeys("2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		
		
	}
	@Test(priority = 6)
	void Username_or_Password_Empty() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
	}
	@Test(priority = 7)
	void Username_and_Password_Too_Short() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("abc");
		driver.findElement(By.id("password")).sendKeys("My");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
	}
	@AfterClass
	void PostConditions(){
		driver.manage().window().minimize();
		driver.quit();
	}

}
