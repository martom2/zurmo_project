package projekt.automatyzacja.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS	
	
	@FindBy(id="LeadsSearchForm_anyMixedAttributes")
	private WebElement searchBar;
	
	@FindBy(id="list-view-summary-clone")
	private WebElement numberOfSearchResults;
	
	@FindBy(css="tr.odd:nth-child(1) > td:nth-child(1) > label:nth-child(1)")
	private WebElement firstTableCheckbox;
	
	@FindBy(css="tr.odd:nth-child(1) > td:nth-child(3) > a:nth-child(1)")
	private WebElement tableFirsyNamePosition;
	
	@FindBy(css=".jnotify-item > span:nth-child(3)")
	private WebElement alertMessage;
	
//METHODS ON OBJECTS
	
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
		return this.tableFirsyNamePosition;
	}
	
	public void clickTableFirstNamePosition() {
		this.tableFirsyNamePosition.click();
	}
	
	public String readNumberOfSearchResults() {
		return this.numberOfSearchResults.getText();
	}
	
	public String readAlertMessage() {
		return this.alertMessage.getText();
	}
	
}
