package base;

import java.io.File;

import multiScreenShot.MultiScreenShot;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FergHomePage {

	WebDriver driver;
	
	private By toolLink = By.xpath("//a[contains(text(),'Tools')][1]");
	private By toolLink2 = By.xpath("//img[@src='https://api.ferguson.com/dar-step-service/Query?USE_TYPE=ATG_PRIMARY_STANDARD_IMAGE&PRODUCT_ID=4491322']");
	
	private By cutTools = By.xpath("//a[contains(text(),'Cutting Tools')]");
	private By shopDropDown = By.xpath("//div[contains(text(),'Shop By Industry')]");
	private By shopList = By.xpath("//nav[@id='shop-by-industry']//div[@class='mega-nav-secondary-dropdown']//a");
	private By searchBox = By.xpath("//input[@name='search']");
	private By firstReturn = By.xpath("//a[contains(text(),'Clorox 24 oz. Toilet Bowl Cleaner for Tough Stains (Case of 12)')]");
	
	private By heatCoolLink = By.xpath("//img[@alt='Heating & Cooling']");
	//private By loginLink = By.xpath("li[@id='header-login-hover']//a[contains(text(),'Register')]");
	private By loginLink = By.id("header-login-hover");
	private By getStarted = By.linkText("Get Started");
	private By businessAcct = By.xpath("//li//a//p[contains(text(),'Business use ')]");
	private By nuAcctSetup = By.xpath("//p[contains(text(),'I am new to Ferguson')]");
	private By companyName = By.xpath("//input[@id='companyName']");
	private By companyAddress = By.xpath("//input[@id='companyAddress']");
	private By companyCity = By.xpath("//input[@id='companyCity']");
	private By zipCode = By.xpath("//input[@id='zipCode']");
	private By phoneNum = By.id("companyPhone");
	private By stateSelectDropDown = By.xpath("//span[@class='current']");
	
	private By selectWaterWorks = By.id("waterworks");
	private By selectBuilderDesigner = By.xpath("//label[attribute::for='builderDesign']");
	private By firstName = By.id("firstName");
	private By lastName = By.id("lastName");
	private By email = By.id("email");
	//private By highLightOption = By.xpath("//div[@class='sbarContent']//li//span[@class='so-title']");
	private By highLightOption =	By.xpath("//select[@id='companyState']//option");
	private By idahoSelectionFromDropDown = By.xpath("//li[attribute::str='ID']//descendant::span");
//	private By idahoSelectionFromDropDown = By.xpath("//span[attribute::class='so-title' AND contains(text(),'ID - Idaho')]");
	private By microwaveLink = By.linkText("Microwaves");
	
	public void openUp() {
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		  driver = new ChromeDriver();
		 driver.get("https://www.ferguson.com/");
		 driver.manage().window().maximize();
	}
	
	public void clickingItem() {
	//	WebElement toolTimeLink = driver.findElement(toolLink2);
	//	toolTimeLink.click();
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].scrollIntoView();", toolTimeLink);
//		// jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		toolTimeLink.click();
		driver.navigate().to("https://www.ferguson.com/category/tools/_/N-zbq4uc?icid=mrch_hmpg_cat_featured-categories_tools");
		System.out.println("current URL: " + driver.getCurrentUrl());
		
		WebElement cuttingTools = driver.findElement(cutTools);
		cuttingTools.click();
		System.out.println("current URL Now: " + driver.getTitle());
	}
	
	public void endBrowser() {
		driver.close();
	}
	
	public void shoppingList() {
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		WebElement industryDropDown = driver.findElement(shopDropDown);
		Actions act1 = new Actions(driver);
		act1.moveToElement(industryDropDown).perform();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		List<WebElement>dropDownList = driver.findElements(shopList);
		
		for(WebElement we: dropDownList) {
			
			String text = we.getText();
			System.out.println(text);
		}
	}
	
	public void typingToiletcleaner() {
		WebElement searchBoxEnter = driver.findElement(searchBox);
		searchBoxEnter.sendKeys("toilet cleaner");
		searchBoxEnter.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		}
	
	public void takingPictureOfFirstItem() {
		
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy");
		
		//String convertDate = currentDate.toString().replace(":", "_").replace("", "_") + ".png";
		String strDate = sdf.format(currentDate);
//		TakesScreenshot ccScreenShot = (TakesScreenshot)driver;
//		 File source = ccScreenShot.getScreenshotAs(OutputType.FILE);
//		 File destination = new File("C:\\Users\\nnamdi.williams\\eclipse-workspace\\CucumberProject\\Screenshots\\toilet-cleaners.png");
//		 try {
//			FileUtils.copyFile(source,destination);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		 MultiScreenShot mShot=new MultiScreenShot("C:\\Users\\nnamdi.williams\\eclipse-workspace\\CucumberProject\\Screenshots",strDate);
		 try {
			mShot.multiScreenShot(driver); //whole screen shot
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registerButtonClick() {
		WebElement rb = driver.findElement(loginLink);
		rb.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("current URL: " + driver.getCurrentUrl());
		
		
		
		
	}
	
	public void registrationAction() throws InterruptedException {
		
	//	System.out.println("Side Bar.....");

		
		WebElement gs = driver.findElement(getStarted);
		gs.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("current URL: " + driver.getCurrentUrl());
		
		WebElement bizLink = driver.findElement(businessAcct);
		bizLink.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("current URL: " + driver.getCurrentUrl());
		
		System.out.println("Starting the Registration Process....");
		
		WebElement acctSetup = driver.findElement(nuAcctSetup);
		acctSetup.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("current URL: " + driver.getCurrentUrl());
		
		WebElement cName = driver.findElement(companyName);
		cName.sendKeys("XPathTest");
		
		WebElement cAdress = driver.findElement(companyAddress);
		cAdress.sendKeys("60 mockingbird drive");
				
		WebElement cCity = driver.findElement(companyCity);
		cCity.sendKeys("Biose");
		
		WebElement s = driver.findElement(stateSelectDropDown);
		s.click();


//		List<WebElement> idaho = driver.findElements(highLightOption);
//		
//		for(WebElement we: idaho) {
//			String stateText = we.getText();
//			System.out.println("state names: " + stateText);
//		}
//		System.out.println("Program ending....");
//		System.exit(0);
		//s.sendKeys("i");
		
		WebElement idahoSelection = driver.findElement(idahoSelectionFromDropDown);
		
		idahoSelection.click();
		
//		Actions act = new Actions(driver);               //Object of <em>Actions</em> class
//		 
//		 act.sendKeys(Keys.PAGE_DOWN).build().perform();
//		 
//		
//				List<WebElement> idaho = driver.findElements(highLightOption);
//		JavascriptExecutor je = (JavascriptExecutor) driver;
	//	WebElement idaho = driver.findElement(highLightOption);
		
		
		
		//je.executeScript("arguments[0].scrollIntoView(true);",idaho.get(2));
//		Thread.sleep(250);
//		WebDriverWait wait1 = new WebDriverWait(driver, 5);
//		WebElement s = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='companyState']")));
//		s.click();
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		//Select state = new Select(driver.findElement(By.cssSelector("select#companyState.form-control")));
//	Select state = new Select(driver.findElement(By.xpath("//select[@id='companyState']")));
		//Select state = new Select(driver.findElement(By.xpath("//div[@class='form-group']//span[@class='select fifthly']")));
//		
	//	state.selectByValue("ID");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		WebElement zip = driver.findElement(zipCode);
		zip.sendKeys("11801");
		
		WebElement pNum = driver.findElement(phoneNum);
		pNum.sendKeys("8818181432");
		
		
		
		WebElement bd = driver.findElement(selectBuilderDesigner);
		bd.click();
		
		WebElement fName = driver.findElement(firstName);
		fName.sendKeys("fakefirst");
		
		WebElement lName = driver.findElement(lastName);
		lName.sendKeys("fakelast");
		
		WebElement em = driver.findElement(email);
		em.sendKeys("fakefirst@gmail.com");
		
	
		
		
		}
	
	public void applianceLink(){
		
		driver.get("https://www.ferguson.com/category/appliances/_/N-zbq3f1?icid=mrch_hmpg_cat_featured-categories_appliances");
		driver.manage().window().maximize();
		System.out.println("Current URL: " + driver.getCurrentUrl());
	}
	
	public void micLink() {
	WebElement	mic = driver.findElement(microwaveLink);
	mic.click();
		
	}
	
	
}
