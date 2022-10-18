package learning.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import learning.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cart h3")
	private List<WebElement> productTitles;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	public boolean VerifyProductElements(String productName) {
		
		boolean match =  productTitles.stream().anyMatch(prod->prod.getText().equals(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		return new CheckoutPage(driver);
	}

}
