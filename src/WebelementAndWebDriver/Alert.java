package WebelementAndWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://demo.automationtesting.in/Alerts.html");

	driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
	Thread.sleep(1000);
	org.openqa.selenium.Alert a=driver.switchTo().alert();
	Thread.sleep(1000);
	a.accept();
	
	Thread.sleep(3000);
	driver.findElement(By.linkText("Alert with OK & Cancel")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
	Thread.sleep(1000);
	a.dismiss();
	
	Thread.sleep(3000);
	driver.findElement(By.linkText("Alert with Textbox")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
	a.sendKeys("hi");
	Thread.sleep(1000);
	a.dismiss();
	
	Thread.sleep(6000);
	driver.quit();
	//Thread.sleep(2000);
	
	

}}