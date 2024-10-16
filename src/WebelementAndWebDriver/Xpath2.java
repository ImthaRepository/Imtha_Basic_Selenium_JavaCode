package WebelementAndWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Xpath2 {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://demo.guru99.com/test/newtours/register.php");
	driver.manage().window().maximize();
	Thread.sleep(1500);
	WebElement dropdown= driver.findElement(By.xpath("//select[@name='country']"));
	Select i=new Select(dropdown);
	List<WebElement> options = i.getOptions();
	int size=options.size();
	System.out.println(size);

	boolean multiple = i.isMultiple();
	i.selectByIndex(25);
	Thread.sleep(1500);
	i.selectByIndex(35);
	Thread.sleep(1500);
	WebElement a = i.getFirstSelectedOption();
	System.out.println(a.getText());

	for (WebElement options1 : options) {
		System.out.println(options1.getText());

	}
}
}
