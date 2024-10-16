package TestNG;

import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdactinProject {
	WebDriver driver;
	@BeforeTest
public void chooseBrowser() {
	
	Scanner i=new Scanner(System.in);
	System.out.println("Enter the Browser Name");
	String browserName = i.nextLine();
	if (browserName.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();		
	}
	else if (browserName.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
		
	}
	else if (browserName.equalsIgnoreCase("Firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("404 not found");
		}
}
@Test
public void AdactinLoginPage() {
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	
	driver.navigate().to("https://adactinhotelapp.com");
	driver.findElement(By.id("username")).sendKeys("VimalMurugan");
	driver.findElement(By.id("password")).sendKeys("vimal@123");
	driver.findElement(By.xpath("//input[@class='login_button']")).click();

}	
// page 1
@Test
public void page1() {
	WebElement assert1 = driver.findElement(By.id("username_show"));
	String actual1=assert1.getAttribute("value");
	String expect1="Hello VimalMurugan!";
	Assert.assertEquals(expect1, actual1);
	
	WebElement locate = driver.findElement(By.xpath("//select[@id='location']"));
	Select a=new Select(locate);
	a.selectByIndex(5);

	WebElement hotel = driver.findElement(By.xpath("//select[@name='hotels']"));
	Select b=new Select(hotel);
	b.selectByValue("Hotel Hervey");

	WebElement room = driver.findElement(By.xpath("//select[@id='room_type']"));
	Select c=new Select(room);
	c.selectByVisibleText("Super Deluxe");

	WebElement beds = driver.findElement(By.xpath("//select[@id='room_nos']"));
	Select d=new Select(beds);
	d.selectByValue("2");

	WebElement checkin = driver.findElement(By.name("datepick_in"));
	Actions e=new Actions(driver);
	e.click(checkin).click(checkin).click(checkin).perform();
	checkin.sendKeys("26/03/2024");

	WebElement checkout = driver.findElement(By.name("datepick_out"));
	Actions f=new Actions(driver);
	f.click(checkout).click(checkout).click(checkout).perform();
	checkout.sendKeys("31/04/2024");

	WebElement adults = driver.findElement(By.id("adult_room"));
	Select g=new Select(adults);
	g.selectByIndex(3);

	WebElement child = driver.findElement(By.name("child_room"));
	Select h=new Select(child);
	h.selectByIndex(3);

	driver.findElement(By.xpath("(//input[@class='reg_button'])[1]")).click();
}

@Test
public void page2() {

	WebElement assert2 = driver.findElement(By.id("hotel_name_0"));
	String actual2=assert2.getAttribute("value");
	String expect2="Hotel Hervey";
	Assert.assertEquals(expect2, actual2);
	
	driver.findElement(By.xpath("//input[@id='radiobutton_0']")).click();
	driver.findElement(By.name("continue")).click();

}

@Test
public void page3() {

	driver.findElement(By.name("first_name")).sendKeys("imtha");
	driver.findElement(By.name("last_name")).sendKeys("dulah");

	driver.findElement(By.id("address")).sendKeys("no.25,west mall roed,-652b54uk");
	driver.findElement(By.xpath("//input[@name='cc_num']")).sendKeys("6525568978458547");

	WebElement type = driver.findElement(By.id("cc_type"));
	Select j=new Select(type);
	j.selectByIndex(2);

	WebElement month = driver.findElement(By.name("cc_exp_month"));
	Select k=new Select(month);
	k.selectByIndex(6);

	WebElement year = driver.findElement(By.id("cc_exp_year"));
	Select l=new Select(year);
	l.selectByIndex(10);

	driver.findElement(By.xpath("//input[@id='cc_cvv']")).sendKeys("655");

	driver.findElement(By.id("book_now")).click();

	WebElement assert3 = driver.findElement(By.id("process_span"));
	String actual3=assert3.getText();
	String expect3="Please wait! We are processing your Hotel Booking...";
	Assert.assertEquals(expect3, actual3);
}

@Test
public void page4() {
	

	WebElement ordernum = driver.findElement(By.id("order_no"));
	String number = ordernum.getAttribute("value");

	driver.findElement(By.xpath("//input[@id='my_itinerary']")).click();

	//Thread.sleep(2000);
	driver.findElement(By.name("order_id_text")).sendKeys(number);
	//Thread.sleep(2000);
	driver.findElement(By.id("search_hotel_id")).click();
	//Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@style='width:150px;'])[1]")).click();

	////driver.findElement(By.xpath("//input[@value='Cancel'String"]"))

	Alert m=driver.switchTo().alert();
	m.accept();
	
	WebElement assert4 = driver.findElement(By.id("search_result_error"));
	String actual4=assert4.getText();
	String expect4="The booking has been cancelled.";
	Assert.assertEquals(expect4, actual4);
}

@Test
public void page6() {
	driver.findElement(By.linkText("Logout")).click();
	
	WebElement assert5 = driver.findElement(By.xpath("//*[@class='reg_success']"));
	String actual5=assert5.getText();
	String expect5="You have successfully logged out. Click here to login again";
	Assert.assertEquals(expect5, actual5);
	
}

@AfterTest
public void close() {
	driver.close();
}
}
