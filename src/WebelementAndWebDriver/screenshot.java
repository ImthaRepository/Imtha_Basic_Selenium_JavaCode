package WebelementAndWebDriver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class screenshot {
public static void main(String[] args) throws IOException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.com/search?q=gmail&rlz=1C1YTUH_enIN1035IN1035&oq=gma&aqs=chrome.0.69i59j0i433i512j69i57j0i433i512l2j0i131i433i512j69i61j69i60.1166j0j7&sourceid=chrome&ie=UTF-8");
	TakesScreenshot browser=(TakesScreenshot)driver;
	File source=browser.getScreenshotAs(OutputType.FILE);
	Files.copy(source,new File("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\screeshots\\image.png"));
}
}
