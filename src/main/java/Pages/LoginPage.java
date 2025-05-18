package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	
	@FindBy(id="Email")
	WebElement usernameTextBox;
	
	@FindBy(id="Password")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement LoginButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//private By usernameTextBox=By.id("Email");
	//private By passwordTextBox=By.id("Password");
	//private By LoginButton=By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");
	

	
	public void enterusername(String username)
	{
		usernameTextBox.clear();
		usernameTextBox.sendKeys(username);
	}
	

	public void enterpassword(String password)
	{
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
	}
	
	public void enterloginbutton()
	{
		LoginButton.click();
	}
	
	
}
