package TestNG;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class PriorityInvocationEnableSkipDependsOnMethods {
@Test(priority = 8)
public void method1() {
	System.out.println("Method 1 pass");
}
@Test(priority = 7)
public void method2() {
	System.out.println("Method 2 pass");
}
@Test(priority = 6,invocationCount = 3)
public void method3() {
	System.out.println("Method 3 pass");
}
@Test(priority = 5,enabled = false)
public void method4() {
	System.out.println("Method 4 pass");
}
@Test(priority = 4,enabled=true,dependsOnMethods = {"method3"} )
public void method5() {
	
	System.out.println("Method 5 pass");
	throw new SkipException("skipped");
}
@Test(priority = 3)
public void method6() {
	System.out.println("Method 6 pass");
}
@Test(priority = 2)
public void method7() {
	System.out.println("Method 7 pass");
}
@Test(priority = -1)
public void method8() {
	System.out.println("Method 8 pass");
}

}
