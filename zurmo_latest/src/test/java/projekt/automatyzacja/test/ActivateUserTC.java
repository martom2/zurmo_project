package projekt.automatyzacja.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import junit.framework.Assert;
import projekt.automatyzacja.page.EditUserPage;
import projekt.automatyzacja.page.TopMenuPage;
import projekt.automatyzacja.page.UserDetailsPage;
import projekt.automatyzacja.page.UsersPage;
import projekt.automatyzacja.page.WelcomePage;
import projekt.automatyzacja.testcase.LoginAction;
import projekt.automatyzacja.utility.ExcelUtil;

public class ActivateUserTC {

	private WebDriver driver;
	private static ExcelUtil excel;
	private TopMenuPage topMenuPage;
	private UsersPage usersPage;
	private UserDetailsPage usersDetailsPage;
	private EditUserPage editUsersPage;
	private WelcomePage welcomePage;
	
	private String firstName;
	private String lastName;
	private String userLogin;
	private String userPassword;
	
	@Factory(dataProvider = "getData")
    public ActivateUserTC(	String firstName,
				    		String lastName,
				    		String userLogin,
				    		String userPassword) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.userLogin = userLogin;
		this.userPassword = userPassword;		
	}
	
	  @BeforeClass
	  public void setUp() {
	  	System.setProperty("webdriver.gecko.driver", "C:\\javalibs\\geckodriver-v0.20.1-win32\\geckodriver.exe");
		
	  	FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("security.sandbox.content.level", 5);
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability(FirefoxDriver.PROFILE, profile);
		FirefoxOptions opt = new FirefoxOptions();
		opt.merge(cap);
		driver = new FirefoxDriver(opt);
			
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	    String baseUrl = "http://localhost/zurmo";
		driver.get(baseUrl);
		
		LoginAction.login(driver, "super", "super");
		
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
		  
	  }
		
	  /**
	   * This test case will activate an user
	   */
	  
	  @Test(priority=0)
	  public void activateUser() {
		  
	    topMenuPage = new TopMenuPage(driver);
		topMenuPage.clickUsersLink();
		
		usersPage = new UsersPage(driver);
		String searchText = this.firstName + " " + this.lastName;
		usersPage.textSearchBar(searchText);
		usersPage.clickSearchBar();
		 (new WebDriverWait(driver, 60)).until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".odd > td:nth-child(2) > a:nth-child(1)"), searchText));
		 usersPage.clickTableFirstNamePosition();
		
		usersDetailsPage = new UserDetailsPage(driver);
		usersDetailsPage.clickEditButton();
		
		editUsersPage = new EditUserPage(driver);
		editUsersPage.selectStatus("Active");
		editUsersPage.clickSaveButton();
		
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id("sliding-panel-toggle")));
		
		topMenuPage.clickSignOutLink();
		  
	  }
	  
	  @Test(priority=1, dependsOnMethods={"activateUser"})
	  public void verifyInactivationOfUser() {
		  
	      (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id("LoginForm_username")));
			
		  LoginAction.login(driver, this.userLogin, this.userPassword);
		  
		  welcomePage = new WelcomePage(driver);
		  	
		  (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
		  System.out.println("a: "+welcomePage.getPageTitle().toLowerCase());
		  
		  Assert.assertTrue(welcomePage.getPageTitle().toLowerCase().contains("zurmocrm - home"));
		  
	  }
	  
    @AfterClass
    public void quitBrowser() {
    	driver.quit();
    }
	  
	  
	  @DataProvider
	  private static String[][] getData(ITestContext context) {

		  excel = new ExcelUtil("users.xlsx", "Arkusz2"); 
		  
	      int rowsNumber = excel.getNumberOfRows();
	      int cellsNumber = excel.getNumberOfCellsInARow(0);
	      
		  System.out.println("ROWS "+rowsNumber);
	      
		  List<List<String>> excelData = new ArrayList<List<String>>();
		  
	      for(int i = 0; i < rowsNumber-1; i++) //Loop work for Rows
	      {            
	    	  List<String> sublist = new ArrayList<String>();
	    	  
	          for (int j = 0; j < cellsNumber; j++) //Loop work for colNum
	          {
	             String jCell = excel.getCellData(i+1, j); 
	          
	             if(jCell == "") sublist.add(null);
	             else sublist.add(jCell);       
	           }
	          
	          boolean nullsOnly = sublist.stream().noneMatch(Objects::nonNull);
	          if (!nullsOnly) excelData.add(sublist);
	      }
	      
	      
	      String[][] returnValues = new String[excelData.size()][cellsNumber];
	      
	      for(int i = 0; i < excelData.size(); i++) //Loop work for Rows
	      {            
	          for (int j = 0; j < cellsNumber; j++) //Loop work for colNum
	          {
	             String jCell = excelData.get(i).get(j);          
	         	 returnValues[i][j] = jCell; //This formatter get my all values as string i.e integer, float all type data value       
	           }
	      }
	      return returnValues;   
	  }
}
