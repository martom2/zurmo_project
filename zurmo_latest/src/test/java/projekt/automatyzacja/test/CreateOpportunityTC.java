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
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import projekt.automatyzacja.page.CreateOpportunityPage;
import projekt.automatyzacja.page.Menu;
import projekt.automatyzacja.page.OpportunityDetailsPage;
import projekt.automatyzacja.page.SpecificMenu;
import projekt.automatyzacja.testcase.LoginAction;
import projekt.automatyzacja.utility.ExcelUtil;

public class CreateOpportunityTC {

	private WebDriver driver;
	private static ExcelUtil excel;
	private Menu menu;
	private SpecificMenu specificMenu;
	private CreateOpportunityPage createOpportunityPage;
	private OpportunityDetailsPage opportunityDetailsPage;
	
    private String name;
    private String amountCurrency;
    private String amountValue;
    private String account;
    private String closeDate;
    private String stage;
    private String probability;
    private String source;
    private String description;
	
	
    @Factory(dataProvider = "getData")
    public CreateOpportunityTC(     String name,
						    	    String amountCurrency,
						    	    String amountValue,
						    	    String account,
						    	    String closeDate,
						    	    String stage,
						    	    String probability,
						    	    String source,
						    	    String description)
    {
        this.name = name;
        this.amountCurrency = amountCurrency;
        this.amountValue = amountValue;
        this.account = account;
        this.closeDate = closeDate;
        this.stage = stage;
        this.probability = probability;
        this.source = source;
        this.description = description;	
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
   * This test case will create a new opportunity
   */
  
  @Test(priority=0)
  public void createOpportunity() {
	  menu = new Menu(driver);
	  menu.opportunitiesButtonClick();
	  
      specificMenu = new SpecificMenu(driver);
	  specificMenu.clickCreate();
	  
	  createOpportunityPage = new CreateOpportunityPage(driver);
	  createOpportunityPage.textName(this.name);
	  createOpportunityPage.selectAmountCurrency(this.amountCurrency);
	  createOpportunityPage.clearAmountValue();
	  createOpportunityPage.textAmountValue(this.amountValue);
	  createOpportunityPage.textAccount(this.account);
	  createOpportunityPage.textCloseDate(this.closeDate);
	  createOpportunityPage.selectStage(this.stage);
	  createOpportunityPage.selectSource(this.source);
	  createOpportunityPage.textDescription(this.description);
	  createOpportunityPage.clickSaveButton();
  }

  @Test(priority=1, dependsOnMethods={"createOpportunity"})
  public void verifyCreatedOpportunity() {
	  
	  opportunityDetailsPage = new OpportunityDetailsPage(driver);
	  
	  (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.left-column:nth-child(1) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > th:nth-child(1)"))); 
	  
	  Assert.assertEquals(opportunityDetailsPage.readName(), this.name);
	  Assert.assertEquals(opportunityDetailsPage.readAmount(), "$"+this.amountValue+".00");
	  Assert.assertEquals(opportunityDetailsPage.readAccount(), this.account);
	  Assert.assertEquals(opportunityDetailsPage.readCloseDate(), this.closeDate);
	  Assert.assertEquals(opportunityDetailsPage.readStage(), this.stage);
	  Assert.assertEquals(opportunityDetailsPage.readSource(), this.source);
	  Assert.assertEquals(opportunityDetailsPage.readDescription(), this.description);
  }
  
  @AfterClass
  public void afterSuite() {
	  driver.quit();
  }
	
  @DataProvider
  private static String[][] getData(ITestContext context) {

	  excel = new ExcelUtil("createOpportunity.xlsx", "Arkusz2"); 
	  
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
