package projekt.automatyzacja.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

	private WebDriver driver;
	
	public TopMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS
	
	@FindBy(linkText="Sign out")
	private WebElement signOutLink;
	
	@FindBy(linkText="Administration")
	private WebElement administrationIcon;
	
	@FindBy(linkText="Users")
	private WebElement usersLink;
	
	
// METHODS ON OBJECTS
	
	public void clickAdministrationIcon(){
		this.administrationIcon.click();
	}
	
	public void clickUsersLink(){
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.usersLink);
	}
	
	public void clickSignOutLink(){
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.signOutLink);
	}
	
}
