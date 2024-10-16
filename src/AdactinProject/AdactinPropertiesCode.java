package AdactinProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;

public class AdactinPropertiesCode extends BaseCode{
	public static String url ,username, password, loginconfirm, entrydate, exitdate, hotelconfirm,
	firstname, lastname, address, crdnum, cvv, bookconfirm, cancelconfirm,logoutconfirm;

@BeforeTest
	      public void properties() throws IOException {
		      FileInputStream f=new FileInputStream("C:\\Users\\RRR\\Documents\\Eclipse\\Java_Selinium\\src\\AdactinProject\\InputfileForAdactin");
		      p.load(f);
			
		        url=p.getProperty("url");
				username=p.getProperty("username");
				password=p.getProperty("password");
				loginconfirm=p.getProperty("loginconfirm");
				entrydate=p.getProperty("entrydate");
				exitdate=p.getProperty("exitdate");
				hotelconfirm=p.getProperty("hotelconfirm");
				firstname=p.getProperty("firstname");
				lastname=p.getProperty("lastname");
				address=p.getProperty("address");
				crdnum=p.getProperty("crdnum");
				cvv=p.getProperty("cvv");
				bookconfirm=p.getProperty("bookconfirm");
				cancelconfirm=p.getProperty("cancelconfirm");
				logoutconfirm=p.getProperty("logoutconfirm");
					

	}
}
