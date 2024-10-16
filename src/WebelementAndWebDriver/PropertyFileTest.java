package WebelementAndWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PropertyFileTest {
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver driver=new ChromeDriver();
	FileInputStream f=new FileInputStream("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\src\\WebelementAndWebDriver\\InputLoginCreditials.properties");
	Properties p=new Properties();
	p.load(f);
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get(p.getProperty("url"));
	
	driver.findElement(By.id("email")).sendKeys(p.getProperty("username"));
	driver.findElement(By.id("pass")).sendKeys(p.getProperty("password"));
	driver.findElement(By.name("login")).click();
	
	Thread.sleep(6000);
	//Create an Account

	driver.navigate().to("https://www.facebook.com/r.php?locale=en_GB&display=page");
	Thread.sleep(2000);
	//firstname
	driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]")).sendKeys(p.getProperty("firstname"));
	//lastname
	driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[2]")).sendKeys(p.getProperty("lastname"));
	//email
	driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[3]")).sendKeys(p.getProperty("email"));
	//confirm email
	//driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[4]")).sendKeys(p.getProperty("email"));
	//password
	driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[5]")).sendKeys(p.getProperty("password"));
	//DOB
	WebElement date = driver.findElement(By.xpath("(//*[@class='_9407 _5dba _9hk6 _8esg'])[1]"));
	Select a=new Select(date);
	a.selectByVisibleText(p.getProperty("day"));
	WebElement month = driver.findElement(By.xpath("(//*[@class='_9407 _5dba _9hk6 _8esg'])[2]"));
	Select b=new Select(month);
	b.selectByVisibleText(p.getProperty("month"));
	WebElement year = driver.findElement(By.xpath("(//*[@class='_9407 _5dba _9hk6 _8esg'])[3]"));
	Select c=new Select(year);
	c.selectByValue(p.getProperty("year"));
	driver.findElement(By.xpath("(//*[@class='_8esa'])[1]")).click();
	Thread.sleep(1500);
	driver.findElement(By.xpath("(//*[@class='_8esa'])[3]")).click();
	Thread.sleep(1500);
	driver.findElement(By.xpath("(//*[@class='_8esa'])[2]")).click();

	Thread.sleep(5000);
	driver.quit();
}
}
