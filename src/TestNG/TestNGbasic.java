package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGbasic {



	@BeforeClass
	public void x2(){
		System.out.println("beforeclass");
	}
	@AfterClass
	public void x3() {
		System.out.println("afterclass");
	}
	@BeforeSuite
	public void x4() {
		System.out.println("beforesuite");
	}
	@AfterSuite
	public void x5() {
		System.out.println("aftersuite");
	}
	@Test
	public void x1() {
		System.out.println("Test");
	}
	@BeforeMethod
	public void x6() {
		System.out.println("beforemethod");
	}
	@AfterMethod
	public void x7() {
		System.out.println("aftermethod");
	}
	@BeforeGroups
	public void x8() {
		System.out.println("beforegroup");
	}
	@AfterGroups
	public void x9() {
		System.out.println("aftergroup");
	}
	@BeforeTest
	public void x10() {
		System.out.println("beforetest");
	}
	@AfterTest
	public void x11() {
		System.out.println("aftertest");
	}

}

