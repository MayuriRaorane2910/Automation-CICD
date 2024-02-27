package mayuriraoraneacademy.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mayuriraoraneacademy.PageObject.LandingPage;
import mayuriraoraneacademy.PageObject.ProductCataloug;
import mayuriraoraneacademy.PageObject.cartPage;
import mayuriraoraneacademy.PageObject.checkOutPage;
import mayuriraoraneacademy.PageObject.confirmatonPage;
import mayuriraoraneacademy.TestComponents.BaseTest;

public class StepDefinationImpl extends BaseTest{

	public LandingPage landingpage;
	public ProductCataloug productcataloug;
	public confirmatonPage ConfirmmationPage;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException 
	{
		landingPage = launchApplication();	
		
	}
	
	  @Given ("^Logged in with username(.+) and password(.+)$")
	  
	  public void logged_in_username_and_password(String username, String password) {
		  
		  ProductCataloug productcataloug = landingPage.LoginApplication(username,password);
		  
  }

	  @When ("^I add product(.+)to cart&")
	  public void I_add_product_to_cart(String productName)
	  {
		  
		  List<WebElement> products = productcataloug.getProductList();
			productcataloug.addProductToCart(productName);
			
	  }
	  @When("^checkout(.+)and submit the order$")
	  public void checkout_and_submit_the_order(String productName) throws InterruptedException {
		  	cartPage cartpage = productcataloug.goToCartPage();
			Boolean match = cartpage.verifyProductDisplay(productName);
			Assert.assertTrue(match);
			Thread.sleep(2000);
			checkOutPage checkoutpage = cartpage.goTocheckOut();
			checkoutpage.selectCountry("India");
			confirmatonPage ConfirmmationPage = checkoutpage.submitOrder();
	  
	  }
	  
	  @Then ("{string}message is displayed on confirmation page")
	  
	  public void message_displayed_confirmation_page(String string) {
		  
		  String ConfirmMessage = ConfirmmationPage.getconfirmationMessage();
		  Assert.assertTrue(ConfirmMessage.equalsIgnoreCase(string));
		  
	  }
	  
	  
	  
	 
	  @  Then ("{string} message is displayed.")
	  public void message_is_displayed(String strArg1) {
		  Assert.assertEquals("Incorrect email password.", landingPage.getErrorMessage()); 
		  driver.close();
		  
	  }
	  
}
