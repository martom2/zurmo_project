package projekt.automatyzacja.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOpportunityPage {
	
	WebDriver driver;
	
	public CreateOpportunityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS	

	@FindBy(id="Opportunity_name")
	private WebElement name;
	
	@FindBy(id="Opportunity_amount_currency_id")
	private WebElement amountCurrency;
	
	@FindBy(id="Opportunity_amount_value")
	private WebElement amountValue;
	
	@FindBy(id="Opportunity_account_name")
	private WebElement account;
	
	@FindBy(id="Opportunity_account_SelectLink")
	private WebElement accountSearch;
	
	@FindBy(id="Opportunity_closeDate")
	private WebElement closeDate;
	
	@FindBy(className="ui-datepicker-trigger")
	private WebElement closeDateCalendar;
	
	@FindBy(id="Opportunity_stage_value")
	private WebElement stage;
	
	@FindBy(id="Opportunity_probability")
	private WebElement probability;
	
	@FindBy(id="Opportunity_source_value")
	private WebElement source;
	
	@FindBy(id="Opportunity_description")
	private WebElement description;
	
	@FindBy(linkText="Save")
	private WebElement saveButton;
	
	@FindBy(linkText="Cancel")
	private WebElement cancelButton;
	
	
	
//METHODS ON OBJECTS
	
	public void textName(String name) {
		this.name.sendKeys(name);
	}
	
	public void selectAmountCurrency(int index) {
		new Select(this.amountCurrency).selectByIndex(index);
	}
	
	public void selectAmountCurrency(String currency) {
		new Select(this.amountCurrency).selectByVisibleText(currency);
	}
	
	public void textAmountValue(String amount) {
		this.amountValue.sendKeys(amount);
	}
	
	public void clearAmountValue() {
		this.amountValue.clear();
	}
	
	public void textAccount(String account) {
		this.account.sendKeys(account);
		WebElement el = driver.findElement(By.id("ui-id-5"));
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.textToBePresentInElement(el, account));
		el.click();
		
	}
	
	public void selectAccountSearch() {
		this.accountSearch.click();
	}
	
	public void textCloseDate(String closeDate) {
		this.closeDate.sendKeys(closeDate);
	}
	
	public void selectCloseDateCalendar() {
		this.closeDateCalendar.click();
	}
	
	
	public void selectStage(int index) {
		new Select(this.stage).selectByIndex(index);
	}
	
	public void selectStage(String stage) {
		new Select(this.stage).selectByVisibleText(stage);
	}
	
	public void textProbability(String probability) {
		this.probability.sendKeys(probability);
	}
	
	public void selectSource(int index) {
		new Select(source).selectByIndex(index);
	}
	
	public void selectSource(String source) {
		new Select(this.source).selectByVisibleText(source);;
	}
	
	public void textDescription(String desc) {
		description.sendKeys(desc);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public void clickCancelButton() {
		cancelButton.click();
	}
	
}
