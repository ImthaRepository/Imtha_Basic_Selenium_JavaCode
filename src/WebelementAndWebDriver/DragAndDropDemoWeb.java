package WebelementAndWebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemoWeb {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://demo.automationtesting.in/Dynamic.html");
	
//	WebElement logo1 = driver.findElement(By.xpath("//img[@id='angular']"));
	WebElement dragArea = driver.findElement(By.xpath("//div[@id='droparea']"));
	WebElement logo2 = driver.findElement(By.cssSelector("img#mongo"));
	//WebElement logo3 = driver.findElement(By.cssSelector("img#node"));
	JavascriptExecutor b=(JavascriptExecutor)driver;
	b.executeScript("arguments[0].scrollIntoView();",dragArea);
	Actions a=new Actions(driver);
	//a.clickAndHold(logo1).pause(Duration.ofSeconds(2)).moveToElement(dragArea).release().build().perform();
	//a.dragAndDrop(logo1, dragArea).perform();
	a.dragAndDrop(logo2, dragArea).perform();
	//a.dragAndDrop(logo3, dragArea).perform();
	//a.dragAndDrop(logo2, dragArea).perform();
	//Thread.sleep(5000);
	//driver.close();
	
			
}
}
