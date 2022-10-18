package learning.PageObjectModel;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
//import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

import learning.AbstractComponents.AbstractComponent;


public class MainCode2 extends AbstractComponent {
	
	

	public MainCode2(WebDriver driver) {
		super(driver);
		
	}

	public static void main(String[] args) throws InterruptedException {
		//Scanner so=new Scanner(System.in);
		//System.out.println("Enter the mail id: ");
		String email = "hackingnuts@gmail.com";
		//System.out.println("Enter your password: ");
		String pass = "Payal@93";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
		String prodName = "ZARA COAT 3";
		LandingPage lp = new LandingPage(driver);
		
		//website address
		lp.Landing_url();
		
		//loginMethod
		ProductsCatalogue productsCatalogue = lp.loginCreds(email, pass);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//div[contains(@class,'ng-animating')]")));
		//toast
		lp.ToastMsg();
		
		//products catalogue
		//ProductsCatalogue productsCatalogue = new ProductsCatalogue(driver);
		//List<WebElement> products = productsCatalogue.getProductsList();
		productsCatalogue.addProductToCart(prodName);
		
		//click on add to cart
		lp.goToCart();
		
		//verify elements in the cart
		CartPage cp = new CartPage(driver);
		boolean match = cp.VerifyProductElements(prodName);
		//Assert.asserTrue(match);
		System.out.println(match);
		//cp.goToCheckout();
		
		//checkoutpage
		CheckoutPage checkoutPage = cp.goToCheckout();
		checkoutPage.selectCountry("india");
		checkoutPage.submitOrder();
		
		//confirmation
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		System.out.println(confirmMessage);
		driver.close();
	}

}
