package Sundaram;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import java.util.logging.FileHandler;



import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class sundram {


public static void main(String[] args) throws IOException, InterruptedException {

	   WebDriver driver = new ChromeDriver();

	   driver.get("https://gcp-app.apptivo.net/app/login.jsp");

	   driver.manage().window().maximize();

	   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	   driver.findElement(By.id("login_email")).sendKeys("quickbook2024@berijam.com");

	   driver.findElement(By.id("login_password")).sendKeys("Welcome123$5");

	   driver.findElement(By.xpath("//button[@title='Sign In']")).click();
	
//Invoice App
	   
	   driver.findElement(By.xpath("//li[@class='dropdown appmoreul']//a[text()=' More']")).click();
	   
	   WebElement finance = driver.findElement(By.xpath("(//li//a[@class='sublistcnt posrel']//span[text()='Financials'])[2]"));
	   Actions a=new Actions(driver);
	   a.moveToElement(finance).perform();
	  
	   driver.findElement(By.xpath("//a//span[@ng-bind='displayNumberOfCharter(catsubItem.appName,18)'and text()='Invoice']")).click();

	

      // driver.get("https://gcp-app.apptivo.net/app/invoice.jsp#/dashboard/show-all/");

      // WebElement invoiceapp = driver.findElement(By.xpath("//span[@class=\"fltlft pdtp3 pdlft4px tit\"]"));

	    

      //  String act=invoiceapp.getText();

 	  //  String Exp="Invoice";

	  // Assert.assertEquals(Exp, act);
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File src=ts.getScreenshotAs(OutputType.FILE);

	   org.openqa.selenium.io.FileHandler.copy(src,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\screeshots\\sundram.png"));
	   	
//Estimate App
       
	   driver.findElement(By.xpath("//li[@class='dropdown appmoreul']//a[text()=' More']")).click();
	  
       WebElement estimate = driver.findElement(By.xpath("(//li//a[@class='sublistcnt posrel']//span[text()='Financials'])[2]"));
	   a.moveToElement(estimate).perform();
	  
	   driver.findElement(By.xpath("//a//span[@ng-bind='displayNumberOfCharter(catsubItem.appName,18)'and text()='Estimatesfgdd']")).click();
	   
	   File src1=ts.getScreenshotAs(OutputType.FILE);
	   org.openqa.selenium.io.FileHandler.copy(src1,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\screeshots\\sundram1.png"));

       //     driver.get("https://gcp-app.apptivo.net/app/estimates.jsp#/dashboard/show-all/");

//Project App

	  // driver.get("https://gcp-app.apptivo.net/app/projects.jsp#/home");
	   driver.findElement(By.xpath("//li[@class='dropdown appmoreul']//a[text()=' More']")).click();
	   driver.findElement(By.xpath("(//li//a[@class='sublistcnt posrel']//span[text()='Financials'])[2]"));
		
	   File src2=ts.getScreenshotAs(OutputType.FILE);
	   org.openqa.selenium.io.FileHandler.copy(src2,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\screeshots\\sundram1.png"));

}



	}



