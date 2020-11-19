package Com.MyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	                              //1.create a abstract class under the src main 
	WebDriver driver;            //2. create 2 variables 
	WebDriverWait wait;
	
	                           //3.Create the constructor of this abstract class- can create the obj allowed, how to creatre 
	                                                 //the constructor of abstract class constructor name should be same as class name
	
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 15);   //4.syntex of explecite wait
	}
	
	//5. define abstract methods- without method body
	
	public abstract String getPageTitle();     //only method declaration no method body - abstract keyword is mandatory - return string
	
	public abstract String getPageHeader(By locator);
		
	public abstract WebElement getElement(By locator);
	
	public abstract void waitForElementPresent(By locator);
	
	public abstract void waitForPageTitle(String title);
	
	
	public <Tpage extends BasePage> Tpage getInstance(Class<Tpage> pageclass) {
		
		try {
			
		return pageclass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
	}
	catch(Exception e) {
		e.printStackTrace();
		return null;
	}
	

	
	}
	

}
