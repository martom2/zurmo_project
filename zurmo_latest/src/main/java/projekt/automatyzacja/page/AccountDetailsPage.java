package projekt.automatyzacja.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDetailsPage {
	
	public AccountDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS
	
	@FindBy(id="sliding-panel-toggle")
	private WebElement switchViewButton;
	
    @FindBy(css="div.left-column:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)")
    private WebElement name;
	
	@FindBy(css="div.left-column:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)")
	private WebElement officePhone;
	
	@FindBy(css="div.left-column:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)")
	private WebElement industry;
	
	@FindBy(css="div.left-column:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(2)")
	private WebElement officeFax;
	
	@FindBy(css="div.left-column:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(2)")
	private WebElement employees;
	
	@FindBy(css="div.left-column:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(6) > td:nth-child(2)")
	private WebElement annualRevenue;
	
	@FindBy(css="div.left-column:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(7) > td:nth-child(2)")
	private WebElement type;
	
	@FindBy(css="div.left-column:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(8) > td:nth-child(2)")
	private WebElement website;
	
	@FindBy(id="Account_billingAddress_MapLink")
	private WebElement billingAddressAll;
	
	@FindBy(id="Account_shippingAddress_MapLink")
	private WebElement shippingAddressAll;
	
	@FindBy(css="div.left-column:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(11) > td:nth-child(2)")
	private WebElement description;
	
// METHODS ON LOCATED OBJECTS

    public void clickSwitchViewButton() {
		this.switchViewButton.click();
	}
	
	public String readName(){
		return this.name.getText();
	}
	
	public String readOfficePhone() {
		return this.officePhone.getText();
	}
	
	public String readIndustry() {
		return this.industry.getText();
	}
	
	public String readOfficeFax() {
		return this.officeFax.getText();
	}
	
	public String readEmployees() {
		return this.employees.getText();
	}
	
	public String readAnnualRevenue() {
		return this.annualRevenue.getText();
	}
	
	public String readType() {
		return this.type.getText();
	}
	
	public String readWebsite() {
		return this.website.getText();
	}
	
	public String readBillingAddressAll() {
		return this.billingAddressAll.getText();
	}
	
	public String readBillingAddressStreet1() {
		String readBillingAddressAll = this.readBillingAddressAll();
		String[] readBillingAddressLines = readBillingAddressAll.split("\\n");
		
		return readBillingAddressLines[0];
	}
	
	public String readBillingAddressStreet2() {
		String readBillingAddressAll = this.readBillingAddressAll();
		String[] readBillingAddressLines = readBillingAddressAll.split("\\n");
		
		return readBillingAddressLines[1];
	}
	
	
	public String readBillingAddressCity() {
		String readBillingAddressAll = this.readBillingAddressAll();
		String[] readBillingAddressLines = readBillingAddressAll.split("\\n");
		String[] readBillingAddressAllThridLine = readBillingAddressLines[2].split(" ");
		
		return readBillingAddressAllThridLine[0];
	}
	
	public String readBillingAddressState() {
		String readBillingAddressAll = this.readBillingAddressAll();
		String[] readBillingAddressLines = readBillingAddressAll.split("\\n");
		String[] readBillingAddressAllThridLine = readBillingAddressLines[2].split(" ");
		
		return readBillingAddressAllThridLine[1].substring(0, readBillingAddressAllThridLine[1].length()-1);
	}
	
	public String readBillingAddressPostalCode() {
		String readBillingAddressAll = this.readBillingAddressAll();
		String[] readBillingAddressLines = readBillingAddressAll.split("\\n");
		String[] readBillingAddressAllThridLine = readBillingAddressLines[2].split(" ");
		
		return readBillingAddressAllThridLine[2];
	}
	
	public String readShippingAddressAll() {
		return this.shippingAddressAll.getText();
	}
	
	public String readShippingAddressStreet1() {
		String readShippingAddressAll = this.readShippingAddressAll();
		String[] readShippingAddressLines = readShippingAddressAll.split("\\n");
		
		return readShippingAddressLines[0];
	}
	
	public String readShippingAddressStreet2() {
		String readShippingAddressAll = this.readShippingAddressAll();
		String[] readShippingAddressLines = readShippingAddressAll.split("\\n");
		
		return readShippingAddressLines[1];
	}
	
	
	public String readShippingAddressCity() {
		String readShippingAddressAll = this.readShippingAddressAll();
		String[] readShippingAddressLines = readShippingAddressAll.split("\\n");
		String[] readShippingAddressAllThridLine = readShippingAddressLines[2].split(" ");
		
		return readShippingAddressAllThridLine[0];
	}
	
	public String readShippingAddressState() {
		String readShippingAddressAll = this.readShippingAddressAll();
		String[] readShippingAddressLines = readShippingAddressAll.split("\\n");
		String[] readShippingAddressAllThridLine = readShippingAddressLines[2].split(" ");
		
		return readShippingAddressAllThridLine[1].substring(0, readShippingAddressAllThridLine[1].length()-1);
	}
	
	public String readShippingAddressPostalCode() {
		String readShippingAddressAll = this.readShippingAddressAll();
		String[] readShippingAddressLines = readShippingAddressAll.split("\\n");
		String[] readShippingAddressAllThridLine = readShippingAddressLines[2].split(" ");
		
		return readShippingAddressAllThridLine[2];
	}
	
	public String readDescription() {
		return this.description.getText();
	}
	
}
