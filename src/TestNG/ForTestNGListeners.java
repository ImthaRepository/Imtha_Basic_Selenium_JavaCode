package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNG.Listeners.class)
public class ForTestNGListeners {
WebDriver driver=new ChromeDriver();
@Test
public void facebooklogin() {
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	driver.findElement(By.id("email")).sendKeys("imtha");
	driver.findElement(By.id("pass")).sendKeys("12345");
	driver.close();
}
@Test
public void gmail() {
	System.out.println("this create for failure");
	Assert.assertTrue(false);
}
@Test
public void forskipping() {
	System.out.println("This create for skip");
	throw new SkipException("skipped");
}
@Test
public void facebooklog() {
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	driver.findElement(By.id("email")).sendKeys("imtha");
	driver.findElement(By.id("pass")).sendKeys("12345");
	driver.close();
}
}