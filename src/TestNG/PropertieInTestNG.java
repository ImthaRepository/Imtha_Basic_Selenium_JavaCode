package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class PropertieInTestNG {
	    static Properties p = new Properties();  
	    static String url, first, last, mobile, pass, email, day, month, year;
@BeforeMethod
public void assign() throws IOException  {

	   FileInputStream f=new FileInputStream("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\src\\TestNG\\Input.properties");
	   p.load(f);
	
		  url=p.getProperty("url");
	
	      first=p.getProperty("firstname");
	
		  last=p.getProperty("lastname");
	
		  mobile=p.getProperty("mobile");
		
		  pass=p.getProperty("password");
		
		  email=p.getProperty("email");
	
		  day=p.getProperty("day");
	
		  month=p.getProperty("month");

		  year=p.getProperty("year");
}
//	    WebDriver driver;
//	
//	 @BeforeMethod
//	
//	    public void before() {
//		WebDriver driver=new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//	}
	 
@Test
public void create() throws InterruptedException{
	 {
		
		//driver.get(url);
		
		
		//Create an Account
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(2000);
		
		//firstname
		driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]")).sendKeys(first);
		
		//lastname
		driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[2]")).sendKeys(last);
		
		//email
		driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[3]")).sendKeys(email);
		
		//confirm email
		
		//driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[4]")).sendKeys(p.getProperty("email"));
		
		//password
		driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[5]")).sendKeys(pass);
		
		//DOB
		WebElement date = driver.findElement(By.xpath("(//*[@class='_9407 _5dba _9hk6 _8esg'])[1]"));
		Select a=new Select(date);	
		a.selectByVisibleText(day);
		WebElement months = driver.findElement(By.xpath("(//*[@class='_9407 _5dba _9hk6 _8esg'])[2]"));
		Select b=new Select(months);
		b.selectByVisibleText(month);
		WebElement years = driver.findElement(By.xpath("(//*[@class='_9407 _5dba _9hk6 _8esg'])[3]"));
		Select c=new Select(years);
		c.selectByValue(year);
		driver.findElement(By.xpath("(//*[@class='_8esa'])[1]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[@class='_8esa'])[3]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[@class='_8esa'])[2]")).click();

	}	
	
}		}