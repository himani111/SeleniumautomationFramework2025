package Tests;

import java.io.IOException;
import java.time.Duration;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Base.BaseTest;
import Pages.LoginPage;
import Utils.ExcelUtils;

public class LoginTest extends BaseTest {
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException
	{
		String FilePath=System.getProperty("user.dir")+"/testData/TestData.xlsx";
		ExcelUtils.loadExcel(FilePath, "Sheet1");
	int rowCount=	ExcelUtils.getRowCount();
	Object[][] data=new Object[rowCount-1][2];
	for(int i=1;i<rowCount;i++)
	{
		data[i-1][0]=ExcelUtils.getCellData(i, 0);//row
		data[i-1][1]=ExcelUtils.getCellData(i, 1);//col
		
	}
	ExcelUtils.closeWorkbook();
	return data;
	}
	
	@Test(dataProvider="LoginData")
	public void testvalidlogin(String username, String password)
	{
	LoginPage login=new LoginPage(driver);
	//login.enterusername("admin@yourstore.com");
	//login.enterpassword("admin");
	login.enterusername(username);
	login.enterpassword(password);
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	login.enterloginbutton();
	

	System.out.println("Title of page is :"+driver.getTitle());
	Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
	
	}

}
