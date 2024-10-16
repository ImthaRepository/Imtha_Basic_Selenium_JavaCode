package Turbo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class basic {
	WebDriver driver;
	@Test
	public void turbo() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.turbochargerpros.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		Thread.sleep(3000);
		WebElement year = driver.findElement(By.xpath("//div//select[@id='sel-year']"));
		//year.click();
		Select a =new Select(year);
		a.selectByVisibleText("2012");
		Thread.sleep(2000);
		WebElement make= driver.findElement(By.id("sel-make"));
		Select b =new Select(make);
		b.selectByVisibleText("Audi");
		Thread.sleep(2000);
		WebElement model = driver.findElement(By.id("sel-model"));
		Select c =new Select(model);
		c.selectByValue("A4_");
		Thread.sleep(2000);
		WebElement part = driver.findElement(By.id("ti-sel-part"));
		Select d=new Select(part);
		d.selectByValue("Turbocharger");
		Thread.sleep(5000);
		List<WebElement> count = driver.findElements(By.tagName("iframe"));
		System.out.println(count.size());
		WebElement fram = driver.findElement(By.id("webWidget"));
		driver.switchTo().frame(fram);
		driver.findElement(By.xpath("//div//button[@data-garden-id='buttons.icon_button']")).click();
		driver.switchTo().defaultContent();
		//try {
			//driver.findElement(By.xpath("//div//button[@data-garden-id='buttons.icon_button']")).click();
				//} catch (Exception e) {
				//System.out.println("no exception");
		//		driver.manage().window().minimize();
		Thread.sleep(2000);	
		   driver.findElement(By.id("sub")).click();
	}
//        	driver.switchTo().frame("frame1");
//			WebElement box = driver.findElement(By.xpath("//input[@type='text']"));
//			box.sendKeys("hello");
//			driver.switchTo().defaultContent();
//	}
}
