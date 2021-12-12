package projekt.automatyzacja.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	private WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS	
	
	@FindBy(linkText="Products")
	private WebElement products;
	
	@FindBy(linkText="Create Product")
	private WebElement createProduct;
	
	@FindBy(linkText="Catalog Items")
	private WebElement catalogItems;
	
	@FindBy(linkText="Create Catalog Item")
	private WebElement createCatalogItem;
	
	@FindBy(linkText="Categories")
	private WebElement categories;
	
	@FindBy(linkText="Create Category")
	private WebElement createCategory;
	
	
// METHODS ON OBJECTS
	
	public void clickProducs(){
		this.products.click();
	}
	
	public void clickCreateProduct() {
		WebElement el = this.createProduct;
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", el);
	}
	
	public void clickCatalogItems(){
		this.catalogItems.click();
	}
	
	public void clickCreateCatalogItem() {
		WebElement el = this.createCatalogItem;
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", el);
	}
	
	public void clickCategories(){
		this.categories.click();
	}
	
	public void clickCreateCategory() {
		WebElement el = this.createCategory;
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", el);
	}
}
