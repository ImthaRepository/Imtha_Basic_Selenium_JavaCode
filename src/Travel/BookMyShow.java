package Travel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookMyShow {
public static void main(String[] args) throws InterruptedException, AWTException {
	WebDriver driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.navigate().to("https://in.bookmyshow.com/");
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@placeholder='Search for your city']")).sendKeys("madurai");
	Thread.sleep(2000);
	//Actions a=new Actions(driver);
	//a.keyDown(Keys.ARROW_DOWN).perform();
	//a.keyUp(Keys.ARROW_DOWN)
	//a.keyDown(Keys.ENTER).perform();
	//div[@class='sc-133848s-4 kFcBGr']//div[@class='sc-7o7nez-0 daKrZU']
	
	Robot a=new Robot();
	a.keyPress(KeyEvent.VK_ENTER);
	a.keyRelease(KeyEvent.VK_ENTER);
	

	
	WebElement entry = driver.findElement(By.xpath("//div[@class='sc-7o7nez-0 dwoMuR']"));
	entry.click();
	
//Language Selection
	List<WebElement> lang = driver.findElements(By.xpath("//div[@class='sc-7o7nez-0 beKeQH']"));
	
	for (int j = 1; j <= lang.size(); j++) {
		WebElement langpath = driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 beKeQH'])["+j+"]"));
		String languages=langpath.getText();
		System.out.println(j+"."+languages);
		
			}
		Scanner z=new Scanner(System.in);
		System.out.println("Enter the Serial number of Your Language with in 8 seconds");
		int serial=z.nextInt();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 beKeQH'])["+serial+"]")).click();
		Thread.sleep(4000);
		
//MovieList and Selection of Movies
	List<WebElement> moviespath = driver.findElements(By.xpath("//div[@class='sc-7o7nez-0 hGuczM']"));
	System.out.println(moviespath.size());

	for (int i =1 ; i <=moviespath.size() ; i++) {
		
		String list ="(//div[@class='sc-7o7nez-0 hGuczM'])["+i+"]";
		WebElement name = driver.findElement(By.xpath(list));
		String namelist=name.getText();
		System.out.println(i+"."+namelist);
	}
	Scanner j =new Scanner(System.in);
	System.out.println("Enter the serial number of Movie within 15 seconds");
	int book= j.nextInt();
	Thread.sleep(20000);
	//(for book by movie name) driver.findElement(By.xpath("//div[text()='"+book+"']")).click();
	driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 hGuczM'])["+book+"]")).click();
	
//For Book
	Thread.sleep(4000);
	//driver.findElement(By.xpath("//div[@class='sc-qswwm9-8 goilWl']//div[@class='sc-1vmod7e-2 hhYlrx']")).click();
}
}
