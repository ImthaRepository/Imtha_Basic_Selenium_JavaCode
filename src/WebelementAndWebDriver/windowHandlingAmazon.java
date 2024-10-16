package WebelementAndWebDriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandlingAmazon {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("headphones");
		search.submit();
		WebElement aroma=driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium')])[4]"));
		aroma.click();
		String page1 = driver.getWindowHandle();
		Set<String> allpage = driver.getWindowHandles();
		for (String allpage1 : allpage) {
			if (!page1.equals (allpage1)){
				driver.switchTo().window(allpage1);
			WebElement addtocart=driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
			addtocart.click();
			Thread.sleep(20000);
			WebElement gocart=driver.findElement(By.xpath("(//a[@class='a-button-text'])[3]"));
			gocart.click();
			}
		}
	}
}
