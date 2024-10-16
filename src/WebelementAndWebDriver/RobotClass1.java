package WebelementAndWebDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RobotClass1 {
	public static void main(String[] args) throws AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement box = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
		Actions a=new Actions(driver);
		a.contextClick(box).perform();
		Robot i=new Robot();
		i.keyPress(KeyEvent.VK_DOWN);
		i.keyRelease(KeyEvent.VK_DOWN);
		i.keyPress(KeyEvent.VK_ENTER);
		i.keyRelease(KeyEvent.VK_ENTER);
	for (int j = 0; j <=2; j++) {
		i.keyPress(KeyEvent.VK_DOWN);
		i.keyRelease(KeyEvent.VK_DOWN);
	}
	i.keyPress(KeyEvent.VK_ENTER);
	i.keyRelease(KeyEvent.VK_ENTER);


	}
}