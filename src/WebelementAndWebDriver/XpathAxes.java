package WebelementAndWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.zomato.com/chennai/delivery?dishv2_id=30308");
	WebElement biryani = driver.findElement(By.xpath("//div[@class='sc-hENMEE bVdEgD']/child::a[@class='sc-bvCTgw dIvKTC']/child::div[@class='sc-ghUbLI lbumXf']/child::h4[text()='Paradise Biryani - A Legend Since 1953']"));
biryani.click();
//div[@class='col-lg-2 text-left']/child::input[@value='2016']/following-sibling::input[@value='BMW']/following-sibling::input[@value='535i']/parent::*/following-sibling::div//a//i[@class='fa fa-plus']
}
}
