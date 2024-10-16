package WebelementAndWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class FacebookCreateAccount {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	
	//List<WebElement> year = driver.findElements(By.id("sel-year"));
	//Select a=new Select(year);
	//a.selectByValue("2012");
//	List<WebElement> year = driver.findElements(By.id("sel-year"));
//	Select a =new Select(year);
//	a.selectByValue("2012");
//	List<WebElement> make= driver.findElements(By.id("sel-make"));
//	Select b =new Select(make);
//	b.selectByValue("Audi");
//	List<WebElement> model = driver.findElements(By.xpath("[@id='sel-model']"));
//	Select c =new select(model);
//	c.selectByValue("A4");
//	List<WebElement> part = driver.findElements(By.id("ti-sel-part"));
//	Select d=new Select(part);
//	d.selectByValue("Turbocharger");
//	driver.findElement(By.id("sub")).click();	
}
}