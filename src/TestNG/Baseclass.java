package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Baseclass {
	WebDriver driver;
	Properties p=new Properties();
	@BeforeClass
	public void chooseBrowser() {
	
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
		
		;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
}
