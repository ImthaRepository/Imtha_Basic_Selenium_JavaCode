package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HardassertTrueorFalse {
	WebDriver driver;
	@BeforeTest
	public void Webdriver() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://mail.google.com/mail");

		}
	@Test
	public void enterintotest() {



		WebElement text1 = driver.findElement(By.xpath("//*[@class='gNJDp']"));
		String actual=text1.getText();
		System.out.println(actual);
		String expect="to continue to Gmail";
	    Boolean pass=expect.equals(actual);
		Assert.assertTrue(pass);




		WebElement text2 = driver.findElement(By.xpath("(//*[@class='VfPpkd-vQzf8d'])[5]"));
		String actual2=text2.getText();
		System.out.println(actual2);
		String expect2="Create account";
		Boolean fail=expect2.equals(actual2);
		Assert.assertFalse(fail);
	}

		@AfterTest
	public void closebrowser() {
		driver.close();
	}
}
