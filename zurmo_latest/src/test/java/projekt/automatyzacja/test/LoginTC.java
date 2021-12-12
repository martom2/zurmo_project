package projekt.automatyzacja.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;
import projekt.automatyzacja.page.*;
import projekt.automatyzacja.utility.ExcelUtil;

public class LoginTC {

	private WebDriver driver;
	private static ExcelUtil excel;
	private LoginPage loginPage;
	private WelcomePage welcomePage;

	private String userLogin;
	private String userPassword;
	
	@Factory(dataProvider = "getData")
    public LoginTC(	String userLogin,
		    		String userPassword) 
	{
		this.userLogin = userLogin;
		this.userPassword = userPassword;		
	}
    
    @BeforeClass
    public void setUp(){
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
    }

    /**
     * This test case will login in http://localhost/zurmo
     * Verify login page title
     * Login to application
     * Verify the home page
     */

    @Test(priority=0)
    public void loginToZurmo() {
      loginPage = new LoginPage(driver);
	  String loginPageTitle = loginPage.getPageTitle();
	  Assert.assertTrue(loginPageTitle.toLowerCase().contains("zurmocrm - sign in"));
	   
	  loginPage.login(this.userLogin, this.userPassword);

	  //Verify home page
	  welcomePage = new WelcomePage(driver);
	  	
	  //Wait until
	  (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
	  Assert.assertTrue(welcomePage.getPageTitle().toLowerCase().contains("zurmocrm - home"));
    }	
    
    @AfterClass
    public void quitBrowser() {
    	driver.quit();
    }
    
  @DataProvider
  private static String[][] getData(ITestContext context) {

	  excel = new ExcelUtil("loginTC.xlsx", "Arkusz2"); 
	  
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
