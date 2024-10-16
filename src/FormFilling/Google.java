package FormFilling;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Google {
WebDriver driver;
@Test
    public void entry() {
	     driver=new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     driver.get("https://support.google.com/mail/answer/56256?hl=en");
	
	     driver.findElement(By.linkText("Create an account")).click();

//Window Handle	    
	     String page1 = driver.getWindowHandle();
	     Set<String> allpage = driver.getWindowHandles();
	    for (String allpage1 : allpage) {
		  if (!page1.equals (allpage1)){
			  driver.switchTo().window(allpage1);
}}
	    
//Selection of Type of Account
        driver.findElement(By.xpath("//span[text()='Create account']")).click();
        for (int i = 1; i <= 3; i++) {
	    String namelist="(//span[@class='VfPpkd-StrnGf-rymPhb-b9t22c'])["+i+"]";
	    WebElement text = driver.findElement(By.xpath(namelist));
	    String typeOfAccount=text.getText();
	    System.out.println(i+"."+typeOfAccount);
 }
        Scanner s =new Scanner(System.in);
	    System.out.println("Enter the serial number of type of account");
	    int purchase= s.nextInt();
	    driver.findElement(By.xpath("(//span[@class='VfPpkd-StrnGf-rymPhb-b9t22c'])["+purchase+"]")).click();

}

@Test
    public void page1() {
	      
	       Scanner l =new Scanner(System.in);
           System.out.println("Enter your First Name");
           String first= l.nextLine();
           driver.findElement(By.id("firstName")).sendKeys(first);
	     
	     Scanner m =new Scanner(System.in);
         System.out.println("Enter your Last Name");
         String last= m.nextLine();
	     driver.findElement(By.id("lastName")).sendKeys(last);
	   
	     driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d']")).click();
	     
	         try {
	        	 WebElement assert1 = driver.findElement(By.xpath("//div[@jsname='B34EJ']"));
	    	     String error1=assert1.getText();
	        	 System.out.println(error1);
	    	     Assert.assertEquals(true, false);
		}    catch (Exception e) {
					System.out.println("1st page comepleted Successfully");
		}
	     
}

@Test	
    public void page2() throws InterruptedException{
//Month Selection
	     List<WebElement> months = driver.findElements(By.id("month"));
	         for (WebElement monthlist: months) {
	 		     System.out.println(monthlist.getText());
	 	}
  	    
	     
	           Scanner c =new Scanner(System.in);
		       System.out.println("Enter the month of birth starts with capital letter");
		       String month= c.nextLine();
		       WebElement month1 = driver.findElement(By.id("month"));

	              Select a=new Select(month1);
	              a.selectByVisibleText(month);

//Day Selection	
	     
	     Scanner b =new Scanner(System.in);
		 System.out.println("Enter the Day of birth");
		 String day= b.nextLine();
		 driver.findElement(By.id("day")).sendKeys(day);  
		 
//Year Selection
		 
		 Scanner d =new Scanner(System.in);
		 System.out.println("Enter the Year of birth");
		 String year= d.nextLine();
		 driver.findElement(By.id("year")).sendKeys(year);

//Gender Selection
		 
		 List<WebElement> genders = driver.findElements(By.id("gender"));
	     for (WebElement genderlist: genders) {
	 		 System.out.println(genderlist.getText());
	 	}
  	    
	     
	         Scanner e =new Scanner(System.in);
		     System.out.println("Enter the gender");
		     String gender= e.nextLine();
		     WebElement gend = driver.findElement(By.id("gender"));

	         Select f=new Select(gend);
	         f.selectByVisibleText(gender);
	    
	     driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d']")).click();    
}
@Test
public void page3() throws InterruptedException {

//Email ID Suggestion
		Thread.sleep(2000);
	    List<WebElement> suggestion = driver.findElements(By.xpath("//div[@jsname='V67aGc']//div[@class='dJVBl wIAG6d']"));
	        for (int i = 1; i <= suggestion.size(); i++) {
    	        String suggestionlist="(//div[@jsname='V67aGc']//div[@class='dJVBl wIAG6d'])["+i+"]";
    	        WebElement value = driver.findElement(By.xpath(suggestionlist));
    	        String list=value.getText();
    	        System.out.println(list);
	}				
       	               Scanner g =new Scanner(System.in);
                       System.out.println("Enter your suggestion number");
                       Integer suggest= g.nextInt();
                       WebElement suggestions = driver.findElement(By.xpath("(//div[@jsname='V67aGc'])["+suggest+"]"));
                       String oursuggestion=suggestions.getText();
                       //System.out.println("Your email id is "+oursuggestion);
                       suggestions.click();
                       Thread.sleep(2000);
                    		
                       try {
						
					 if (oursuggestion!="Create your own Gmail address") {
                    			driver.findElement(By.xpath("//span[text()='Next']")).click();
						}} catch (Exception e) {
				
                                   Scanner i =new Scanner(System.in);
                                   System.out.println("Enter your suggestion");
                                   String ownnames= i.nextLine();
                                   driver.findElement(By.name("Username")).sendKeys(ownnames);
                                   driver.findElement(By.xpath("//span[text()='Next']")).click();
                                  
							
                           while ((driver.findElement(By.xpath("//div[@class='Ekjuhf Jj6Lae']")).getText()=="That username is taken. Try another.")) {
                        	    Scanner k =new Scanner(System.in);
                                System.out.println("Enter your suggestion");
                                String ownname= k.nextLine();
                                driver.findElement(By.name("Username")).sendKeys(ownname);
                                driver.findElement(By.xpath("//span[text()='Next']")).click();
                            
                        }
                    		   }
                    		//   driver.findElement(By.xpath("//span[text()='Next']")).click();
//                try {
//			
//		 
//                       WebElement pass = driver.findElement(By.xpath("//h1[@class='vAV9bf']"));
//            		     String next=pass.getText();
//                       System.out.println(next);
//                       System.out.println("next page moved successfully");
//                 }
//					catch (Exception e) {
//						 System.out.println("Username Already Exists");
//            			}
				
//        	  if (suggest="Create your own Gmail address") {
//          		 Scanner i =new Scanner(System.in);
//                   System.out.println("Enter your suggestion");
//                   String ownnames= i.nextLine();
//                   driver.findElement(By.name("Username")).sendKeys(ownnames);
//                   System.out.println(driver.findElement(By.xpath("//span[text()='Next']")).getText()); 
//                  
//                    if {
//                	     WebElement exist = driver.findElement(By.xpath("//div[@class='Ekjuhf Jj6Lae']"));
//                	     String exists=exist.getText();
//                	     System.out.println(exists);
//            }       else {
//           	             System.out.println("Username Accepted");
//			}   
//		}}    while (exists=="That username is taken. Try another.") {
//                    
//                                   	
//			}		
			
          
}
}

