package AdactinProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(AdactinProject.ListenerCodeForAdactin.class)
public class AdactinMainCode extends AdactinPropertiesCode {
	
	
@Test  (priority = 1)
    public void AdactinLoginPage() {
	
	   driver.navigate().to(url);
   	   driver.findElement(By.id("username")).sendKeys(username);
	   driver.findElement(By.id("password")).sendKeys(password);
	   driver.findElement(By.xpath("//input[@class='login_button']")).click();

}	
// page 1
@Test	(priority = 2)
    public void HotelSelectionPage() {

	                       WebElement assert1 = driver.findElement(By.id("username_show"));
	                       String actual1=assert1.getAttribute("value");
	                       String expect1=loginconfirm;
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
       checkin.sendKeys(entrydate);

	   WebElement checkout = driver.findElement(By.name("datepick_out"));
	   Actions f=new Actions(driver);
	   f.click(checkout).click(checkout).click(checkout).perform();
	   checkout.sendKeys(exitdate);

	   WebElement adults = driver.findElement(By.id("adult_room"));
	   Select g=new Select(adults);
	   g.selectByIndex(3);

	   WebElement child = driver.findElement(By.name("child_room"));
	   Select h=new Select(child);
	   h.selectByIndex(3);

	   driver.findElement(By.xpath("(//input[@class='reg_button'])[1]")).click();
}

@Test	(priority = 3)
    public void HotelConfirmationPage() {

	                 WebElement assert2 = driver.findElement(By.id("hotel_name_0"));
                     String actual2=assert2.getAttribute("value");
	                 String expect2=hotelconfirm;
	                 Assert.assertEquals(expect2, actual2);
	
	  driver.findElement(By.xpath("//input[@id='radiobutton_0']")).click();
	  driver.findElement(By.name("continue")).click();

}

@Test	(priority = 4)
    public void PersonalDetailsEntryPage() {

	  driver.findElement(By.name("first_name")).sendKeys(firstname);
	  driver.findElement(By.name("last_name")).sendKeys(lastname);

	  driver.findElement(By.id("address")).sendKeys("no.25,west mall roed,-652b54uk");
	  driver.findElement(By.xpath("//input[@name='cc_num']")).sendKeys(crdnum);

      WebElement type = driver.findElement(By.id("cc_type"));
	  Select j=new Select(type);
	  j.selectByIndex(2);

	  WebElement month = driver.findElement(By.name("cc_exp_month"));
	  Select k=new Select(month);
	  k.selectByIndex(6);

	  WebElement year = driver.findElement(By.id("cc_exp_year"));
	  Select l=new Select(year);
	  l.selectByIndex(10);

	  driver.findElement(By.xpath("//input[@id='cc_cvv']")).sendKeys(cvv);

	  driver.findElement(By.id("book_now")).click();

	                  WebElement assert3 = driver.findElement(By.id("process_span"));
	                  String actual3=assert3.getText();
	                  String expect3=bookconfirm;
	                  Assert.assertEquals(expect3, actual3);
}

@Test	(priority = 6)
    public void BookingconfirmAndCancelingPage() {
	

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
	                    String expect4=cancelconfirm;
	                    Assert.assertEquals(expect4, actual4);
}

@Test	(priority = 7)
    public void LogoutPage() {
	    
	    driver.findElement(By.linkText("Logout")).click();
	
	                    WebElement assert5 = driver.findElement(By.xpath("//*[@class='reg_success']"));
	                    String actual5=assert5.getText();
	                    String expect5=logoutconfirm;
	                    Assert.assertEquals(expect5, actual5);
	
}

@AfterTest
         public void close() {
	         driver.close();
}


}
