package setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverSetup {
		 public static WebDriver driver;
		  public WebDriver setup()
		  {
		  System.setProperty("webdriver.chrome.driver","F://chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 String url = "https://genzyme-tst2.prosodie.com/prweb/ar_pssgenzyme/CMtkx-7r92PKKRPHdI1Em6S8D8ceVad_*/!STANDARD";
		 String url1 = "https://genzyme-tst2.prosodie.com/prweb/ar_pssgenzyme/CMtkx-7r92PKKRPHdI1Em6S8D8ceVad_*/!STANDARD";
		 driver.get(url1);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 return driver;
		  }

		  public void quit()
		  {
		  driver.quit();
		  }
		  
		  public void login() {
			  WebElement username = driver.findElement(By.xpath("//input[@id='txtUserID']"));
			  WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
			  WebElement login = driver.findElement(By.xpath("//button[@id='sub']"));
			  username.sendKeys("pct_ar");
			  password.sendKeys("Pega@12345");
			  login.click();
			  WebDriverWait wait = new WebDriverWait(driver, 50);
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Search Patient')]")));
			  driver.findElement(By.xpath("//span[contains(text(),'Search Patient')]")).click();
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Register Patient')]")));
			  driver.findElement(By.xpath("//button[contains(text(),'Register Patient')]")).click();
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Browse')]")));
			  
			  
		  }
		  
		  public void addcountry() {
			  WebElement country = driver.findElement(By.xpath("//div[@id='pyFlowActionHTML']/div/div[1]/div/div/div[4]/div/div[1]/input[1]"));
			//validation for the "Country" field
			  try {
				  country.sendKeys("adad");
				  WebElement state = driver.findElement(By.xpath("//div[@id='pyFlowActionHTML']/div/div[1]/div/div/div[5]/div/div[1]/input[1]"));
				  state.click();
				  WebElement errormsg = driver.findElement(By.xpath("//div[@id='pyFlowActionHTML']/div/div[1]/div/div/div[4]/div/div/div/span"));
				  System.out.println("validation successful");				  
			} catch (Exception e) {
				// TODO: handle exception
				
				System.out.println("validation failed");
			}
			  
			 //sending actual data
			 try {
				country.clear();
				country.sendKeys("Argentina");
				WebElement errormsg = driver.findElement(By.xpath("//div[@id='pyFlowActionHTML']/div/div[1]/div/div/div[4]/div/div/div/span"));
				System.out.println("incorrect validation");
			 } 
			 catch(Exception e) {
				 
				 System.out.println("country added successfully");
			 }
		  }
		}

