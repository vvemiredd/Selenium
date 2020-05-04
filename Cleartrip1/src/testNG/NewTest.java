package testNG;
import org.testng.annotations.Test;
import setup.DriverSetup;
import setup.ExcelSetup;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class NewTest extends DriverSetup {
	@Test(priority=1)
	public void Login() throws Exception
	 { 
		WebElement Username = driver.findElement(By.xpath("//input[@id='txtUserID']"));
		WebElement Password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		Username.sendKeys("bsop_ar");
		Password.sendKeys("Pega@12345");
		WebElement login = driver.findElement(By.xpath("//button[@id='sub']"));
		login.click();
	 }
	
	@Test(priority=2)
	public void MPOForPatient() throws Exception
	{
		WebElement BSOPHEADER = driver.findElement(By.xpath("//span[contains(text(),'BSOP')]"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(BSOPHEADER));
		BSOPHEADER.click();
		WebElement MPO = driver.findElement(By.xpath("//span[contains(text(),'Manage Purchase Orders')]"));
		MPO.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("PegaGadget0Ifr"));
		String passingPatientId = "19443";
		WebElement patietId = driver.findElement(By.xpath("//body[@class='screen-layout-body']/div[3]/main/div/div/div/div/div/div[1]/div/div/div/div/div/div[1]/div/div/span/input"));
		patietId.click();
		patietId.sendKeys(passingPatientId);
		WebElement Search = driver.findElement(By.xpath("//div[@class=' content  set-width-auto  layout-content-inline content-inline  clearfix ']/div[2]//button"));
		Search.click();
		/*WebElement Row2 = driver.findElement(By.xpath("//table[@id='bodyTbl_right']/tbody/tr[2]"));
		wait.until(ExpectedConditions.visibilityOf(Row2));*/
		Thread.sleep(5000);
		
		//Checking ascending order
		SortASC();
		
		//checking string ascending order
		sortStringASC();
		
		List<WebElement> tdcount = driver.findElements(By.xpath("//table[@id='bodyTbl_right']/tbody/tr[2]/td"));
		if(tdcount.size()>1) {
			List<WebElement> ResultPatientIDs = driver.findElements(By.xpath("//table[@id='bodyTbl_right']/tbody/tr/td[1]/div/span/a"));
			for(WebElement i : ResultPatientIDs) {
				if(i.getText().equals(passingPatientId)){
					i.click();
					break;
				}
			}
		}
		else {
			System.out.println("Patient not available");
		}
		
	}

	
	@Test(priority=3)
	public void MPOStockAddition() throws Exception{
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget1Ifr");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("PegaGadget1Ifr"));
		/*WebElement Quotation = driver.findElement(By.xpath("//span/input[@id='pyDisplayHarness.QuotationNumber']"));*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/input[@id='pyDisplayHarness.QuotationNumber']")));
		Actions action = new Actions(driver);
		
		WebElement QuotationQuantity = driver.findElement(By.xpath("//input[@id='pyDisplayHarness.QuotationQuantity']"));
		
		WebElement QuotationMonth = driver.findElement(By.xpath("//select[@id='$PpyDisplayHarness$pQuotationDateMoSel']"));
		Select SelectQuotationMonth = new Select(QuotationMonth);
		
		WebElement QuotationDay = driver.findElement(By.xpath("//select[@id='$PpyDisplayHarness$pQuotationDateDySel']"));
		Select SelectQuotationDay = new Select(QuotationDay);
		
		WebElement QuotationYear = driver.findElement(By.xpath("//select[@id='$PpyDisplayHarness$pQuotationDateYrSel']"));
		Select SelectQuotationYear = new Select(QuotationYear); 
		
		WebElement Exchangerate = driver.findElement(By.xpath("//input[@id='pyDisplayHarness.ExchangeRate']"));
		
		WebElement Distributor = driver.findElement(By.xpath("//select[@id='Distributor']"));
		Select SelectDistributor = new Select(Distributor);
		
		WebElement shippementOrder = driver.findElement(By.xpath("//input[@id='pyDisplayHarness.ShipmentOrder']"));
		
		WebElement shippementOrderMonth = driver.findElement(By.xpath("//select[@id='$PpyDisplayHarness$pShipmentDateMoSel']"));
		Select SelectshippementOrderMonth = new Select(shippementOrderMonth);
		
		WebElement shippementOrderDay = driver.findElement(By.xpath("//select[@id='$PpyDisplayHarness$pShipmentDateDySel']"));
		Select SelectshippementOrderDay = new Select(shippementOrderDay);
		
		WebElement shippementOrderYear = driver.findElement(By.xpath("//select[@id='$PpyDisplayHarness$pShipmentDateYrSel']"));
		Select SelectshippementOrderYear = new Select(shippementOrderYear); 
		
		WebElement PaymentCondition = driver.findElement(By.xpath("//select[@id='PaymentCondition']"));
		Select SelectPaymentCondition = new Select(PaymentCondition); 
		
		//sending values in MPO screen
		/*action.moveToElement(Quotation).click().sendKeys("abc").build().perform();*/
		QuotationQuantity.sendKeys("5");
		SelectQuotationMonth.selectByVisibleText("Apr");
		SelectQuotationDay.selectByVisibleText("27");
		SelectQuotationYear.selectByVisibleText("2020");
		Exchangerate.sendKeys("15");
		SelectDistributor.selectByVisibleText("ABC");
		shippementOrder.sendKeys("1");
		SelectshippementOrderMonth.selectByVisibleText("Apr");
		SelectshippementOrderDay.selectByVisibleText("27");
		SelectshippementOrderYear.selectByVisibleText("2020");
		SelectPaymentCondition.selectByVisibleText("Check-prepaid");
		
		//WebElement button= driver.findElement(By.xpath("//div[@class='layout layout-noheader layout-noheader-default float-right set-width-auto']/div/div/div[3]/div/div/span/button"));
		/*button.click();*/
		/*List<WebElement> message = driver.findElements(By.xpath("//Span/strong"));
		for(WebElement i : message) {
			if(i.isDisplayed()) {
				System.out.println(i.getText());
			}
		}*/
		
		//validation testing
		String validationXpath = "//span[@id='PegaRULESErrorFlag']";
		String arr[] = {"abcd","^$%^$","abc&^"};
		for(int i=0; i<arr.length; i++) {
			WebElement Quotation = driver.findElement(By.xpath("//span/input[@id='pyDisplayHarness.QuotationNumber']"));
			Quotation.click();
			Quotation.clear();
			Quotation.sendKeys(arr[i]);
			WebElement button= driver.findElement(By.xpath("//div[@class='layout layout-noheader layout-noheader-default float-right set-width-auto']/div/div/div[3]/div/div/span/button"));
			button.click();
			validationCheck(validationXpath);
			Thread.sleep(3000);
		}
		
		
		try {
			String msg = driver.findElement(By.xpath("//Span/strong[text()='Operation executed successfully !!!']")).getText();
			System.out.println(msg);
		}
		catch(Exception e){
			System.out.println("operation failed: case locked by other user");
		}	
	}
	
	public void validationCheck(String xpath) {
		try {
			WebElement validation = driver.findElement(By.xpath(xpath));
			System.out.println(validation.getText());
		}
		catch(Exception e) {
			System.out.println("validation not correct");
		}
	}
	
	public void SortASC() throws Exception{
		WebElement patientid = driver.findElement(By.xpath("//div[@id='gridBody_right']/table/tbody/tr[1]/th[1]/div/div/div[1]"));
		
		patientid.click();
		Thread.sleep(5000);
		checkingSort();
	}
	
	//Integer sorting
	public void checkingSort() {
		WebElement sort = driver.findElement(By.xpath("//div[@id='gridBody_right']/table/tbody/tr[1]/th[1]/div/div/span[2]"));
		
			List<WebElement> patientiddisplayed = driver.findElements(By.xpath("//table[@id='bodyTbl_right']/tbody/tr/td[1]/div/span/a"));
			for(int i =0;i<patientiddisplayed.size()-1;i++) {
				if(Long.parseLong(patientiddisplayed.get(i).getText()) < Long.parseLong(patientiddisplayed.get(i+1).getText())){
					continue;
				}
				else {
					System.out.println("patientid's not sorted in ascending order");
					exit();
				}	
			}
			System.out.println("Patient id's sorted in ascending order");
		
	}
	
	//To call the string ascending order function
	void sortStringASC() throws InterruptedException{
		WebElement patientcordinatorsort = driver.findElement(By.xpath("//div[@id='gridBody_right']/table/tbody/tr[1]/th[11]/div/div/div[1]"));
		patientcordinatorsort.click();
		Thread.sleep(5000);
		List<WebElement> patientcordinatordisplayed = driver.findElements(By.xpath("//table[@id='bodyTbl_right']/tbody/tr/td[11]/div/span"));
		ArrayList<String> al = new ArrayList<>();
		for(WebElement i:patientcordinatordisplayed) {
			al.add(i.getText());
		}
		boolean sortresult=checkSorting(al);
		if(sortresult) {
			System.out.println("PC column is sorted in ascending order");
		}
		else {
			System.out.println("PC column is not sorted ");
		}
	}
	
	    // Here is the code to check if array list is sorted in Ascending order or not
	    boolean checkSorting(ArrayList< String > arraylist){
	        boolean isSorted=true;
	        for(int i=1;i < arraylist.size();i++){
	            if(arraylist.get(i-1).compareTo(arraylist.get(i)) > 0){
	                isSorted= false;
	                break;
	            }
	        }
	        return isSorted;
	    }
	    
	    
	 @AfterMethod
	 public void exit()
	 {
		 
	 }


  @BeforeTest
  public void beforeTest() {
	  driver=setup();
  }

}
