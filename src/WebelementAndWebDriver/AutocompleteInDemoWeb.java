package WebelementAndWebDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class AutocompleteInDemoWeb {
public static void main(String[] args) throws InterruptedException, AWTException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.automationtesting.in/AutoComplete.html");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebElement widg = driver.findElement(By.linkText("Widgets"));
	Actions a=new Actions(driver);
	a.moveToElement(widg).perform();
	driver.findElement(By.linkText("AutoComplete")).click();
	//Thread.sleep(1000);
	WebElement txtbox = driver.findElement(By.xpath("//input[@id='searchbox']"));
	txtbox.sendKeys("india");
//	a.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
//	a.keyDown(Keys.ARROW_DOWN).perform();
//	a.keyUp(Keys.ARROW_DOWN).perform();
//	Thread.sleep(1000);
//	a.keyDown(Keys.ARROW_DOWN).perform();
//	a.keyUp(Keys.ARROW_DOWN).perform();
//	Thread.sleep(1000);
//	a.keyDown(Keys.ENTER).perform();
	Robot b=new Robot();
	b.keyPress(KeyEvent.VK_DOWN);
	b.keyRelease(KeyEvent.VK_DOWN);
	b.keyPress(KeyEvent.VK_DOWN);
	b.keyRelease(KeyEvent.VK_DOWN);
	b.keyPress(KeyEvent.VK_ENTER);
	b.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
	driver.quit();
}
}
