package Turbo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FullAuomationProperscreen {
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
	driver.manage().deleteAllCookies();
	driver.get("https://www.turbochargerpros.com");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	


// Year Selection	
	WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
	w.until(ExpectedConditions.elementToBeClickable(By.id("sel-year")));
	Scanner z =new Scanner(System.in);
	System.out.println("Enter Year Model");
	int year= z.nextInt();
	driver.findElement(By.xpath("//*[@id='sel-year']//option[text()='"+year+"']")).click();

// Make Selection	
	
	
	w.until(ExpectedConditions.elementToBeClickable(By.id("sel-make")));
	List<WebElement> MakeList = driver.findElements(By.xpath("//select[@id='sel-make']//option"));
	for (int j = 2; j <= MakeList.size(); j++) {
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='sel-make']option)["+j+"]")));	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	WebElement WebMake = driver.findElement(By.xpath(("(//select[@id='sel-make']//option)["+j+"]")));	
	String make =WebMake.getText();
	WebMake.click();
	

	
	
//Model Selection	
	wait.until(ExpectedConditions.elementToBeClickable(By.id("sel-model")));
	List<WebElement> modelList = driver.findElements(By.xpath("//select[@id='sel-model']//option"));
	for (int k = 2; k <= modelList.size(); k++) {
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("sel-make")));
		WebElement WebModel = driver.findElement(By.xpath(("(//select[@id='sel-model']//option)["+k+"]")));
	    String model=WebModel.getText();
	    WebModel.click();
		
	
//Part Selection
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("ti-sel-part")));
	List<WebElement> partlList = driver.findElements(By.xpath("//select[@id='ti-sel-part']//option"));
	for (int l = 2 ; l <= partlList.size(); l++) {
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='ti-sel-part']option)["+l+"]")));
		WebElement WebPart = driver.findElement(By.xpath(("(//select[@id='ti-sel-part']//option)["+l+"]")));
		String part=WebPart.getText();
		WebPart.click();
	    
	
	
//support Handle
	try {
		Thread.sleep(2000);
		WebElement fram = driver.findElement(By.id("webWidget"));
		driver.switchTo().frame(fram);
		driver.findElement(By.xpath("//div//button[@data-garden-id='buttons.icon_button']")).click();
		driver.switchTo().defaultContent();
			

	} catch (Exception e) {
		
	}

//Additional option handle	
     	
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ti-sel-engine")));
		List<WebElement> EngineList = driver.findElements(By.xpath("//select[@id='ti-sel-engine']//option"));
		int size=EngineList.size();
	
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='ti-sel-engine']option)[1]")));
			//WebElement webmatch = driver.findElement(By.xpath(("(//select[@id='ti-sel-engine']//option)[1]")));
			//String match = webmatch.getText();
			if (size<=1) {
				
			WebElement Webfitment = driver.findElement(By.xpath(("(//select[@id='ti-sel-engine']//option)[1]")));
					String fitment=Webfitment.getText();
					Webfitment.click();
					//support Handle
					try {
						WebElement fram = driver.findElement(By.id("webWidget"));
						driver.switchTo().frame(fram);
						driver.findElement(By.xpath("//div//button[@data-garden-id='buttons.icon_button']")).click();
						driver.switchTo().defaultContent();
							

					} catch (Exception e) {
						
					}

//Go Button and Add to Cart
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='sub' and @value='Go']")));
					driver.findElement(By.xpath("//input[@id='sub' and @value='Go']")).click();				
	//driver.findElement(By.id("sub")).click();
   	try {
   		
   		driver.findElement(By.xpath("//input[@class='addtocart_btn' and @value='Add To Cart' and @type='submit']")).click();
   		Thread.sleep(2000);
   	   	driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();
   	    Thread.sleep(2000);
   		driver.findElement(By.xpath("(//i[@class='fa fa-minus'])[1]")).click();
   		Thread.sleep(1000);
   	    
   	/*   	TakesScreenshot ts=(TakesScreenshot)driver; 
        File src=ts.getScreenshotAs(OutputType.FILE);
        
         
   	    FileHandler.copy(src,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\TurboScreenshotForFullAuto\\"+year+"-"+make+"-"+model+"-"+part+"-"+fitment+"-"+"Cart Page.png"));*/
   	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//select[@id='ti-sel-part']//option)["+l+"]"))));
   	    
   	    JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Checkout now ']")).click();
//Add Handle
//		try {
//			WebDriverWait addWait=new WebDriverWait(driver, Duration.ofSeconds(3));
//			addWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tiNWModalInner']//a[@id='tiNXClose']")));
//			driver.findElement(By.xpath("//div[@id='tiNWModalInner']//a[@id='tiNXClose']")).click();
//		} catch (Exception e) {
//			
//		}
	/*	TakesScreenshot tl=(TakesScreenshot)driver; 

	     File srh=tl.getScreenshotAs(OutputType.FILE);

	     FileHandler.copy(srh,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\TurboScreenshotForFullAuto\\"+year+"-"+make+"-"+model+"-"+part+"-"+fitment+"-"+"checkout Page.png"));*/ 
	     
	    System.out.println( "Cycle Completed succesfully");
	    Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-450)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).click();
   	} catch (Exception e) {
		System.out.println("Out of stock");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//select[@id='ti-sel-engine']//option)[1]"))));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		
		
		
/*	   	TakesScreenshot ts=(TakesScreenshot)driver; 

	    File src=ts.getScreenshotAs(OutputType.FILE);

	    FileHandler.copy(src,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\TurboScreenshotForFullAuto\\"+year+"-"+make+"-"+model+"-"+part+"-"+fitment+"-"+"Out Of Stock.png"));*/ 
	    System.out.println(j+". cycle out of stock");
	    js.executeScript("window.scrollBy(0,-100)");
	    Thread.sleep(1000);
	    
	}
	


			}
       else if (size>1) {
    	   
    	   for (int m = 2; m <= size; m++) {
    		    wait.until(ExpectedConditions.elementToBeClickable(By.id("ti-sel-engine")));
    		    WebElement Webfitment = driver.findElement(By.xpath(("(//select[@id='ti-sel-engine']//option)["+m+"]")));
				String fitment=Webfitment.getText();
				Webfitment.click();
				//support Handle
				try {
					WebElement fram = driver.findElement(By.id("webWidget"));
					driver.switchTo().frame(fram);
					driver.findElement(By.xpath("//div//button[@data-garden-id='buttons.icon_button']")).click();
					driver.switchTo().defaultContent();
						

				} catch (Exception e) {
					
				}
 //Go Button and Add to Cart
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='sub' and @value='Go']")));
				driver.findElement(By.xpath("//input[@id='sub' and @value='Go']")).click();
				//driver.findElement(By.id("sub")).click();
    	   	try {
    	   		
    	   		driver.findElement(By.xpath("//input[@class='addtocart_btn' and @value='Add To Cart' and @type='submit']")).click();
    	   		
    	   		Thread.sleep(2000);
    	   	   	driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();
    	   	    Thread.sleep(2000);
    	   		driver.findElement(By.xpath("(//i[@class='fa fa-minus'])[1]")).click();
    	   		Thread.sleep(1000);
    	   	 /*   TakesScreenshot ts=(TakesScreenshot)driver; 
    	        File src=ts.getScreenshotAs(OutputType.FILE);
    	        
    	   	    FileHandler.copy(src,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\TurboScreenshotForFullAuto\\"+year+"-"+make+"-"+model+"-"+part+"-"+fitment+"-"+"Cart Page.png"));*/
    	   	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//select[@id='ti-sel-part']//option)["+l+"]"))));
    	   	    JavascriptExecutor js=(JavascriptExecutor)driver;
    			js.executeScript("window.scrollBy(0,450)");
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//a[text()='Checkout now ']")).click();
//Add Handle
//            try {
//    				WebDriverWait addWait=new WebDriverWait(driver, Duration.ofSeconds(3));
//    				addWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tiNWModalInner']//a[@id='tiNXClose']")));
//    				driver.findElement(By.xpath("//div[@id='tiNWModalInner']//a[@id='tiNXClose']")).click();
//    			} catch (Exception e) {
//    				
//    			}
    		/*	TakesScreenshot tl=(TakesScreenshot)driver; 

    		     File srh=tl.getScreenshotAs(OutputType.FILE);

    		     FileHandler.copy(srh,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\TurboScreenshotForFullAuto\\"+year+"-"+make+"-"+model+"-"+part+"-"+fitment+"-"+"checkout Page.png"));*/ 
    		     
    		    System.out.println("Cycle Completed succesfully");
    		    Thread.sleep(1000);
    			driver.navigate().back();
    			Thread.sleep(1000);
    			js.executeScript("window.scrollBy(0,-450)");
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).click();
    	   	} catch (Exception e) {
    			System.out.println("Out of stock");
    			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//select[@id='ti-sel-engine']//option)["+m+"]"))));
    			JavascriptExecutor js=(JavascriptExecutor)driver;
    			js.executeScript("window.scrollBy(0,100)");
    			
    			
    			
    		 /*  	TakesScreenshot tt=(TakesScreenshot)driver; 

    		    File srh=tt.getScreenshotAs(OutputType.FILE);

    		    FileHandler.copy(srh,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\TurboScreenshotForFullAuto\\"+year+"-"+make+"-"+model+"-"+part+"-"+fitment+"-"+"Out Of Stock.png")); */
    		    System.out.println(j+". cycle out of stock");
    		    js.executeScript("window.scrollBy(0,-100)");
    		    Thread.sleep(1000);
	} 
	}
				
			
}}}}}
}
