package TestNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class DemoRetryAnalyser implements IRetryAnalyzer{
int min=0,max=3;

@Override
public boolean retry(ITestResult result) {
	if (min<max) {
		min++;
		
		return true;
	}  
	return false;
}

}
