package BrowserEntryBasics;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleBrowser  {

public static void main(String[] args) {
	WebDriver driver;
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
}