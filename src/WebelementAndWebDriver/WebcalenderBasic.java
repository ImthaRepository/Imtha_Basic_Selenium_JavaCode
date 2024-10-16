package WebelementAndWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebcalenderBasic {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.automationtesting.in/Datepicker.html");
	//1st date picker
	driver.findElement(By.id("datepicker1")).click();
	for (int i = 0; i < 335; i++) {
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
	}
	driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tr[4]//td[4]")).click();

	// 2nd date picker
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.findElement(By.id("datepicker2")).click();

	WebElement month = driver.findElement(By.xpath("//select[@class='datepick-month-year'and@title='Change the month']"));
	month.click();
	Select b=new Select(month);
	b.selectByVisibleText("July");


	WebElement year = driver.findElement(By.xpath("//select[@class='datepick-month-year'and@title='Change the year']"));
	year.click();
	Select a=new Select(year);
	a.selectByIndex(0);
	Thread.sleep(1500);

	WebElement year1 = driver.findElement(By.xpath("//select[@class='datepick-month-year'and@title='Change the year']"));
	year1.click();
	Select c=new Select(year1);
	c.selectByVisibleText("2006");

	driver.findElement(By.xpath("(//table//tr[4]//td[1])[2]")).click();

}
}
