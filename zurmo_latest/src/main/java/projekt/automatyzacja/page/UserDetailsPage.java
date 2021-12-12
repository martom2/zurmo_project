package projekt.automatyzacja.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDetailsPage {
	
	public UserDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS
	
	@FindBy(linkText="Edit")
	private WebElement editButton;
	
// METHODS ON OBJECTS
	
	public void clickEditButton(){
		this.editButton.click();
	}
}
