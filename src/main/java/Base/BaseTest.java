package Base;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;

import com.sun.tools.sjavac.Log;

public class BaseTest {
	
	protected WebDriver driver;
	
	
	
	@BeforeMethod
	public void setup()
	{
		//Log.info("Setup of chrome driver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Log.info("Navigating to url...");
		driver.get("https://admin-demo.nopcommerce.com/login");
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		{
		//	Log.info("close the browser....");
			driver.quit();
		}
	}

}
