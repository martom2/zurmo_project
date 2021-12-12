package projekt.automatyzacja.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

	public Menu(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS	
	
	@FindBy(linkText="Home")
	private WebElement homeButton;
	
	@FindBy(partialLinkText="Inbox")
	private WebElement inboxButton;
	
	@FindBy(linkText="Accounts")
	private WebElement accountsButton;
	
	@FindBy(linkText="Leads")
	private WebElement leadsButton;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsButton;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesButton;
	
	@FindBy(className="toggle-hidden-nav-items")
	private WebElement dotsButton;
	
	@FindBy(linkText="Marketing")
	private WebElement marketingButton;
	
	@FindBy(linkText="Projects")
	private WebElement projectsButton;
	
	@FindBy(linkText="Products")
	private WebElement productsButton;
	
	@FindBy(linkText="Reports")
	private WebElement reportsButton;
	
	
//METHODS ON OBJECTS
	
	public void homeButtonClick() {
		this.homeButton.click();
	}
	
	public void inboxButtonClick() {
		this.inboxButton.click();
	}
	
	public void accountsButtonClick() {
		this.accountsButton.click();
	}
	
	public void leadsButtonClick() {
		this.leadsButton.click();
	}
	
	public void contactsButtonClick() {
		this.contactsButton.click();
	}
	
	public void opportunitiesButtonClick() {
		this.opportunitiesButton.click();
	}
	
	public void dotsButtonClick() {
		this.dotsButton.click();
	}
	
	public void marketingButtonClick() {
		this.marketingButton.click();
	}
	
	public void projectsButtonClick() {
		this.projectsButton.click();
	}
	
	public void productsButtonClick() {
		this.productsButton.click();
	}
	
	public void reportsButtonClick() {
		this.reportsButton.click();
	}

}
