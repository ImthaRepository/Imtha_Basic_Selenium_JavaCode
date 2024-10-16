package Travel;

import java.text.StringCharacterIterator;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class MakeMyTripMulti {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	try {
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
	} catch (Exception e) {
		System.out.println("No alert");
	}
	
	driver.findElement(By.xpath("//li[text()='Multi City']/child::span[@class='tabsCircle appendRight5']")).click();

	
	// From1
		
	//(not work)driver.findElement(By.xpath("//label[@for='fromAnotherCity0']")).click();
	driver.findElement(By.id("fromAnotherCity0")).sendKeys("ixm");
	
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10) );
	//wait.until(ExpectedConditions.visibilityOf(ixm));
	Thread.sleep(2000);
	Actions a=new Actions(driver);
	a.keyDown(Keys.ARROW_DOWN).perform();
	a.keyDown(Keys.ENTER).perform();
	
	//To 1
	
	//(extra line)driver.findElement(By.xpath("//label[@for='toAnotherCity0']/child::span[text()='To']")).click();
	driver.findElement(By.id("toAnotherCity0")).sendKeys("MAA");
	Thread.sleep(2000);
	a.keyDown(Keys.ARROW_DOWN).perform();
	a.keyDown(Keys.ENTER).perform();

	//Date 1
	
	driver.findElement(By.xpath("//label[@for='anotherDeparture 0']/child::span[text()='Departure']")).click();
	WebElement sidearrow = driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"));
	a.doubleClick(sidearrow).perform();
	//div[@class='DayPicker-Months']/div[@class='DayPicker-Month']/div[@aria-label='Tue Jul 16 2024']
	driver.findElement(By.xpath("//div[@class='DayPicker-Months']//div[@aria-label='Tue Jul 16 2024']")).click();

	
    
	
	//No. of Traveller And Class choose
	
	//mention number of Adults in 2nd Xpath text value, children in 3rd xpath, infant in 3rd xpath
	
	driver.findElement(By.xpath("//span[@class='lbl_input appendBottom10' and text()='Travellers & Class']")).click();
	driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText ']//li[text()='2']")).click();
	driver.findElement(By.xpath("//p[text()='CHILDREN (2y - 12y )']/following-sibling::ul[@class='guestCounter font12 darkText ']//li[text()='2']")).click();
	driver.findElement(By.xpath("//p[text()='INFANTS (below 2y)']/following-sibling::ul[@class='guestCounter font12 darkText ']//li[text()='1']")).click();
	driver.findElement(By.xpath("//li[text()='Business']")).click();
	driver.findElement(By.xpath("//button[@class='primaryBtn btnApply pushRight']")).click();

	


	//Match of 1st destination and second depature
	
	WebElement dest1 = driver.findElement(By.id("toAnotherCity0"));
	String destin1=dest1.getAttribute("value");
	System.out.println(destin1);
	WebElement dep2 = driver.findElement(By.id("fromAnotherCity1"));
	String depat2=dep2.getAttribute("value");
	System.out.println(depat2);
	
	String i="imtha";
	if (destin1==depat2) {
		System.out.println("destination and departure are same");
		
	} else {
		System.out.println("Failed to Fetch the destination");
	}

	JavascriptExecutor b=(JavascriptExecutor)driver;
	b.executeScript("window.scrollBy(0,50)");
	
	//2nd destination
	
	
	driver.findElement(By.id("toAnotherCity1")).sendKeys("DEL");
	Thread.sleep(2000);
	a.keyDown(Keys.ARROW_DOWN).perform();
	a.keyDown(Keys.ENTER).perform();

	//2nd depature date
	
	
	driver.findElement(By.xpath("//label[@for='anotherDeparture 1']/child::span[text()='Departure']")).click();
	WebElement sidearrow2 = driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"));
	a.click(sidearrow2).click(sidearrow2).click(sidearrow2).perform();
	driver.findElement(By.xpath("//div[@class='DayPicker-Months']//div[@aria-label='Wed Aug 07 2024']")).click();
	
	//Add and Remove Another city
	
	driver.findElement(By.xpath("(//button[@class='btnAddCity'])[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@data-cy='removeCity-2']")).click();
	
	//Selection of Special fare
	
	driver.findElement(By.xpath("//div[@class='fareCardItem ']//div[text()='Student']")).click();
	driver.findElement(By.xpath("//div[@class='fareCardItem ']//div[text()='Senior Citizen']")).click();
	driver.findElement(By.xpath("//div[@class='fareCardItem ']//div[text()='Doctor and Nurses']")).click();
	driver.findElement(By.xpath("//div[@class='fareCardItem ']//div[text()='Armed Forces']")).click();
	driver.findElement(By.xpath("//div[@class='fareCardItem ']//div[text()='Regular']")).click();
	
	//Search Button

	driver.findElement(By.xpath("//a[text()='Search']")).click();
	
	Thread.sleep(6000);
	driver.close();
}
}