package Flipkart;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class FlipkartPriceLowToHigh {
public static void main(String[] args) throws InterruptedException, IOException {
	
	FileInputStream f=new FileInputStream("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\src\\Flipkart\\input.properties");
	Properties p=new Properties();
	p.load(f);
	WebDriver driver=new ChromeDriver();
	driver.manage().deleteAllCookies();

	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com");
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	WebElement fashion = driver.findElement(By.xpath(p.getProperty("mainmousehover")));
	
	Actions a= new Actions(driver);
	a.moveToElement(fashion).perform();
	
	WebElement women = driver.findElement(By.linkText(p.getProperty("mousehover2")));
	a.moveToElement(women).perform();
	
	WebElement kurthas = driver.findElement(By.linkText(p.getProperty("mousehover3")));
	a.click(kurthas).perform();
	
	driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
	
	Thread.sleep(3000);
	
	List<WebElement> LtoH = driver.findElements(By.xpath(p.getProperty("RatePath")));
	System.out.println(LtoH.size());
	
    for (int i = 2; i <= LtoH.size(); i++) {
    	String price="("+p.getProperty("RatePath")+")["+i+"]";
    	WebElement value = driver.findElement(By.xpath(price));
    	String first=value.getText();
    	//System.out.println(first);
    	first= first.replaceAll("\\D+","");
    	int a1= Integer.parseInt(first);
    	//System.out.println(a1);
    	
    	for (int j = i-1; j <= i-1 ; j++) {
    		String sprice="("+p.getProperty("RatePath")+")["+j+"]";
        	WebElement svalue = driver.findElement(By.xpath(sprice));
        	String sec =svalue.getText();
        	//System.out.println("base"+sec);
    	   	sec= sec.replaceAll("\\D+", "");
    	   	int b= Integer.parseInt(sec);
    	   	//System.out.println("base"+b);
    	   	   	
      if (b <= a1) {
		System.out.println("Pass");
	} else {
		System.out.println(i+" This is fail");
	}
}
    }
    
//Selection of item
    
    for (int o = 1; o <= LtoH.size(); o++) {
    	String namelist="("+p.getProperty("namepath")+")["+o+"]";
    	WebElement text = driver.findElement(By.xpath(namelist));
    	String List=text.getText();
    	System.out.println(o+"."+List);
	}
    Thread.sleep(1000); 
    Scanner k =new Scanner(System.in);
	System.out.println("Enter the serial number of wanted item");
	int purchase= k.nextInt();
	Thread.sleep(6000);
	driver.findElement(By.xpath("("+p.getProperty("RatePath")+")["+purchase+"]")).click();
	
//windowHandling to NextTab
	
	String page1 = driver.getWindowHandle();
	Set<String> allpage = driver.getWindowHandles();
	for (String allpage1 : allpage) {
		if (!page1.equals (allpage1)){
			driver.switchTo().window(allpage1);

		
	//driver.findElement(By.xpath("//input[@class='zDPmFV']")).sendKeys("mobiles");
		//driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();
			//WebElement addtocart=driver.findElement(By.xpath("//*[@class='QqFHMw vslbG+ In9uk2']"));
//			boolean selected = addtocart.isSelected();
//			System.out.println(selected);
		//	Point z=addtocart.getLocation();
		//	System.out.println(z.getX());
			//System.out.println(z.getY());
			//a.scrollToElement(addtocart).perform();
			//addtocart.click();
		}
		}
	
		try {
			WebElement addtocart=driver.findElement(By.xpath("//*[@class='QqFHMw vslbG+ In9uk2']"));
			addtocart.click();
		} catch (Exception e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,550)");
			WebElement addtocart=driver.findElement(By.xpath("//*[@class='QqFHMw vslbG+ In9uk2']"));
			addtocart.click();
			//System.out.println("Add To Cart Not Clicked");
		}	
	Thread.sleep(5000);
	driver.quit();
}
}
