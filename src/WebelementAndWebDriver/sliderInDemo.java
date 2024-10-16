package WebelementAndWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class sliderInDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Slider.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement slider = driver.findElement(By.id("slider"));
		//WebElement slider = driver.findElement(By.xpath("//a[@class='ui-slider-handle ui-state-default ui-corner-all']"));
		Actions a=new Actions(driver);
		a.dragAndDropBy(slider, 0, 25).perform();
		Thread.sleep(3000);
		driver.close();
	
	}
}
