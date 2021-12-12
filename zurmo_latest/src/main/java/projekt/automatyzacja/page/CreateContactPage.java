package projekt.automatyzacja.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateContactPage {
	
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS	
	
	@FindBy(id="Contact_title_value")
	private WebElement politeReturn;
	
	@FindBy(id="Contact_firstName")
	private WebElement firstName;
	
	@FindBy(id="Contact_lastName")
	private WebElement lastName;
	
	@FindBy(id="Contact_state_id")
	private WebElement status;
	
	@FindBy(id="Contact_jobTitle")
	private WebElement jobTitle;
	
	@FindBy(id="Contact_account_name")
	private WebElement account;
	
	@FindBy(id="Contact_account_SelectLink")
	private WebElement accountSearch;
	
	@FindBy(id="Contact_department")
	private WebElement department;
	
	@FindBy(id="Contact_officePhone")
	private WebElement officePhone;
	
	@FindBy(id="Contact_source_value")
	private WebElement source;
	
	@FindBy(id="Contact_mobilePhone")
	private WebElement mobilePhone;
	
	@FindBy(id="Contact_officeFax")
	private WebElement officeFax;
	
	@FindBy(id="Contact_primaryEmail_emailAddress")
	private WebElement primaryEmail;
	
	@FindBy(id="Contact_primaryEmail_optOut")
	private WebElement primaryEmailCheckbox;
	
	@FindBy(id="Contact_secondaryEmail_emailAddress")
	private WebElement secondaryEmail;
	
	@FindBy(id="Contact_primaryAddress_street1")
	private WebElement primaryAddressStreet1;
	
	@FindBy(id="Contact_primaryAddress_street2")
	private WebElement primaryAddressStreet2;
	
	@FindBy(id="Contact_primaryAddress_city")
	private WebElement primaryAddressCity;
	
	@FindBy(id="Contact_primaryAddress_state")
	private WebElement primaryAddressState;
	
	@FindBy(id="Contact_primaryAddress_postalCode")
	private WebElement primaryAddressPostalCode;
	
	@FindBy(id="Contact_primaryAddress_country")
	private WebElement primaryAddressCountry;
	
	@FindBy(id="Contact_secondaryAddress_street1")
	private WebElement secondaryAddressStreet1;
	
	@FindBy(id="Contact_secondaryAddress_street2")
	private WebElement secondaryAddressStreet2;
	
	@FindBy(id="Contact_secondaryAddress_city")
	private WebElement secondaryAddressCity;
	
	@FindBy(id="Contact_secondaryAddress_state")
	private WebElement secondaryAddressState;
	
	@FindBy(id="Contact_secondaryAddress_postalCode")
	private WebElement secondaryAddressPostalCode;
	
	@FindBy(id="Contact_secondaryAddress_country")
	private WebElement secondaryAddressCountry;
	
	@FindBy(id="Contact_description")
	private WebElement description;
	
	@FindBy(linkText="Save")
	private WebElement saveButton;
	
	@FindBy(linkText="Cancel")
	private WebElement cancelButton;
	

// METHODS ON OBJECTS
	
	public void selectPoliteReturn(int index) {
		new Select(this.politeReturn).selectByIndex(index);
	}
	
	public void selectPoliteReturn(String politeReturn){
		new Select(this.politeReturn).selectByValue(politeReturn);
	}
	
	public void textFirstName(String first_name) {
		this.firstName.sendKeys(first_name);
	}
	
	public String getTextedFirstName() {
		return this.firstName.getText();
	}
	
	public void clearFirstName() {
		this.firstName.clear();
	}
	
	public void textLastName(String last_name) {
		this.lastName.sendKeys(last_name);
	}
	
	public String getTextedLastName() {
		return this.lastName.getText();
	}
	
	public void clearLastName() {
		this.lastName.clear();
	}

	public void selectStatus(int index) {
		new Select(this.status).selectByIndex(index);
	}
	
	public void selectStatus(String status) {
		new Select(this.status).selectByVisibleText(status);
	}
	
	public void textJobTitle(String job_title) {
		this.jobTitle.sendKeys(job_title);
	}
	
	public void clearJobTitle() {
		this.jobTitle.clear();
	}
	
	public void textAccount(String acc) {
		this.account.sendKeys(acc);
	}
	
	public void clearAccount() {
		this.account.clear();
	}
	
	public void selectAccountSearch() {
		this.accountSearch.click();
	}
	
	public void textDepartment(String dep) {
		this.department.sendKeys(dep);
	}
	
	public void clearDepartment() {
		this.department.clear();
	}
	
	public void textOfficePhone(String officePh) {
		this.officePhone.sendKeys(officePh);
	}
	
	public void clearOfficePhone() {
		this.officePhone.clear();
	}
	
	public void selectSource(int index) {
		new Select(this.source).selectByIndex(index);
	}
	
	public void selectSource(String source) {
		new Select(this.source).selectByValue(source);
	}
	
	public void textMobilePhone(String mobilePh) {
		this.mobilePhone.sendKeys(mobilePh);
	}
	
	public void clearMobilePhone() {
		this.mobilePhone.clear();
	}
	
	public void textOfficeFax(String fax) {
		this.officeFax.sendKeys(fax);
	}
	
	public void clearOfficeFax() {
		this.officeFax.clear();
	}
	
	public void textPrimaryEmail(String primEmail) {
		this.primaryEmail.sendKeys(primEmail);
	}
	
	public void clearPrimaryEmail() {
		this.primaryEmail.clear();
	}
	
	public void tickPrimaryEmailCheckbox() {
		this.primaryEmailCheckbox.click();
	}
	
	public void textSecondaryEmail(String seconEmail) {
		this.secondaryEmail.sendKeys(seconEmail);
	}
	
	public void clearSecondaryEmail() {
		this.secondaryEmail.clear();
	}
	
	public void textPrimaryAddressStreet1(String street1) {
		this.primaryAddressStreet1.sendKeys(street1);
	}
	
	public void clearPrimaryAddressStreet1() {
		this.primaryAddressStreet1.clear();
	}
	
	public void textPrimaryAddressStreet2(String street2) {
		this.primaryAddressStreet2.sendKeys(street2);
	}
	
	public void clearPrimaryAddressStreet2() {
		this.primaryAddressStreet2.clear();
	}
	
	public void textPrimaryAddressCity(String city) {
		this.primaryAddressCity.sendKeys(city);
	}
	
	public void clearPrimaryAddressCity() {
		this.primaryAddressCity.clear();
	}
	
	public void textPrimaryAddressState(String state) {
		this.primaryAddressState.sendKeys(state);
	}
	
	public void clearPrimaryAddressState() {
		this.primaryAddressState.clear();
	}
	
	public void textPrimaryAddressPostalCode(String postalCode) {
		this.primaryAddressPostalCode.sendKeys(postalCode);
	}
	
	public void clearPrimaryAddressPostalCode() {
		this.primaryAddressPostalCode.clear();
	}
	
	public void textPrimaryAddressCountry(String country) {
		this.primaryAddressCountry.sendKeys(country);
	}
	
	public void clearPrimaryAddressCountry() {
		this.primaryAddressCountry.clear();
	}
	
	public void textSecondaryAddressStreet1(String street1) {
		this.secondaryAddressStreet1.sendKeys(street1);
	}
	
	public void clearSecondaryAddressStreet1() {
		this.secondaryAddressStreet1.clear();
	}
	
	public void textSecondaryAddressStreet2(String street2) {
		this.secondaryAddressStreet2.sendKeys(street2);
	}
	
	public void clearSecondaryAddressStreet2() {
		this.secondaryAddressStreet2.clear();
	}
	
	public void textSecondaryAddressCity(String city) {
		this.secondaryAddressCity.sendKeys(city);
	}
	
	public void clearSecondaryAddressCity() {
		this.secondaryAddressCity.clear();
	}
	
	public void textSecondaryAddressState(String state) {
		this.secondaryAddressState.sendKeys(state);
	}
	
	public void clearSecondaryAddressState() {
		this.secondaryAddressState.clear();
	}
	
	public void textSecondaryAddressPostalCode(String postalCode) {
		this.secondaryAddressPostalCode.sendKeys(postalCode);
	}
	
	public void clearSecondaryAddressPostalCode() {
		this.secondaryAddressPostalCode.clear();
	}
	
	public void textSecondaryAddressCountry(String country) {
		this.secondaryAddressCountry.sendKeys(country);
	}
	
	public void clearSecondaryAddressCountry() {
		this.secondaryAddressCountry.clear();
	}
	
	public void textDescription(String desc) {
		this.description.sendKeys(desc);
	}
	
	public void clearDescription() {
		this.description.clear();
	}
	
	public void clickSaveButton() {
		this.saveButton.click();
	}
	
	public void clickCancelButton() {
		this.cancelButton.click();
	}	
}
