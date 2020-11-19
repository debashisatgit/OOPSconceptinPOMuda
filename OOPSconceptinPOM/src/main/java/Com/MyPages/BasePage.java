package Com.MyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {     //1.after extending Page class to base class add the constructor
		super(driver);
		
		
	}                                      //2.then add the unimplemented methods of abstract class which is difened at page class

	@Override
	public String getPageTitle() {
		return driver.getTitle();          //3. add the implementation here for those abstract class methods
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
			}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;			
		}
		catch (Exception e) {
			System.out.println("some error came out" + locator.toString());
			e.printStackTrace();
			
		}
		return element;

	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e) {
			System.out.println("some error came" + locator.toString());
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e) {
			System.out.println("some error came" + title);
		}
	}
	
	
	
	
	
	
	

}
