package Turbo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FullAutomation {
	WebDriver driver;
	@BeforeClass
public void Browser() {
	
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
@Test
public void turboEntry() throws InterruptedException, IOException {
	driver.manage().window().maximize();
	driver.get("https://www.turbochargerpros.com");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	


// Year Selection		
	Thread.sleep(3000);
	Scanner z =new Scanner(System.in);
	System.out.println("Enter Year Model");
	int year= z.nextInt();
	driver.findElement(By.xpath("//*[@id='sel-year']//option[text()='"+year+"']")).click();

// Make Selection	
	Thread.sleep(5000);
	List<WebElement> MakeList = driver.findElements(By.xpath("//select[@id='sel-make']//option"));
	for (int j = 2; j <= MakeList.size(); j++) {
		
	driver.findElement(By.xpath(("(//select[@id='sel-make']//option)["+j+"]"))).click();	
	Thread.sleep(3000);
	
	
//Model Selection	
	
	List<WebElement> modelList = driver.findElements(By.xpath("//select[@id='sel-model']//option"));
	for (int k = 2; k <= modelList.size(); k++) {
		driver.findElement(By.xpath(("(//select[@id='sel-model']//option)["+k+"]"))).click();
	    Thread.sleep(3000);
	
//Part Selection
	
	List<WebElement> partlList = driver.findElements(By.xpath("//select[@id='ti-sel-part']//option"));
	for (int l = 2 ; l <= partlList.size(); l++) {
		driver.findElement(By.xpath(("(//select[@id='ti-sel-part']//option)["+l+"]"))).click();
	
	Thread.sleep(5000);
	
	
//support Handle
	try {
		Thread.sleep(2000);
		WebElement fram = driver.findElement(By.id("webWidget"));
		driver.switchTo().frame(fram);
		driver.findElement(By.xpath("//div//button[@data-garden-id='buttons.icon_button']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);	

	} catch (Exception e) {
		// TODO: handle exception
	}

//Additional option handle	
		List<WebElement> EnginelList = driver.findElements(By.xpath("//select[@id='ti-sel-engine']//option"));
		for (int m = 1; m <= EnginelList.size(); m++) {
			WebElement webmatch = driver.findElement(By.xpath(("(//select[@id='ti-sel-engine']//option)[1]")));
			String match = webmatch.getText();
			if (match != "Select Fitment") {
				driver.findElement(By.xpath(("(//select[@id='ti-sel-engine']//option)["+m+"]"))).click();
					Thread.sleep(3000);
		

//Go Button and Add to Cart
	driver.findElement(By.id("sub")).click();
   	try {
   		
   		driver.findElement(By.xpath("//input[@class='addtocart_btn' and @value='Add To Cart' and @type='submit']")).click();
   	
   		Thread.sleep(3000);
   	   	TakesScreenshot ts=(TakesScreenshot)driver; 

   	     File src=ts.getScreenshotAs(OutputType.FILE);

   	     FileHandler.copy(src,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\TurboScreenshots\\cart for part "+1+".png"));
   	  Thread.sleep(1000);
   	    JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Checkout now ']")).click();
		
		TakesScreenshot tl=(TakesScreenshot)driver; 

	     File srh=tl.getScreenshotAs(OutputType.FILE);

	     FileHandler.copy(srh,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\TurboScreenshots\\checkout "+j+".png")); 
	     
	    System.out.println(j+". Cycle Completed succesfully");
	    Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-450)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class='fa fa-minus'])[1]")).click();
   	} catch (Exception e) {
		System.out.println("Out of stock");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		
		
		
	   	TakesScreenshot ts=(TakesScreenshot)driver; 

	     File src=ts.getScreenshotAs(OutputType.FILE);

	     FileHandler.copy(src,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\TurboScreenshots\\cart for "+j+" out of stock.png")); 
	    System.out.println(j+". cycle out of stock");
	    js.executeScript("window.scrollBy(0,-100)");
	    Thread.sleep(1000);
	    
	}
	


			} else {

			}
}}}}}}



