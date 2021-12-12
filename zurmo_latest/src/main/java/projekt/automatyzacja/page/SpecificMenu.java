package projekt.automatyzacja.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecificMenu {
	
	private WebDriver driver;
	
	public SpecificMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS	
	
	@FindBy(css=".button-action")
	private WebElement createButton;
	
	@FindBy(linkText="Update")
	private WebElement updateMenuButton;
	
	@FindBy(id="list-view-massActionSelected")
	private WebElement updateSelectedSubButton;
	
	@FindBy(id="list-view-massActionAll")
	private WebElement updateAllSubButton;
	
	@FindBy(linkText="Export")
	private WebElement exportMenuButton;
	
	@FindBy(id="list-view-exportActionSelected")
	private WebElement exportSelectedSubButton;
	
	@FindBy(id="list-view-exportActionAll")
	private WebElement exportAllSubButton;
	
	@FindBy(linkText="Delete")
	private WebElement deleteMenuButton;
	
	@FindBy(id="list-view-deleteMassActionSelected")
	private WebElement deleteSelectedSubButton;
	
	@FindBy(id="list-view-deleteMassActionAll")
	private WebElement deleteAllSubButton;
	
	@FindBy(linkText="Subscribe")
	private WebElement subscribeMenuButton;
	
	@FindBy(id="list-view-subscribeMassActionSelected")
	private WebElement subscribeSelectedSubButton;
	
	@FindBy(id="list-view-subscribeMassActionAll")
	private WebElement subscribeAllSubButton;
	
	@FindBy(linkText="Merge")
	private WebElement mergeMenuButton;
	
	@FindBy(id="list-view-listViewMergeSelected")
	private WebElement mergeSelectedSubButton;
	
	
// METHODS ON OBJECTS
	
	public void clickCreate() {
		this.createButton.click();
	}

	public void clickUpdateSelected() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.updateSelectedSubButton);
	}
	
	public void clickUpdateAll() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", updateAllSubButton);
	}
	
	public void clickExportSelected() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.exportSelectedSubButton);
	}
	
	public void clickExportAll() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", exportAllSubButton);
	}
	
	public void clickDeleteSelected() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.deleteSelectedSubButton);
	}
	
	public void clickDeleteAll() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", deleteAllSubButton);
	}
	
	public void clickSubscribeSelected() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", subscribeSelectedSubButton);
	}
	
	public void clickSubscribeAll() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", subscribeAllSubButton);
	}
	
	public void clickMergeSelected() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", mergeSelectedSubButton);
	}
}
