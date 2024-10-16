package Turbo;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class complete {
	WebDriver driver;
	@BeforeClass
public void Browser() {
	
	Scanner i=new Scanner(System.in);
	System.out.println("Enter the Browser Name");
	String browserName = i.nextLine();
	if (browserName.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();		
	}
	else if (browserName.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
		
	}
	else if (browserName.equalsIgnoreCase("Firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("404 not found");
		}
}
@Test
public void turboEntry() throws InterruptedException {
	driver.manage().window().maximize();
	driver.get("https://www.turbochargerpros.com");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	
	Thread.sleep(3000);
	WebElement year = driver.findElement(By.xpath("//div//select[@id='sel-year']"));
	//year.click();
	Select a =new Select(year);
	a.selectByVisibleText("2012");
	Thread.sleep(2000);
	WebElement make= driver.findElement(By.id("sel-make"));
	Select b =new Select(make);
	b.selectByVisibleText("Audi");
	Thread.sleep(3000);
	WebElement model = driver.findElement(By.id("sel-model"));
	Select c =new Select(model);
	c.selectByValue("A4_");
	Thread.sleep(3000);
	WebElement part = driver.findElement(By.id("ti-sel-part"));
	Select d=new Select(part);
	d.selectByValue("Turbocharger");
	Thread.sleep(3000);
	WebElement fram = driver.findElement(By.id("webWidget"));
	driver.switchTo().frame(fram);
	driver.findElement(By.xpath("//div//button[@data-garden-id='buttons.icon_button']")).click();
	driver.switchTo().defaultContent();
	Thread.sleep(1000);	
	driver.findElement(By.id("sub")).click();
}
@Test (priority = 2)
public void Addtocart() throws InterruptedException {
	driver.findElement(By.xpath("//input[@class='addtocart_btn' and @value='Add To Cart' and @type='submit']")).click();
	Thread.sleep(6000);
	WebElement year = driver.findElement(By.xpath("//div//select[@id='sel-year']"));
	Select a =new Select(year);
	a.selectByVisibleText("2014");
	Thread.sleep(3000);
	WebElement make= driver.findElement(By.id("sel-make"));
	Select b =new Select(make);
	b.selectByVisibleText("BMW");
	Thread.sleep(3000);
	WebElement model = driver.findElement(By.id("sel-model"));
	Select c =new Select(model);
	c.selectByValue("3DX");
	Thread.sleep(3000);
	WebElement part = driver.findElement(By.id("ti-sel-part"));
	Select d=new Select(part);
	d.selectByValue("Mass Air Flow Sensor Probe");
	Thread.sleep(3000);
	try {
	WebElement fram = driver.findElement(By.id("webWidget"));
	driver.switchTo().frame(fram);
	driver.findElement(By.xpath("//div//button[@data-garden-id='buttons.icon_button']")).click();
	driver.switchTo().defaultContent();
	// Thread.sleep(1000);	
		
	} catch (Exception e) {
		System.out.println("proper running");
	}
	driver.findElement(By.id("sub")).click();
	driver.findElement(By.xpath("//input[@class='addtocart_btn' and @value='Add To Cart' and @type='submit']")).click();


}
@Test(priority = 3)
public void cart() throws InterruptedException {
	Thread.sleep(2000);
	for (int i = 0; i <= 1; i++) {
		driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[@class='fa fa-minus'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[2]")).click();
			
	}
	Thread.sleep(2000);
	for (int i = 0; i < 2; i++) {
		driver.findElement(By.xpath("(//div[@class='col-lg-2 text-left']//i[@class='fa fa-trash-o'])[2]")).click();
		Thread.sleep(1000);
	
	}
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Checkout now ']")).click();

}
}
