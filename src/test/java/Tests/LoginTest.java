package Tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void testvalidlogin()
	{
	LoginPage login=new LoginPage(driver);
	login.enterusername("admin@yourstore.com");
	login.enterpassword("admin");
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	login.enterloginbutton();
	

	System.out.println("Title of page is :"+driver.getTitle());
	Assert.assertEquals(driver.getTitle(), "Just a moment...");
	
	}

}
