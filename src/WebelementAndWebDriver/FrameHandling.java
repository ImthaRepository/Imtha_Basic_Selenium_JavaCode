package WebelementAndWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FrameHandling {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
	List<WebElement> count = driver.findElements(By.tagName("iframe"));
	System.out.println(count.size());
	driver.switchTo().frame("frame1");
	WebElement box = driver.findElement(By.xpath("//input[@type='text']"));
	box.sendKeys("hello");
	driver.switchTo().defaultContent();
	driver.switchTo().frame("frame2");
	WebElement ddn = driver.findElement(By.xpath("//select[@class='col-lg-3']"));
	Select a=new Select(ddn);
	List<WebElement> list = a.getOptions();
	System.out.println(list.size());
	for (WebElement fulllist: list) {
		System.out.println(fulllist.getText());
	}
	boolean many = a.isMultiple();
	System.out.println(many);
	a.selectByIndex(2);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("frame1");
	driver.switchTo().frame("frame3");
	WebElement check = driver.findElement(By.xpath("//input[@id='a']"));
	check.click();

}
}
