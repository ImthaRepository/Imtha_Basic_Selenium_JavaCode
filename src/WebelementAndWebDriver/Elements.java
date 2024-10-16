package WebelementAndWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elements {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\RRR\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	WebElement username=driver.findElement(By.name("email"));
	username.sendKeys("absullah@gmail.com");
	Thread.sleep(4000);
	WebElement password=driver.findElement(By.id("pass"));
	password.sendKeys("12345685");
	Thread.sleep(4000);
	driver.close();
}
}
