package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.support.ui.FluentWait;

public class GooglePage
{
	//Locators of element as properties in page class
	@FindBy(name="q")
	private WebElement serachbox;
	
	//Constructor method
	public GooglePage(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Operations and observations methods
	public void fillSearchboxAndClickEnter(String data, FluentWait<RemoteWebDriver> w)
	{
		w.until(visibilityOf(serachbox)).clear();
		w.until(visibilityOf(serachbox)).sendKeys(data, Keys.ENTER);
	}
	
	public boolean verifyTitle(RemoteWebDriver driver, String expected)
	{
		if(driver.getTitle().contains(expected))
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
}
