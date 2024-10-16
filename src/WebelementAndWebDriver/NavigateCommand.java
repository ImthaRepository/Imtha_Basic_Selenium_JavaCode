package WebelementAndWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateCommand {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.navigate().to("https://www.facebook.com");
Thread.sleep(3000);
driver.navigate().to("https://www.google.com/search?q=gmail&rlz=1C1YTUH_enIN1035IN1035&oq=gmail&aqs=chrome..69i57.869j0j7&sourceid=chrome&ie=UTF-8");
Thread.sleep(3000);
driver.navigate().back();
Thread.sleep(3000);
driver.navigate().forward();
Thread.sleep(3000);
driver.navigate().refresh();
Thread.sleep(4000);
driver.close();
}
}
