package Turbo;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserInput {
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
	
	Scanner a =new Scanner(System.in);
	System.out.println("Enter number of item to be purchase");
	int purchase= a.nextInt();
	for (int i = 1; i <= purchase; i++) {

// Year Selection		
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(By.id("sel-year")));
	Scanner z =new Scanner(System.in);
	System.out.println("Enter Year Model");
	int year= z.nextInt();
	driver.findElement(By.xpath("//*[@id='sel-year']//option[text()='"+year+"']")).click();

// Make Selection	
	wait.until(ExpectedConditions.elementToBeClickable(By.id("sel-make")));
	List<WebElement> MakeList = driver.findElements(By.xpath("//select[@id='sel-make']//option"));
	for (int j = 1; j <= MakeList.size(); j++) {
		WebElement MakeIterate = driver.findElement(By.xpath(("(//select[@id='sel-make']//option)["+j+"]")));
		System.out.println(j+"."+MakeIterate.getText());
	}
	Thread.sleep(2000);
	Scanner y =new Scanner(System.in);
	System.out.println("Enter Serial number of the Make");
	int Make= y.nextInt();
	 WebElement SelectedMake = driver.findElement(By.xpath(("(//select[@id='sel-make']//option)["+Make+"]")));
	String InputMake=SelectedMake.getText();
	driver.findElement(By.xpath("//select[@id='sel-make']//option[text()='"+InputMake+"']")).click(); 
	
//Model Selection	
	wait.until(ExpectedConditions.elementToBeClickable(By.id("sel-model")));
	List<WebElement> modelList = driver.findElements(By.xpath("//select[@id='sel-model']//option"));
	for (int k = 1; k <= modelList.size(); k++) {
		WebElement MakeIterate = driver.findElement(By.xpath(("(//select[@id='sel-model']//option)["+k+"]")));
		System.out.println(k+"."+MakeIterate.getText());
	}
	Thread.sleep(2000);
	Scanner x =new Scanner(System.in);
	System.out.println("Enter Serial number of the Model");
	int InputModel= x.nextInt();
	WebElement Model = driver.findElement(By.xpath(("(//select[@id='sel-model']//option)["+InputModel+"]")));
	String FetchModel=Model.getText();
	driver.findElement(By.xpath("//select[@id='sel-model']//option[text()='"+FetchModel+"']")).click();
	
//Part Selection
	wait.until(ExpectedConditions.elementToBeClickable(By.id("ti-sel-part")));
	List<WebElement> partlList = driver.findElements(By.xpath("//select[@id='ti-sel-part']//option"));
	for (int l = 1; l <= partlList.size(); l++) {
		WebElement MakeIterate = driver.findElement(By.xpath(("(//select[@id='ti-sel-part']//option)["+l+"]")));
		System.out.println(l+"."+MakeIterate.getText());
	}
	Thread.sleep(1000);
	Scanner r =new Scanner(System.in);
	System.out.println("Enter Serial number of the part");
	int Inputpart= r.nextInt();
	 WebElement part = driver.findElement(By.xpath(("(//select[@id='ti-sel-part']//option)["+Inputpart+"]")));
	String Fetchpart=part.getText();
	driver.findElement(By.xpath("//select[@id='ti-sel-part']//option[text()='"+Fetchpart+"']")).click();
	
	
	
//support Handle
	try {
		Thread.sleep(2000);
		WebElement fram = driver.findElement(By.id("webWidget"));
		driver.switchTo().frame(fram);
		driver.findElement(By.xpath("//div//button[@data-garden-id='buttons.icon_button']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);	

	} catch (Exception e) {
	
	}

//Additional option handle	
	try {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ti-sel-engine")));
		List<WebElement> EnginelList = driver.findElements(By.xpath("//select[@id='ti-sel-engine']//option"));
		for (int m = 1; m <= EnginelList.size(); m++) {
			WebElement EngineIterate = driver.findElement(By.xpath(("(//select[@id='ti-sel-engine']//option)["+m+"]")));
			System.out.println(m+"."+EngineIterate.getText());
		}
		Thread.sleep(1000);
		Scanner v =new Scanner(System.in);
		System.out.println("Enter Serial number of the Engine model");
		int InputEngine= v.nextInt();
		WebElement Engine = driver.findElement(By.xpath(("(//select[@id='ti-sel-engine']//option)["+InputEngine+"]")));
		String Fetchengine=Engine.getText();
		driver.findElement(By.xpath("//select[@id='ti-sel-engine']//option[text()='"+Fetchengine+"']")).click();
		
		
		
	} catch (Exception e) {
	
	}
//Go Button and Add to Cart
	    Thread.sleep(3000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='sub' and @value='Go']")));
	    driver.findElement(By.xpath("//input[@id='sub' and @value='Go']")).click();
   	try {
   		
   		driver.findElement(By.xpath("//input[@class='addtocart_btn' and @value='Add To Cart' and @type='submit']")).click();
   		System.out.println("You have Choosen '"+year+"-"+InputMake+"-"+FetchModel+"-"+Fetchpart+"'");
   		Scanner v =new Scanner(System.in);
   		System.out.println("Enter Required number of Items");
   		int Input= v.nextInt();
   		if (Input==1) {
			System.out.println("done");
		}
   		else if (Input == 2) {
			
				//driver.findElement(By.xpath("(//i[@class='fa fa-plus'])["+i+"]")).click();
				driver.findElement(By.xpath("//div[@class='col-lg-2 text-left']/child::input[@value='"+year+"']/following-sibling::input[@value='"+InputMake+"']/following-sibling::input[@value='"+FetchModel+"']/parent::*/following-sibling::div//a//i[@class='fa fa-plus']")).click();
				Thread.sleep(2000);
			
		} else if (Input == 0) {
			
			driver.findElement(By.xpath("//div[@class='col-lg-2 text-left']/child::input[@value='"+year+"']/following-sibling::input[@value='"+InputMake+"']/following-sibling::input[@value='"+FetchModel+"']/parent::*/following-sibling::div//i[@class='fa fa-trash-o']")).click();	
			//driver.findElement(By.xpath("(//i[@class='fa fa-minus'])["+i+"]")).click();
			//div[@class='col-lg-2 text-left']/child::input[@value='2016']/following-sibling::input[@value='BMW']/following-sibling::input[@value='535i']/parent::*/following-sibling::div//a//i[@class='fa fa-plus']
			//driver.findElement(By.xpath("//div[@class='col-lg-2 text-left']/child::input[@value='"+year+"']/following-sibling::input[@value='"+InputMake+"']/following-sibling::input[@value='"+FetchModel+"']/parent::*/following-sibling::div//a//i[@class='fa fa-minus']")).click();
			
			} else if (Input > 2) {
				//driver.findElement(By.xpath("//div[@class='col-lg-2 text-left']/child::input[@value='"+year+"']/following-sibling::input[@value='"+InputMake+"']/following-sibling::input[@value='"+FetchModel+"']/parent::*/following-sibling::div//a//i[@class='fa fa-minus']")).click();
				WebElement txtbox = driver.findElement(By.xpath("//div[@class='col-lg-2 text-left']/child::input[@value='"+year+"']/following-sibling::input[@value='"+InputMake+"']/following-sibling::input[@value='"+FetchModel+"']/parent::*/following-sibling::div//input[@type='text']"));
				txtbox.click();
				Thread.sleep(1000);
				Robot t=new Robot();
				t.keyPress(KeyEvent.VK_BACK_SPACE);
				t.keyPress(KeyEvent.VK_BACK_SPACE);
				Thread.sleep(1000);
				txtbox.sendKeys(""+Input+"");
				
				
			} 

		
   	} catch (Exception e) {
		WebElement stockout = driver.findElement(By.xpath("//input[@class='addtocart_btn' and @value='Out of Stock']"));
   		String stock=stockout.getAttribute("value");
		System.out.println(stock);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,90)");
		
		
	   	TakesScreenshot ts=(TakesScreenshot)driver; 

	     File src=ts.getScreenshotAs(OutputType.FILE);

	     FileHandler.copy(src,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\TurboScreenshots\\"+year+"-"+InputMake+"-"+FetchModel+"-"+Fetchpart+"-"+"Out of stock.png")); 
	    
	    js.executeScript("window.scrollBy(0,-90)");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@class='col-md-1 col-lg-1 col-sm-3 col-xs-4 cart ie-cart']//a")).click();
	}
	
	Thread.sleep(2000);
   	TakesScreenshot ts=(TakesScreenshot)driver; 
    File src=ts.getScreenshotAs(OutputType.FILE);
    FileHandler.copy(src,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\TurboScreenshots\\"+year+"-"+InputMake+"-"+FetchModel+"-"+Fetchpart+"-"+"cart page.png")); 

	}}


@Test(priority = 2)
public void cart() throws InterruptedException, IOException {

		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(2000);
		try {
			
		
		driver.findElement(By.xpath("//a[text()='Checkout now ']")).click();
		
		TakesScreenshot ts=(TakesScreenshot)driver; 

	     File src=ts.getScreenshotAs(OutputType.FILE);

	     FileHandler.copy(src,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\TurboScreenshots\\checkout.png")); 
		}catch (Exception e) {
			System.out.println("No item in cart checkOut Not Found");
		}
}
}
