package WebelementAndWebDriver;

import java.awt.Point;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingFlipkart {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("headphones");
		search.submit();
		WebElement aroma=driver.findElement(By.xpath("(//a[@class='wjcEIp'])[6]"));
		aroma.click();
		String page1 = driver.getWindowHandle();
		Set<String> allpage = driver.getWindowHandles();
		for (String allpage1 : allpage) {
			if (!page1.equals (allpage1)){
				driver.switchTo().window(allpage1);
			WebElement addtocart=driver.findElement(By.xpath("//*[@class='QqFHMw vslbG+ In9uk2']"));
			org.openqa.selenium.Point p=addtocart.getLocation();
			System.out.println(p.getX());
			System.out.println(p.getY());
			addtocart.click();
			}
		}
	}

}
