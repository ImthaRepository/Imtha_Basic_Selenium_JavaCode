package WebelementAndWebDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RobotClass {
public static void main(String[] args) throws AWTException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	WebElement text = driver.findElement(By.xpath("//h2[@class='_8eso']"));
	Actions a=new Actions(driver);
	a.click(text).click(text).click(text).perform();
	Robot i=new Robot();
	i.keyPress(KeyEvent.VK_CONTROL);
	i.keyPress(KeyEvent.VK_C);
	i.keyRelease(KeyEvent.VK_CONTROL);
	i.keyRelease(KeyEvent.VK_C);
	WebElement box = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
	box.click();
	i.keyPress(KeyEvent.VK_CONTROL);
	i.keyPress(KeyEvent.VK_V);
	i.keyRelease(KeyEvent.VK_CONTROL);
	i.keyRelease(KeyEvent.VK_V);

}
}
