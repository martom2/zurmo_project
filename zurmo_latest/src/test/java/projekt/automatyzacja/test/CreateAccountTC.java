package projekt.automatyzacja.test;

import org.testng.annotations.Test;

import projekt.automatyzacja.page.AccountDetailsPage;
import projekt.automatyzacja.page.CreateAccountPage;
import projekt.automatyzacja.page.Menu;
import projekt.automatyzacja.page.SpecificMenu;
import projekt.automatyzacja.testcase.LoginAction;
import projekt.automatyzacja.utility.ExcelUtil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;

public class CreateAccountTC {

	private WebDriver driver;
	private static ExcelUtil excel;
	private Menu menu;
	private SpecificMenu specificMenu;
	private CreateAccountPage createAccountPage;
	private AccountDetailsPage accountDetailsPage;
	
    private String name;
    private String officePhone;
    private String industry;
    private String officeFax;
    private String employees;
    private String annualRevenue;
    private String type;
    private String website;
    private String billingAddressStreet1;
    private String billingAddressStreet2;
    private String billingAddressCity;
    private String billingAddressState;
    private String billingAddressPostalCode;
    private String billingAddressCountry;
    private String shippingAddressStreet1;
    private String shippingAddressStreet2;
    private String shippingAddressCity;
    private String shippingAddressState;
    private String shippingAddressPostalCode;
    private String shippingAddressCountry;
    private String description;    

    
    @Factory(dataProvider = "getData")
    public CreateAccountTC(	String name,
    							String officePhone,
    							String industry,
    							String officeFax,
    							String employees,
    							String annualRevenue,
    							String type,
    							String website,
    							String billingAddressStreet1,
    							String billingAddressStreet2,
    							String billingAddressCity,
    							String billingAddressState,
    							String billingAddressPostalCode,
    							String billingAddressCountry,
    							String shippingAddressStreet1,
    							String shippingAddressStreet2,
    							String shippingAddressCity,
    							String shippingAddressState,
    							String shippingAddressPostalCode,
    							String shippingAddressCountry,
    							String description) {
    	
    	this.name = name;
    	this.officePhone = officePhone;
    	this.industry = industry;
    	this.officeFax = officeFax;
    	this.employees = employees;
    	this.annualRevenue = annualRevenue;
    	this.type = type;
    	this.website = website;
    	this.billingAddressStreet1 = billingAddressStreet1;
    	this.billingAddressStreet2 = billingAddressStreet2;
    	this.billingAddressCity = billingAddressCity;
    	this.billingAddressState = billingAddressState;
    	this.billingAddressPostalCode = billingAddressPostalCode;
    	this.billingAddressCountry = billingAddressCountry;
    	this.shippingAddressStreet1 = shippingAddressStreet1;
    	this.shippingAddressStreet2 = shippingAddressStreet2;
    	this.shippingAddressCity = shippingAddressCity;
    	this.shippingAddressState = shippingAddressState;
    	this.shippingAddressPostalCode = shippingAddressPostalCode;
    	this.shippingAddressCountry = shippingAddressCountry;
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
   * This test case will create a new account
   */
  
  @Test(priority=0)
  public void createAccount() {
	  menu = new Menu(driver);
	  menu.accountsButtonClick();
	  
      specificMenu = new SpecificMenu(driver);
	  specificMenu.clickCreate();
	  
	  createAccountPage = new CreateAccountPage(driver);
	  createAccountPage.textName(this.name);
	  createAccountPage.textOfficePhone(this.officePhone);
	  createAccountPage.selectIndustry(this.industry);
	  createAccountPage.textOfficeFax(this.officeFax);
	  createAccountPage.textEmployees(this.employees);
	  createAccountPage.textAnnualRevenue(this.annualRevenue);
	  createAccountPage.selectType(this.type);
	  createAccountPage.textWebsite(this.website);
	  createAccountPage.textBillingAddressStreet1(this.billingAddressStreet1);
	  createAccountPage.textBillingAddressStreet2(this.billingAddressStreet2);
	  createAccountPage.textBillingAddressCity(this.billingAddressCity);
	  createAccountPage.textBillingAddressState(this.billingAddressState);
	  createAccountPage.textBillingAddressPostalCode(this.billingAddressPostalCode);
	  createAccountPage.textBillingAddressCountry(this.billingAddressCountry);
	  createAccountPage.textShippingAddressStreet1(this.shippingAddressStreet1);
	  createAccountPage.textShippingAddressStreet2(this.shippingAddressStreet2);
	  createAccountPage.textShippingAddressCity(this.shippingAddressCity);
	  createAccountPage.textShippingAddressState(this.shippingAddressState);
	  createAccountPage.textShippingAddressPostalCode(this.shippingAddressPostalCode);
	  createAccountPage.textShippingAddressCountry(this.shippingAddressCountry);
	  createAccountPage.textDescription(this.description);
	  createAccountPage.clickSaveButton();

	  try {
	  WebElement saveDuplicates = (new WebDriverWait(driver, 30))
			  .until(ExpectedConditions.presenceOfElementLocated(By.linkText("click here")));
	  saveDuplicates.click();
	  } catch (TimeoutException e) {
		  e.printStackTrace();
	  }
	  
  }
  

  @Test(priority=1, dependsOnMethods={"createAccount"})
  public void verifyCreatedAccount() {
	  
	  accountDetailsPage = new AccountDetailsPage(driver);
	  
	  (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.left-column:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"))); 
	  
	  Assert.assertEquals(accountDetailsPage.readName(), this.name);
	  Assert.assertEquals(accountDetailsPage.readOfficePhone(), this.officePhone);
	  Assert.assertEquals(accountDetailsPage.readIndustry(), industry);
	  Assert.assertEquals(accountDetailsPage.readOfficeFax(), this.officeFax);
	  Assert.assertEquals(accountDetailsPage.readEmployees(), this.employees);
	  Assert.assertEquals(accountDetailsPage.readAnnualRevenue(), this.annualRevenue);
	  Assert.assertEquals(accountDetailsPage.readType(), this.type);
	  Assert.assertEquals(accountDetailsPage.readWebsite(), this.website);
	  Assert.assertEquals(accountDetailsPage.readBillingAddressStreet1(), this.billingAddressStreet1);
	  Assert.assertEquals(accountDetailsPage.readBillingAddressStreet2(), this.billingAddressStreet2);
	  Assert.assertEquals(accountDetailsPage.readBillingAddressCity(), this.billingAddressCity);
	  Assert.assertEquals(accountDetailsPage.readBillingAddressState(), this.billingAddressState);
	  Assert.assertEquals(accountDetailsPage.readBillingAddressPostalCode(), this.billingAddressPostalCode);
	  Assert.assertEquals(accountDetailsPage.readShippingAddressStreet1(), this.shippingAddressStreet1);
	  Assert.assertEquals(accountDetailsPage.readShippingAddressStreet2(), this.shippingAddressStreet2);
	  Assert.assertEquals(accountDetailsPage.readShippingAddressCity(), this.shippingAddressCity);
	  Assert.assertEquals(accountDetailsPage.readShippingAddressState(), this.shippingAddressState);
	  Assert.assertEquals(accountDetailsPage.readShippingAddressPostalCode(), this.shippingAddressPostalCode);
	  Assert.assertEquals(accountDetailsPage.readDescription(), this.description);
	  

  }
  
  @AfterClass
  public void afterSuite() {
	  driver.quit();
  }

  @DataProvider
  private static String[][] getData(ITestContext context) {

	  excel = new ExcelUtil("createAccount.xlsx", "Arkusz1"); 
	  
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
