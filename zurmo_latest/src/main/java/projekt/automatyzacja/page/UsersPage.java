package projekt.automatyzacja.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {

	public UsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS	
	@FindBy(id="UsersSearchForm_anyMixedAttributes")
	private WebElement searchBar;
	
	@FindBy(css=".odd > td:nth-child(2) > a:nth-child(1)")
	private WebElement tableFirstNamePosition;
	
// METHODS ON OBJECTS	
	public void textSearchBar(String searchText) {
		this.searchBar.sendKeys(searchText);
	}
	
	public void clickSearchBar(){
		this.searchBar.sendKeys(Keys.ENTER);
	}
	
	public void clickTableFirstNamePosition() {
		this.tableFirstNamePosition.click();
	}
}
