package projekt.automatyzacja.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
// LOCATED OBJECTS	
	
    @FindBy(id="LoginForm_username")
	private WebElement userName;

    @FindBy(id="LoginForm_password")
	private WebElement password;
	
	@FindBy(id="Login")
	private WebElement signIn;
	
	@FindBy(id="LoginForm_password_em_")
	private WebElement passwordMessage;
	   
// METHODS ON OBJECTS
	  
    public void setUserName(String strUserName){
        this.userName.sendKeys(strUserName);
    }

    public void setPassword(String strPassword){
         this.password.sendKeys(strPassword);
    }

    public void clickSignIn(){
         this.signIn.click();
    }
    
    public String getPageTitle() {
    	return driver.getTitle();
    }
    
    public String getPasswordMessage() {
    	return this.passwordMessage.getText();
    }
    
//GROUP METHODS
    
    public void login(String username, String password) {
    	setUserName(username);
    	setPassword(password);
    	clickSignIn();
    }

}

	

