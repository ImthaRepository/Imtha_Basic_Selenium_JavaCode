package WebelementAndWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Actions {
public static void main(String[] args) {
	WebDriver driver= new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	
	WebElement forgot = driver.findElement(By.linkText("Forgotten password?"));
	org.openqa.selenium.interactions.Actions c=new org.openqa.selenium.interactions.Actions(driver);
	c.click(forgot).perform();
	driver.close();
}
}
