package projekt.automatyzacja.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS
	
	@FindBy(id="ContactsSearchForm_anyMixedAttributes")
	private WebElement searchBar;
	
	@FindBy(css="tr.odd:nth-child(1) > td:nth-child(1) > label:nth-child(1)")
	private WebElement firstTableCheckbox;
	
	@FindBy(css="tr.odd:nth-child(1) > td:nth-child(3) > a:nth-child(1)")
	private WebElement tableFirsyNamePosition;
	

// METHODS ON OBJECTS
	
	public void textSearchBar(String searchText) {
		this.searchBar.sendKeys(searchText);
	}
	
	public void clickSearchBar(){
		this.searchBar.sendKeys(Keys.ENTER);
	}
	
	public void selectFirstTableCheckbox() {
		this.firstTableCheckbox.click();
	}
	
	public String readTableFirstNamePosition() {
		return this.tableFirsyNamePosition.getText();
	}
	
	public WebElement returnTableFirstNamePositionElement() {
		return tableFirsyNamePosition;
	}
	
	public void clickTableFirstNamePosition() {
		this.tableFirsyNamePosition.click();
	}
	
}
