package projekt.automatyzacja.testcase;

import org.openqa.selenium.WebDriver;

import projekt.automatyzacja.page.LoginPage;

public class LoginAction {
	
  public static void login(WebDriver driver, final String username, final String password) { 
	  LoginPage loginPage = new LoginPage(driver);
	    loginPage.setUserName(username);
	    loginPage.setPassword(password);
	    loginPage.clickSignIn();   
	  }


}
