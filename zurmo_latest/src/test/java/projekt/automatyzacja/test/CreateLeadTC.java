package projekt.automatyzacja.test;

import org.testng.annotations.Test;

import projekt.automatyzacja.page.CreateLeadPage;
import projekt.automatyzacja.page.LeadDetailsPage;
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

public class CreateLeadTC {

	private WebDriver driver;
	private static ExcelUtil excel;
	private Menu menu;
	private SpecificMenu specificMenu;
	private CreateLeadPage createLeadPage;
	private LeadDetailsPage leadDetailsPage;
	
	
	  private String politeReturn;
	  private String firstName;
	  private String lastName;
	  private String status;
	  private String jobTitle;
	  private String companyName;
	  private String department;
	  private String officePhone;
	  private String source;
	  private String mobilePhone;
	  private String officeFax;
	  private String primaryEmail;
	  private String secondaryEmail;
	  private String primaryAddressStreet1;
	  private String primaryAddressStreet2;
	  private String primaryAddressCity;
	  private String primaryAddressState;
	  private String primaryAddressPostalCode;
	  private String primaryAddressCountry;
	  private String secondaryAddressStreet1;
	  private String secondaryAddressStreet2;
	  private String secondaryAddressCity;
	  private String secondaryAddressState;
	  private String secondaryAddressPostalCode;
	  private String secondaryAddressCountry;
	  private String website;
	  private String description;
	  private String industry;
	  
	  @Factory(dataProvider = "getData")
	  public CreateLeadTC(	  String politeReturn,
							  String firstName,
							  String lastName,
							  String status,
							  String jobTitle,
							  String companyName,
							  String department,
							  String officePhone,
							  String source,
							  String mobilePhone,
							  String officeFax,
							  String primaryEmail,
							  String secondaryEmail,
							  String primaryAddressStreet1,
							  String primaryAddressStreet2,
							  String primaryAddressCity,
							  String primaryAddressState,
							  String primaryAddressPostalCode,
							  String primaryAddressCountry,
							  String secondaryAddressStreet1,
							  String secondaryAddressStreet2,
							  String secondaryAddressCity,
							  String secondaryAddressState,
							  String secondaryAddressPostalCode,
							  String secondaryAddressCountry,
							  String website,
							  String description,
							  String industry)
	  {
		    this.politeReturn = politeReturn;
			this.firstName = firstName;
			this.lastName = lastName;
			this.status = status;
			this.jobTitle = jobTitle;
			this.companyName = companyName;
			this.department = department;
			this.officePhone = officePhone;
			this.source = source;
			this.mobilePhone = mobilePhone;
			this.officeFax =  officeFax;
			this.primaryEmail = primaryEmail;
			this.secondaryEmail = secondaryEmail;
			this.primaryAddressStreet1 = primaryAddressStreet1;
			this.primaryAddressStreet2 = primaryAddressStreet2;
			this.primaryAddressCity = primaryAddressCity;
			this.primaryAddressState = primaryAddressState;
			this.primaryAddressPostalCode = primaryAddressPostalCode;
			this.primaryAddressCountry = primaryAddressCountry;
			this.secondaryAddressStreet1 = secondaryAddressStreet1;
			this.secondaryAddressStreet2 = secondaryAddressStreet2;
			this.secondaryAddressCity = secondaryAddressCity;
			this.secondaryAddressState = secondaryAddressState;
			this.secondaryAddressPostalCode = secondaryAddressPostalCode;
			this.secondaryAddressCountry = secondaryAddressCountry;
			this.website = website;
			this.description = description;
			this.industry = industry;
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
   * This test case will create new lead
   */
  
  @Test(priority=0)
  public void createLead() {
	  menu = new Menu(driver);
	  menu.leadsButtonClick();
	  
      specificMenu = new SpecificMenu(driver);
	  specificMenu.clickCreate();
	  
	  createLeadPage = new CreateLeadPage(driver);
	  createLeadPage.selectPoliteReturn(this.politeReturn);
	  createLeadPage.textFirstName(this.firstName);
	  createLeadPage.textLastName(this.lastName);
	  createLeadPage.selectStatus(this.status);
	  createLeadPage.textJobTitle(this.jobTitle);
	  createLeadPage.textCompanyName(this.companyName);
	  createLeadPage.textDepartment(this.department);
	  createLeadPage.textOfficePhone(this.officePhone);
	  createLeadPage.selectSource(this.source);
	  createLeadPage.textMobilePhone(this.mobilePhone);
	  createLeadPage.textOfficeFax(this.officeFax);
	  createLeadPage.textPrimaryEmail(this.primaryEmail);
	  createLeadPage.textSecondaryEmail(this.secondaryEmail);
	  createLeadPage.textPrimaryAddressStreet1(this.primaryAddressStreet1);
	  createLeadPage.textPrimaryAddressStreet2(this.primaryAddressStreet2);
	  createLeadPage.textPrimaryAddressCity(this.primaryAddressCity);
	  createLeadPage.textPrimaryAddressState(this.primaryAddressState);
	  createLeadPage.textPrimaryAddressPostalCode(this.primaryAddressPostalCode);
	  createLeadPage.textPrimaryAddressCountry(this.primaryAddressCountry);
	  createLeadPage.textSecondaryAddressStreet1(this.secondaryAddressStreet1);
	  createLeadPage.textSecondaryAddressStreet2(this.secondaryAddressStreet2);
	  createLeadPage.textSecondaryAddressCity(this.secondaryAddressCity);
	  createLeadPage.textSecondaryAddressState(this.secondaryAddressState);
	  createLeadPage.textSecondaryAddressPostalCode(this.secondaryAddressPostalCode);
	  createLeadPage.textSecondaryAddressCountry(this.secondaryAddressCountry);
	  createLeadPage.textWebsite(this.website);
	  createLeadPage.textDescription(this.description);
	  createLeadPage.selectIndustry(this.industry);
	  createLeadPage.clickSaveButton();

	  

	  try {
	  WebElement saveDuplicates = (new WebDriverWait(driver, 30))
			  .until(ExpectedConditions.presenceOfElementLocated(By.linkText("click here")));
	  saveDuplicates.click();
	  } catch (TimeoutException e) {
		  e.printStackTrace();
	  }
	  
  }
  

  @Test(priority=1, dependsOnMethods={"createLead"})
  public void verifyCreatedLead() {
	  
	  leadDetailsPage = new LeadDetailsPage(driver);
	  
	  (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"))); 
	  
	  Assert.assertEquals(leadDetailsPage.readName(), this.politeReturn+" "+this.firstName+" "+this.lastName);
	  Assert.assertEquals(leadDetailsPage.readStatus(), this.status);
	  Assert.assertEquals(leadDetailsPage.readJobTitle(), this.jobTitle);
	  Assert.assertEquals(leadDetailsPage.readDepartment(), this.department);
	  Assert.assertEquals(leadDetailsPage.readOfficePhone(), this.officePhone);
	  Assert.assertEquals(leadDetailsPage.readSource(), this.source);
	  Assert.assertEquals(leadDetailsPage.readMobilePhone(), this.mobilePhone);
	  Assert.assertEquals(leadDetailsPage.readOfficeFax(), this.officeFax);
	  Assert.assertEquals(leadDetailsPage.readPrimaryEmail(), this.primaryEmail);
	  Assert.assertEquals(leadDetailsPage.readSecondaryEmail(), this.secondaryEmail);
	  Assert.assertEquals(leadDetailsPage.readPrimaryAddressStreet1(), this.primaryAddressStreet1);
	  Assert.assertEquals(leadDetailsPage.readPrimaryAddressStreet2(), this.primaryAddressStreet2);
	  Assert.assertEquals(leadDetailsPage.readPrimaryAddressCity(), this.primaryAddressCity);
	  Assert.assertEquals(leadDetailsPage.readPrimaryAddressState(), this.primaryAddressState);
	  Assert.assertEquals(leadDetailsPage.readPrimaryAddressPostalCode(), this.primaryAddressPostalCode);
	  Assert.assertEquals(leadDetailsPage.readSecondaryAddressStreet1(), this.secondaryAddressStreet1);
	  Assert.assertEquals(leadDetailsPage.readSecondaryAddressStreet2(), this.secondaryAddressStreet2);
	  Assert.assertEquals(leadDetailsPage.readSecondaryAddressCity(), this.secondaryAddressCity);
	  Assert.assertEquals(leadDetailsPage.readSecondaryAddressState(), this.secondaryAddressState);
	  Assert.assertEquals(leadDetailsPage.readSecondaryAddressPostalCode(), this.secondaryAddressPostalCode);
	  Assert.assertEquals(leadDetailsPage.readIndustry(), this.industry);
	  Assert.assertEquals(leadDetailsPage.readWebsite(), "http://"+this.website);
	  Assert.assertEquals(leadDetailsPage.readDescription(), this.description);
	  

  }
  
  @AfterClass
  public void afterSuite() {
	  driver.quit();
  }
  
  @DataProvider
  private static String[][] getData(ITestContext context) {

	  excel = new ExcelUtil("createLead.xlsx", "Arkusz2"); 
	  
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
