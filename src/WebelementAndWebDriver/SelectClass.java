package WebelementAndWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
driver.get("https://www.turbochargerpros.com");
		//List<WebElement> year = driver.findElements(By.id("sel-year"));
		//Select a=new Select(year);
		//a.selectByValue("2012");
		WebElement year = driver.findElement(By.id("sel-year"));
		Select a =new Select(year);
		a.selectByVisibleText("2012");
		WebElement make= driver.findElement(By.id("sel-make"));
		Select b =new Select(make);
		b.selectByValue("Audi");
		WebElement model =  driver.findElement(By.xpath("[@id='sel-model']"));
		Select c =new Select(model);
		c.selectByValue("A4");
		WebElement part = driver.findElement(By.id("ti-sel-part"));
		Select d=new Select((WebElement) part);
		d.selectByValue("Turbocharger");
		driver.findElement(By.id("sub")).click();

	}

}
