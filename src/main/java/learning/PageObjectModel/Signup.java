package learning.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import learning.AbstractComponents.AbstractComponent;

public class Signup extends MainCode {
	
	WebDriver driver;
	
	public Signup(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}//constructor
	
	@FindBy(id="firstName")
	WebElement fname;
	
	@FindBy(id="lastName")
	WebElement lname;
	
	@FindBy(id="userMobile")
	WebElement phonenumber;
	
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id="login")
	WebElement register;
	
	@FindBy(css=".ng-pristine.ng-invalid")
	WebElement checkbox;
	
    public void Register(String umail, String upass) {
    	fname.sendKeys("Alankar");
    	lname.sendKeys("Sharma");
    	phonenumber.sendKeys("8550065858");
    	email.sendKeys(umail);
    	password.sendKeys(upass);
    	confirmPassword.sendKeys(upass);
    	checkbox.click();
    	register.click();
    	
    }
}


