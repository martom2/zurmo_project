package projekt.automatyzacja.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	private WebDriver driver;
	
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS	
	
	
// METHODS ON OBJECTS
	
    public String getPageTitle() {
    	return driver.getTitle();
    }
	
}
