package projekt.automatyzacja.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogItemDetailsPage {
	
	public CatalogItemDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS
	
	@FindBy(css=".form-fields > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)")
	private WebElement name;
	
	@FindBy(css=".form-fields > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)")
	private WebElement description;
	
	@FindBy(css=".form-fields > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)")
	private WebElement categories;
	
	@FindBy(css=".form-fields > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(2)")
	private WebElement status;
	
	@FindBy(css=".form-fields > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(2)")
	private WebElement type;
	
	@FindBy(css=".form-fields > tbody:nth-child(2) > tr:nth-child(6) > td:nth-child(2)")
	private WebElement priceFrequency;
	
	@FindBy(css=".form-fields > tbody:nth-child(2) > tr:nth-child(7) > td:nth-child(2)")
	private WebElement sellPriceFormula;
	
	@FindBy(css=".form-fields > tbody:nth-child(2) > tr:nth-child(8) > td:nth-child(2)")
	private WebElement cost;
	
	@FindBy(css=".form-fields > tbody:nth-child(2) > tr:nth-child(9) > td:nth-child(2)")
	private WebElement listPrice;
	
	@FindBy(css=".form-fields > tbody:nth-child(2) > tr:nth-child(10) > td:nth-child(2)")
	private WebElement sellPrice;

	
// METHODS ON LOCATED OBJECTS
	
    public String readName() {
		return this.name.getText();
	}
	
	public String readDescription() {
		return this.description.getText();
	}
	
	public String readCategories() {
		return this.categories.getText();
	}
	
	public String readStatus() {
		return this.status.getText();
	}
	
	public String readType() {
		return this.type.getText();
	}
	
	public String readPriceFrequency() {
		return this.priceFrequency.getText();
	}
	
	public String readSellPriceFormula() {
		return this.sellPriceFormula.getText();
	}
	
	public String readCost() {
		return this.cost.getText();
	}
	
	public String readListPrice() {
		return this.listPrice.getText();
	}
	
	public String readSellPrice() {
		return this.sellPrice.getText();
	}
	
	
}
