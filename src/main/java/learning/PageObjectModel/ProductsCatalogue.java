package learning.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import learning.AbstractComponents.AbstractComponent;

public class ProductsCatalogue extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductsCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By allProducts = By.cssSelector(".mb-3");
	By addToCart =  By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	

	public List<WebElement> getProductsList(){
		waitForElementToAppear(allProducts);
		return products;
	}
	
	public WebElement GetProductName(String productName) {
		WebElement prod = getProductsList().stream().filter(product->
		product.findElement(By.cssSelector("b"))
		.getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = GetProductName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}

}
