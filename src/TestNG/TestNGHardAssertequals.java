package TestNG;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGHardAssertequals {
WebDriver driver;
@BeforeTest
public void Webdriver() {
	Scanner input=new Scanner(System.in);
	System.out.println("Enter the Name of the Browser");
	String browsername=input.nextLine();
	if (browsername.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	} else if (browsername.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	} else if (browsername.equalsIgnoreCase("Edge")) {
		driver=new EdgeDriver();
	} else {
		System.out.println("No Browser Found Test Stops");
	}

	}
@Test
public void enterintotest() {

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://mail.google.com/mail");

	WebElement text1 = driver.findElement(By.xpath("//*[@class='gNJDp']"));
	String actual=text1.getText();
	System.out.println(actual);
	String expect="to contine to Gmail";
	Assert.assertEquals(expect, actual);




	WebElement text2 = driver.findElement(By.xpath("(//*[@class='VfPpkd-vQzf8d'])[5]"));
	String actual2=text2.getText();
	System.out.println(actual2);
	String expect2="Create account";
	Assert.assertEquals(expect2, actual2);
}

	@AfterTest
public void closebrowser() {
	driver.close();
}
}