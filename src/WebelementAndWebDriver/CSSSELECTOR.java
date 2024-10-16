package WebelementAndWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CSSSELECTOR {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	
	
	driver.findElement(By.cssSelector("span.lbl_input.appendBottom10")).click();
	driver.findElement(By.cssSelector("input.react-autosuggest__input.react-autosuggest__input--open")).sendKeys("IXM");
	Thread.sleep(2000);
	Actions a= new Actions(driver);
	
	a.keyDown(Keys.ARROW_DOWN).perform();
	a.keyDown(Keys.ENTER).perform();
 }
}
