package Ajio;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AJioSimpleFlow {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("https://www.ajio.com");
	
    WebElement mens = driver.findElement(By.xpath("//span[text()='MEN']"));
	
	Actions a= new Actions(driver);
	a.moveToElement(mens).perform();
	
	WebElement shirts = driver.findElement(By.linkText("Shirts"));
	a.click(shirts).perform();
	
	
	try {
		WebElement rightclick = driver.findElement(By.xpath("//body//div[@id='app']"));
		a.contextClick(rightclick).perform();
	} catch (Exception e) {
		System.out.println("Right Click is Not Allowed");
	}
    WebElement priceOpt = driver.findElement(By.xpath("//span[text()='price']"));
	a.click(priceOpt).perform();
	Thread.sleep(2000);
	//CheckBox for price below Rs.500
	driver.findElement(By.xpath("//label[@for='Below Rs.500']")).click();
	Thread.sleep(3000);
	// Based on Price
	List<WebElement> price = driver.findElements(By.xpath("//span[@class='price  ']"));
	int numbers=price.size();
	System.out.println(numbers);
	
	for (int i = 1; i <= numbers-5; i++) {
		WebElement maxim = driver.findElement(By.xpath("(//span[@class='price  '])["+i+"]"));
		String maximum=maxim.getText();
		//System.out.println(maximum);
		maximum=maximum.replaceAll("\\D+", "");
		int actualprice=Integer.parseInt(maximum);
		
		if ( actualprice<=500 ) {
			System.out.println(i+" .pass");
			
		} else {
			System.out.println(i+" .fail");

		}
		
			}
	System.out.println("\nItems With BrandName");
	
	 for (int o = 1; o <= price.size()-5; o++) {
	    	String brandlist="(//div[@class='brand'])["+o+"]";
	    	WebElement text = driver.findElement(By.xpath(brandlist));
	    	String List=text.getText();
	    	System.out.println(o+"."+List);
		}
	    Thread.sleep(1000); 
	    Scanner k =new Scanner(System.in);
		System.out.println("Enter the serial number of wanted item");
		int purchase= k.nextInt();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//div[@class='brand'])["+purchase+"]")).click();
	
		String page1 = driver.getWindowHandle();
		Set<String> allpage = driver.getWindowHandles();
		for (String allpage1 : allpage) {
			if (!page1.equals (allpage1)){
				driver.switchTo().window(allpage1);

			// JavascriptExecutor js=(JavascriptExecutor)driver;
			// js.executeAsyncScript("window.scrollBy(0,50)");
		
			
				
}
		}
		try {
			List<WebElement> sizes = driver.findElements(By.xpath("//div[@class='size-variant-block']//div[@class='slick-track']//div[@class='circle size-variant-item size-instock ']"));
			for (int o = 1; o <= sizes.size(); o++) {
		    	String sizelist="(//div[@class='size-variant-block']//div[@class='slick-track']//div[@class='circle size-variant-item size-instock '])["+o+"]";
		    	WebElement text = driver.findElement(By.xpath(sizelist));
		    	String List=text.getText();
		    	System.out.println(o+"."+List);
			}

			Scanner u =new Scanner(System.in);
			System.out.println("Enter the serial number of size wanted");
			int size= u.nextInt();
			Thread.sleep(6000);
			driver.findElement(By.xpath("(//div[@class='size-variant-block']//div[@class='slick-track']//div[@class='circle size-variant-item size-instock '])["+size+"]")).click();

		} catch (Exception e) {
			System.out.println("No Size Options");
		} 
//		try {
//			
//		} catch (Exception e) {
//			
//		}
	
//		List<WebElement> sizes = driver.findElements(By.xpath("//div[@class='size-variant-block']//div[@class='slick-track']//div[@class='circle size-variant-item size-instock ']"));
//		for (int o = 1; o <= sizes.size(); o++) {
//	    	String sizelist="(//div[@class='size-variant-block']//div[@class='slick-track']//div[@class='circle size-variant-item size-instock '])["+o+"]";
//	    	WebElement text = driver.findElement(By.xpath(sizelist));
//	    	String List=text.getText();
//	    	System.out.println(o+"."+List);
//		}
//
//		Scanner u =new Scanner(System.in);
//		System.out.println("Enter the serial number of size wanted");
//		int size= u.nextInt();
//		Thread.sleep(6000);
//		driver.findElement(By.xpath("(//div[@class='size-variant-block']//div[@class='slick-track']//div[@class='circle size-variant-item size-instock '])["+size+"]")).click();
		
		driver.findElement(By.xpath("//div[@class='btn-gold']//span[text()='ADD TO BAG']")).click();
		Thread.sleep(5000);
		driver.close();
		}}
//selenium java
//cyprus python
//csarp