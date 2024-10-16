package TestNG;

import org.testng.annotations.Test;

public class Grp1 {
@Test
public void method1() {
	System.out.println("This is method 1");
}
@Test(groups = "imtha")
public void method2() {
	System.out.println("This is method 2");
}
@Test
public void method3() {
	System.out.println("This is method 3");
}
}