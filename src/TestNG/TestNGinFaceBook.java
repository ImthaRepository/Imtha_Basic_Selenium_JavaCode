package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGinFaceBook {
	WebDriver driver;

	@BeforeTest
	public void entry() {
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com");
	}

	@Test
	public void login() {
	driver.findElement(By.name("email")).sendKeys("absullah@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("12345685");
	driver.findElement(By.name("login")).click();
	}

	@Test
	public void login2() {
	driver.findElement(By.name("email")).sendKeys("absullacom");
	driver.findElement(By.id("pass")).sendKeys("1234");
	driver.findElement(By.name("login")).click();
	}

	@AfterTest
	public void close() {
	driver.close();
}
}