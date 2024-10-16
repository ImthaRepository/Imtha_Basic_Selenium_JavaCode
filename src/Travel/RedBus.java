package Travel;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class RedBus {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("https://www.redbus.in/");
	
//From
	
	Scanner s=new Scanner(System.in);
	System.out.println("Enter Name of the Boarding City");
	String from=s.nextLine();
	//Thread.sleep(10000);
	driver.findElement(By.id("src")).sendKeys(from);
	Thread.sleep(2000);
	//List<WebElement> Fromlist = driver.findElements(By.xpath("//text[@class='placeHolderMainText']"));
	for (int i = 1; i < 4; i++) {
		WebElement fromlist = driver.findElement(By.xpath("(//text[@class='placeHolderMainText'])["+i+"]"));
		String From=fromlist.getText();
		System.out.println(i+"."+From);
	}
		Scanner t=new Scanner(System.in);
		System.out.println("Enter tne Serial Number of the City");
		int number1 =t.nextInt();
		//Thread.sleep(8000);
		driver.findElement(By.xpath("(//text[@class='placeHolderMainText'])["+number1+"]")).click();

//To
		Scanner a =new Scanner(System.in);
		System.out.println("Enter Name of the destination City");
		String to=a.nextLine();
		//Thread.sleep(10000);
		driver.findElement(By.id("dest")).sendKeys(to);
		//List<WebElement> Fromlist = driver.findElements(By.xpath("//text[@class='placeHolderMainText']"));
		Thread.sleep(2000);
		for (int i = 2; i < 4; i++) {
			WebElement tolist = driver.findElement(By.xpath("(//text[@class='placeHolderMainText'])["+i+"]"));
			String to1=tolist.getText();
			System.out.println(i+"."+to1);
		}
			Scanner d=new Scanner(System.in);
			System.out.println("Enter tne Serial Number of the City");
			int number2 =d.nextInt();
			//Thread.sleep(8000);
			driver.findElement(By.xpath("(//text[@class='placeHolderMainText'])["+number2+"]")).click();

//date
			//System.out.println("if the journey date is today just type today");
			Scanner h =new Scanner(System.in);
			System.out.println("if the journey date is today just type today");
			String today=h.nextLine();
			
			if (today.equalsIgnoreCase("today")) {
				driver.findElement(By.xpath("//*[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 fgdqFw']")).click();
			} else {
				System.out.println("select another date");
			
			
			WebElement monthyear = driver. findElement(By.xpath("//*[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD' and text()='2024']"));
			String monthname=monthyear.getText();
			System.out.println(monthname);
			
			Scanner e =new Scanner(System.in);
			System.out.println("Enter number of times to pass your journey month ");
			int month=e.nextInt();
			//Thread.sleep(10000)
			
			for (int i = 0; i <= month; i++) {
							
			driver.findElement(By.id("Layer_1")).click();
			Thread.sleep(2000);
			}
		
			Scanner k =new Scanner(System.in);
			System.out.println("mention journey day is weekday or weekend");
			String daymention=k.nextLine();
			Thread.sleep(2000);
			if (daymention.equalsIgnoreCase("weekday")) {
				
			

			
			
			List<WebElement> weekdaylist = driver.findElements(By.xpath("//*[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 dkWAbH']"));
			
			for (int i = 1; i <= weekdaylist.size(); i++) {
				WebElement date = driver.findElement(By.xpath("(//*[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 dkWAbH'])["+i+"]"));	
				System.out.println(date.getText());
			}

			Scanner f =new Scanner(System.in);
			System.out.println("Enter the day of journey ");
			int weekday=f.nextInt();
			driver.findElement(By.xpath("//*[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 dkWAbH' and text()='"+weekday+"']")).click();
			}
		
			else if (daymention.equalsIgnoreCase("weekend")) {
				Thread.sleep(2000);	
			
           List<WebElement> weekends = driver.findElements(By.xpath("//*[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 bwoYtA']"));
			
			for (int i = 1; i <= weekends.size(); i++) {
				WebElement date = driver.findElement(By.xpath("(//*[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 bwoYtA'])["+i+"]"));	
				System.out.println(date.getText());
			}
			Thread.sleep(3000);
			Scanner i =new Scanner(System.in);
			System.out.println("Enter the day of journey ");
			int weekend=i.nextInt();
			driver.findElement(By.xpath("//*[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 bwoYtA' and text()='"+weekend+"']")).click();
			}
			
			else {
				System.out.println("wrong input restart");
			}
			}		
			driver.findElement(By.id("search_button")).click();
			Thread.sleep(6000);
			//driver.close();
			
}
}
