package projekt.automatyzacja.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPage {

	public ContactDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS	
	
	@FindBy(css="#ContactDetailsAndRelationsView_11 > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")
	private WebElement optionsButton;
	
	@FindBy(linkText="Edit")
	private WebElement optionsEditSubButton;
	
	@FindBy(id="sliding-panel-toggle")
	private WebElement switchViewButton;
	
	@FindBy(css="#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)")
	private WebElement name;
	
	@FindBy(css="#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)")
	private WebElement status;
	
	@FindBy(css="#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)")
	private WebElement jobTitle;
	
	@FindBy(css="#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(2)")
	private WebElement account;
	
	@FindBy(css="#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(2)")
	private WebElement department;
	
	@FindBy(css="#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(6) > td:nth-child(2)")
	private WebElement officePhone;
	
	@FindBy(css="#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(7) > td:nth-child(2)")
	private WebElement source;
	
	@FindBy(css="#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(8) > td:nth-child(2)")
	private WebElement mobilePhone;
	
	@FindBy(css="#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(9) > td:nth-child(2)")
	private WebElement officeFax;
	
	@FindBy(css="#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(10) > td:nth-child(2) > a:nth-child(1)")
	private WebElement primaryEmail;
	
	@FindBy(css="#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(11) > td:nth-child(2) > a:nth-child(1)")
	private WebElement secondaryEmail;
	
	@FindBy(id="Contact_primaryAddress_MapLink")
	private WebElement primaryAddressAll;
	
	@FindBy(css="#Contact_secondaryAddress_MapLink")
	private WebElement secondaryAddressAll;
	
	@FindBy(css="#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(14) > td:nth-child(2)")
	private WebElement description;
	
	
//METHODS ON OBJECTS
	
    public void clickOptionsButton() {
		this.optionsButton.click();
	}
	
	public void clickOptionsEditSubButton() {
		this.optionsEditSubButton.click();
	}
	
	public void clickSwitchViewButton() {
		this.switchViewButton.click();
	}
	
	public String readName(){
		return this.name.getText();
	}
	
	public String readStatus() {
		return this.status.getText();
	}
	
	public String readJobTitle() {
		return this.jobTitle.getText();
	}
	
	public String readAccount() {
		return this.account.getText();
	}
	
	public String readDepartment() {
		return this.department.getText();
	}
	
	public String readOfficePhone() {
		return this.officePhone.getText();
	}
	
	public String readSource() {
		return this.source.getText();
	}
	
	public String readMobilePhone() {
		return this.mobilePhone.getText();
	}
	
	public String readOfficeFax() {
		return this.officeFax.getText();
	}
	
	public String readPrimaryEmail() {
		return this.primaryEmail.getText();
	}
	
	public String readSecondaryEmail() {
		return this.secondaryEmail.getText();
	}
	
	public String readPrimaryAddressAll() {
		return this.primaryAddressAll.getText();
	}
	
	public String readPrimaryAddressStreet1() {
		String readPrimaryAddressAll = this.readPrimaryAddressAll();
		String[] readPrimaryAddressLines = readPrimaryAddressAll.split("\\n");
		
		return readPrimaryAddressLines[0];
	}
	
	public String readPrimaryAddressStreet2() {
		String readPrimaryAddressAll = this.readPrimaryAddressAll();
		String[] readPrimaryAddressLines = readPrimaryAddressAll.split("\\n");
		
		return readPrimaryAddressLines[1];
	}
	
	public String readPrimaryAddressCity() {
		String readPrimaryAddressAll = this.readPrimaryAddressAll();
		String[] readPrimaryAddressLines = readPrimaryAddressAll.split("\\n");
		String[] readPrimaryAddressAllThridLine = readPrimaryAddressLines[2].split(" ");
		
		return readPrimaryAddressAllThridLine[0];
	}
	
	public String readPrimaryAddressState() {
		String readPrimaryAddressAll = this.readPrimaryAddressAll();
		String[] readPrimaryAddressLines = readPrimaryAddressAll.split("\\n");
		String[] readPrimaryAddressAllThridLine = readPrimaryAddressLines[2].split(" ");
		
		return readPrimaryAddressAllThridLine[1].substring(0, readPrimaryAddressAllThridLine[1].length()-1);
	}
	
	public String readPrimaryAddressPostalCode() {
		String readPrimaryAddressAll = this.readPrimaryAddressAll();
		String[] readPrimaryAddressLines = readPrimaryAddressAll.split("\\n");
		String[] readPrimaryAddressAllThridLine = readPrimaryAddressLines[2].split(" ");
		
		return readPrimaryAddressAllThridLine[2];
	}
	
	public String readPrimaryAddressCountry() {
		String readPrimaryAddressAll = this.readPrimaryAddressAll();
		String[] readPrimaryAddressLines = readPrimaryAddressAll.split("\\n");
		
		return readPrimaryAddressLines[3];
	}
	
	public String readSecondaryAddressAll() {
		return this.secondaryAddressAll.getText();
	}
	
	public String readSecondaryAddressStreet1() {
		String readSecondaryAddressAll = this.readSecondaryAddressAll();
		String[] readSecondaryAddressLines = readSecondaryAddressAll.split("\\n");
		
		return readSecondaryAddressLines[0];
	}
	
	public String readSecondaryAddressStreet2() {
		String readSecondaryAddressAll = this.readSecondaryAddressAll();
		String[] readSecondaryAddressLines = readSecondaryAddressAll.split("\\n");
		
		return readSecondaryAddressLines[1];
	}
	
	public String readSecondaryAddressCity() {
		String readSecondaryAddressAll = this.readSecondaryAddressAll();
		String[] readSecondaryAddressLines = readSecondaryAddressAll.split("\\n");
		String[] readSecondaryAddressAllThridLine = readSecondaryAddressLines[2].split(" ");
		
		return readSecondaryAddressAllThridLine[0];
	}
	
	public String readSecondaryAddressState() {
		String readSecondaryAddressAll = this.readSecondaryAddressAll();
		String[] readSecondaryAddressLines = readSecondaryAddressAll.split("\\n");
		String[] readSecondaryAddressAllThridLine = readSecondaryAddressLines[2].split(" ");
		
		return readSecondaryAddressAllThridLine[1].substring(0, readSecondaryAddressAllThridLine[1].length()-1);
	}
	
	public String readSecondaryAddressPostalCode() {
		String readSecondaryAddressAll = this.readSecondaryAddressAll();
		String[] readSecondaryAddressLines = readSecondaryAddressAll.split("\\n");
		String[] readSecondaryAddressAllThridLine = readSecondaryAddressLines[2].split(" ");
		
		return readSecondaryAddressAllThridLine[2];
	}
	
	public String readSecondaryAddressCountry() {
		String readSecondaryAddressAll = this.readSecondaryAddressAll();
		String[] readSecondaryAddressLines = readSecondaryAddressAll.split("\\n");
		
		return readSecondaryAddressLines[3];
	}
	
	public String readDescription() {
		return this.description.getText();
	}
	
}
