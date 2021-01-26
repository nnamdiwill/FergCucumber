package stepDefs;

import base.FergHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FergStepDefs {

	FergHomePage fhp = new FergHomePage();
	@Given("^open browser$")
	public void openBrowser() {
		fhp.openUp();
	}
	
	@And("^click on item$")
	public void clickItem() {
		fhp.clickingItem();
	}
	
	@Then("^close browser$")
	public void closeBrowser() {
		fhp.endBrowser();
	}
	
	@Given("^opens browser$")
	public void openingBrowser() {
		fhp.openUp();
	}
	
	@And("^clicks on tools$")
	public void clickingTools() {
		fhp.clickingItem();
	}
	
	@And("^gets shop by industry list$")
	public void shopIndustryList() {
		
		fhp.shoppingList();
	}
	
	@And("^Types toilet cleaner$")
	public void typeToiletCleaner() {
		fhp.typingToiletcleaner();
	}
	
	@Then("^Take picture of first item and close browser$")
	public void takeToiletCleanerPic() {
		fhp.takingPictureOfFirstItem();
		fhp.endBrowser();
	}
	
	@Given("^open the browser$")
	public void browserOpens() {
		fhp.openUp();
	}
	
	@And("^Click on Register button$")
	public void clickRegister() {
		fhp.registerButtonClick();
	}
	
	@And("^Register account$")
	public void registerAcct() throws InterruptedException {
		fhp.registrationAction();
	}
	
	@Then("^browser close$")
	public void browserCloses() {
		fhp.endBrowser();
	}
	
	@Given("Open the appliance link")
	public void open_the_appliance_link() {
	   
	}


	@And("Click Microwave Link")
	public void click_microwave_link() {
	   
	}
	@And("Add Microwave to cart")
	public void add_microwave_to_cart() {
	    
	}
	@Then("Go to checkout")
	public void go_to_checkout() {
	    
	}



	
}
