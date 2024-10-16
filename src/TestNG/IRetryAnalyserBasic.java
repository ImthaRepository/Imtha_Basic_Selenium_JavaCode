package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IRetryAnalyserBasic {
@Test
public void method1() {
	System.out.println("Method 1 pass");
}
@Test (retryAnalyzer = DemoRetryAnalyser.class)
public void method2() {
	Assert.assertFalse(true);
	System.out.println("method 2 pass");
}
@Test
public void method3() {
	System.out.println("Method 3 Pass");
}
}
