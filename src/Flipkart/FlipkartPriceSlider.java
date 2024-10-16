package Flipkart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FlipkartPriceSlider {
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
	
//		WebElement rating = driver.findElement(By.xpath("//input[@class='_30VH1S']/following-sibling::div[text()='4★ & above']"));
//		a.moveToElement(rating).perform();
//		a.click(rating).perform();
//		Thread.sleep(6000);
//		a.click(rating).perform();
		Thread.sleep(5000);
		//WebElement price = driver.findElement(By.xpath("//div[@class='_12FhcQ']"));
		WebElement slide = driver.findElement(By.xpath("//div[@class='_31Kbhn _28DFQy']"));
		a.dragAndDropBy(slide, 190, 0).perform();
		
		WebElement min = driver.findElement(By.xpath("//div[@class='_1YAKP4']/child::select[@class='_2YxCDZ']"));
		Select b=new Select(min);
		b.selectByValue("500");
		Thread.sleep(2000);
		WebElement max = driver.findElement(By.xpath("//div[@class='_3uDYxP']/child::select[@class='_2YxCDZ']"));
		Select c=new Select(max);
		c.selectByValue("700");
		
		List<WebElement> price = driver.findElements(By.xpath(p.getProperty("RatePath")));
		int numbers=price.size();
		System.out.println(numbers);
		
		for (int i = 1; i <= numbers; i++) {
			WebElement maxim = driver.findElement(By.xpath(p.getProperty("RatePath")+"["+i+"]"));
			String maximum=maxim.getText();
			System.out.println(maximum);
			maximum=maximum.replaceAll("\\D+", "");
			int actualprice=Integer.parseInt(maximum);
			
			if (actualprice>=500 && actualprice<=700 ) {
				System.out.println("pass");
				
			} else {
				System.out.println(i+" fail");

			}
			
				}
		
		
		Thread.sleep(30000);
		driver.close();
	}}