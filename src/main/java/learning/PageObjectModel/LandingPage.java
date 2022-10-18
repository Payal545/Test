package learning.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import learning.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}// constructor
	
	
	
	@FindBy(id="userEmail")
	WebElement uemail;
	
	@FindBy(id="userPassword")
	WebElement pass;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(xpath="//div[contains(@class,'ng-animating')]")
	WebElement toast;
	
	@FindBy (css=".text-reset")
	WebElement register;
	
	public ProductsCatalogue loginCreds(String email, String passw) throws InterruptedException {
		uemail.sendKeys(email);
		pass.sendKeys(passw);
		submit.click();
		ProductsCatalogue productsCatalogue = new ProductsCatalogue(driver);
		return productsCatalogue;
	}//loginCreds
	
	public void Landing_url() {
		driver.get("https://rahulshettyacademy.com/client");
	}//webAddress
	
	
	public void ToastMsg() {
		
		String str = toast.getText();
		
		  if(str.equalsIgnoreCase("Incorrect email or password.")) {
		  register.click(); }else {
			  System.out.println(""); 
		  }
		 
		
	}//ToastMsg
	
	

}
