package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {
WebDriver driver;
@DataProvider (name="imtha")
public Object[][] data(){
	return new Object[][] {
		{"imtha1998","12345"},{"imtha1999","245654"}
	};
}
@BeforeMethod
public void enterurl() {
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com");
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
}
@Test (dataProvider ="imtha")
public void detailsEnter(String user,String Pass) {
	WebElement username = driver.findElement(By.id("email"));
	username.sendKeys(user);
	WebElement password = driver.findElement(By.id("pass"));
	password.sendKeys(Pass);
}
@AfterMethod
public void close() {
	driver.close();

}
}
