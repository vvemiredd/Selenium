package testNG;

import org.testng.annotations.Test;

import setup.DriverSetup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class RegisterPatient extends DriverSetup {
  @Test
  public void homepage() {
	  login();
	  addcountry();
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver=setup();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
