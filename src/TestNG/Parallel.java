package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Parallel {
WebDriver driver;
	
@Test
	public void method1() {
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.findElement(By.id("email")).sendKeys("imtha");
	driver.findElement(By.id("pass")).sendKeys("imtha123");
	driver.findElement(By.name("login")).click();
}
@Test
public void method2() {
	driver=new FirefoxDriver();
	driver.get("https://www.facebook.com/");
	driver.findElement(By.id("email")).sendKeys("imthadu");
	driver.findElement(By.id("pass")).sendKeys("imtha1234");
	driver.findElement(By.name("login")).click();
}
}
