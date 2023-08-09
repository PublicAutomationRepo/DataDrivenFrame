package testCases;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import main.Main;
import main.Utilities;

@Listeners(Main.class)
public class Page1 extends Main{
	
	
	@Test
	public void test1() {
		
		test = extent.createTest("This test case is to Print Test Data for User 1");
		
		
		
		test.log(Status.INFO, "Entering First Name" );
		
		System.out.println("FirSt Name : "+Utilities.getData("FirstName"));
		test.log(Status.INFO, "Entering Last Name" );
		
		System.out.println("Last Name : "+Utilities.getData("LastName"));
		test.log(Status.INFO, "Entering City" );
		
		System.out.println("City : "+Utilities.getData("City"));
		test.log(Status.INFO, "Entering State" );
		
		System.out.println("State: "+Utilities.getData("State"));
		test.log(Status.INFO, "Entering Country" );
		
		System.out.println("Country : "+Utilities.getData("Country"));
	}
	
	@Test
	public void test2() {
		
		test = extent.createTest("This test case is to Print Test Data for User 2");
		
		test.log(Status.INFO, "Entering First Name" );
		System.out.println("FirSt Name : "+Utilities.getData("FirstName"));
		test.log(Status.INFO, "Entering Last Name" );
		System.out.println("Last Name : "+Utilities.getData("LastName"));
		test.log(Status.INFO, "Entering City" );
		System.out.println("City : "+Utilities.getData("City"));
		test.log(Status.INFO, "Entering State" );
		System.out.println("State: "+Utilities.getData("State"));
		test.log(Status.INFO, "Entering Country" );
		System.out.println("Country : "+Utilities.getData("Country"));
		
	}
	
	@Test
	public void test3() {
				
		test = extent.createTest("This test case is to Print Test Data for User 3");
		
		
		
		test.log(Status.INFO, "Entering First Name" );
		System.out.println("FirSt Name : "+Utilities.getData("FirstName"));
		test.log(Status.INFO, "Entering Last Name" );
		System.out.println("Last Name : "+Utilities.getData("LastName"));
		test.log(Status.INFO, "Entering City" );
		System.out.println("City : "+Utilities.getData("City"));
		test.log(Status.INFO, "Entering State" );
		System.out.println("State: "+Utilities.getData("State"));
		test.log(Status.INFO, "Entering Country" );
		System.out.println("Country : "+Utilities.getData("Country"));
		
		Assert.assertEquals(false, true); // Failing test cases intentionally
		
	}


}
