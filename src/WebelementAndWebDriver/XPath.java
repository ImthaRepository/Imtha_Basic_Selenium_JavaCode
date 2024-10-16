package WebelementAndWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.flipkart.com");
	driver.manage().window().maximize();
	Thread.sleep(1500);
	WebElement search= driver.findElement(By.xpath("//input[@class='Pke_EE'][@title='Search for Products, Brands and More'][@placeholder='Search for Products, Brands and More'][@name='q']"));
	Thread.sleep(2000);
	search.sendKeys("mobiles");
	Thread.sleep(2000);
	WebElement click=driver.findElement(By.xpath("//*[@class='_2iLD__']"));
	click.click();
	Thread.sleep(2000);
	WebElement realme=driver.findElement(By.xpath("(//*[@class='_4rR01T'])[2]"));
	realme.click();
	Thread.sleep(1500);
	driver.navigate().back();
	Thread.sleep(1500);
	driver.navigate().refresh();
	Thread.sleep(1500);
	driver.close();
	Thread.sleep(1500);
	driver.quit();
}
}
