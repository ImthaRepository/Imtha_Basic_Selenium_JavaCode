package WebelementAndWebDriver;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DimensionAndPosition {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com");
	driver.manage().deleteAllCookies();
	org.openqa.selenium.Point P=new org.openqa.selenium.Point(350, 250);
	driver.manage().window().setPosition(P);
	org.openqa.selenium.Dimension D=new org.openqa.selenium.Dimension(300, 400);
	driver.manage().window().setSize(D);
}
}
