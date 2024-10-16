package Sundaram;

import java.io.File;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;



	import org.openqa.selenium.By;

	import org.openqa.selenium.OutputType;

	import org.openqa.selenium.TakesScreenshot;

	import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.WebElement;

	import org.openqa.selenium.chrome.ChromeDriver;

	import org.openqa.selenium.io.FileHandler;

	import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

	import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

	public class sundaram1 {	

		WebDriver driver;



		@BeforeTest

		public void Login() {

			driver = new ChromeDriver();

			driver.get("https://gcp-app.apptivo.net/app/login.jsp");

			driver.manage().window().fullscreen();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.findElement(By.id("login_email")).sendKeys("testApp2024@berijam.com");

			driver.findElement(By.id("login_password")).sendKeys("Welcome123$");

			driver.findElement(By.xpath("//button[@title='Sign In']")).click();

			driver.manage().window().maximize();

			driver.findElement(By.xpath("//a[contains(text(),'Financials')]")).click();

		}



		// Invoice App Loading

		@Test(priority = 1)

		public void Invoice() {

			driver.get("https://gcp-app.apptivo.net/app/invoice.jsp#/dashboard/show-all/");

			WebElement invoiceapp = driver.findElement(By.xpath("//span[@class=\"fltlft pdtp3 pdlft4px tit\"]"));

			String act = invoiceapp.getText();

			String exp = "INVOICE";

			Assert.assertEquals(exp, act);

		}



		@Test (priority = 2)

		public void Estimate()

		   {

		   driver.get("https://gcp-app.apptivo.net/app/estimates.jsp#/dashboard/show-all/");

		   WebElement estimateapp = driver.findElement(By.xpath("//span[@class=\"fltlft pdtp3 pdlft4px tit\"]"));

		   String act = estimateapp.getText();

		   String exp = "ESTIMATES";

		   Assert.assertEquals(exp, act);

		    }



	  

	  @AfterMethod

	  public void screenshot(ITestResult result) throws IOException 

	       { 

			
		   Date currentdate=new Date();
		   String screenshotname=currentdate.toString().replace(" ", "-").replaceAll(":", "-");
		   
	       TakesScreenshot ts=(TakesScreenshot)driver; 

	       File src=ts.getScreenshotAs(OutputType.FILE);

	       FileHandler.copy(src,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\screenshot\\"+screenshotname+"-"+result.getName()+".png")); 

	       }

	  

	  }

