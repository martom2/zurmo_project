package projekt.automatyzacja.test;

import org.testng.annotations.Test;

import projekt.automatyzacja.page.ContactDetailsPage;
import projekt.automatyzacja.page.ContactsPage;
import projekt.automatyzacja.page.CreateContactPage;
import projekt.automatyzacja.page.Menu;
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

public class EditContactTC {
  
	private WebDriver driver;
	private static ExcelUtil excel;
	private Menu menu;
	private ContactsPage contactsPage;
	private CreateContactPage createContactPage;
	private ContactDetailsPage contactDetailsPage;
	
	private String politeReturn;
	private String firstName;
	private String lastName;
	private String status;
	private String jobTitle;
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
	private String description;
	
	
	@Factory(dataProvider = "getData")
	public EditContactTC(	String politeReturn,
							String firstName,
							String lastName,
							String status,
							String jobTitle,
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
							String description) 
	{
		this.politeReturn = politeReturn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.jobTitle = jobTitle;
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
   * This test case will edit an existing contact
   */
  
  @Test
  public void editContact() {
	  menu = new Menu(driver);
	  menu.contactsButtonClick();
	  
	  contactsPage = new ContactsPage(driver);
	  
	  String searchText = this.firstName + " " + this.lastName;
	  contactsPage.textSearchBar(searchText);
	  contactsPage.clickSearchBar();

	  (new WebDriverWait(driver, 60)).until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("tr.odd:nth-child(1) > td:nth-child(3) > a:nth-child(1)"), searchText));
	  
	  contactsPage.clickTableFirstNamePosition();
	  
	  contactDetailsPage = new ContactDetailsPage(driver);
	  contactDetailsPage.clickOptionsButton();
	  (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.linkText("Edit")));
	  contactDetailsPage.clickOptionsEditSubButton();
	
	  createContactPage = new CreateContactPage(driver);
	  createContactPage.selectStatus(this.status);
	  createContactPage.clearJobTitle();
	  createContactPage.textJobTitle(this.jobTitle);
	  createContactPage.clearDepartment();
	  createContactPage.textDepartment(this.department);
	  createContactPage.clearOfficePhone();
	  createContactPage.textOfficePhone(this.officePhone);
	  createContactPage.selectSource(this.source);
	  createContactPage.clearMobilePhone();
	  createContactPage.textMobilePhone(this.mobilePhone);
	  createContactPage.clearOfficeFax();
	  createContactPage.textOfficeFax(this.officeFax);
	  createContactPage.clearPrimaryEmail();
	  createContactPage.textPrimaryEmail(this.primaryEmail);
	  createContactPage.clearSecondaryEmail();
	  createContactPage.textSecondaryEmail(this.secondaryEmail);
	  createContactPage.clearPrimaryAddressStreet1();
	  createContactPage.textPrimaryAddressStreet1(this.primaryAddressStreet1);
	  createContactPage.clearPrimaryAddressStreet2();
	  createContactPage.textPrimaryAddressStreet2(this.primaryAddressStreet2);
	  createContactPage.clearPrimaryAddressCity();
	  createContactPage.textPrimaryAddressCity(this.primaryAddressCity);
	  createContactPage.clearPrimaryAddressState();
	  createContactPage.textPrimaryAddressState(this.primaryAddressState);
	  createContactPage.clearPrimaryAddressPostalCode();
	  createContactPage.textPrimaryAddressPostalCode(this.primaryAddressPostalCode);
	  createContactPage.clearPrimaryAddressCountry();
	  createContactPage.textPrimaryAddressCountry(this.primaryAddressCountry);
	  createContactPage.clearSecondaryAddressStreet1();
	  createContactPage.textSecondaryAddressStreet1(this.secondaryAddressStreet1);
	  createContactPage.clearSecondaryAddressStreet2();
	  createContactPage.textSecondaryAddressStreet2(this.secondaryAddressStreet2);
	  createContactPage.clearSecondaryAddressCity();
	  createContactPage.textSecondaryAddressCity(this.secondaryAddressCity);
	  createContactPage.clearSecondaryAddressState();
	  createContactPage.textSecondaryAddressState(this.secondaryAddressState);
	  createContactPage.clearSecondaryAddressPostalCode();
	  createContactPage.textSecondaryAddressPostalCode(this.secondaryAddressPostalCode);
	  createContactPage.clearSecondaryAddressCountry();
	  createContactPage.textSecondaryAddressCountry(this.secondaryAddressCountry);
	  createContactPage.clearDescription();
	  createContactPage.textDescription(this.description);
	  createContactPage.clickSaveButton();
	  
  }

  @Test(priority=1, dependsOnMethods={"editContact"})
  public void verifyEditedContact() {
	  contactDetailsPage = new ContactDetailsPage(driver);
	  
	  (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#zurmoView > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"))); 
	  
	  Assert.assertEquals(contactDetailsPage.readStatus(), this.status);
	  Assert.assertEquals(contactDetailsPage.readJobTitle(), this.jobTitle);
	  Assert.assertEquals(contactDetailsPage.readDepartment(), this.department);
	  Assert.assertEquals(contactDetailsPage.readOfficePhone(), this.officePhone);
	  Assert.assertEquals(contactDetailsPage.readSource(), this.source);
	  Assert.assertEquals(contactDetailsPage.readMobilePhone(), this.mobilePhone);
	  Assert.assertEquals(contactDetailsPage.readOfficeFax(), this.officeFax);
	  Assert.assertEquals(contactDetailsPage.readPrimaryEmail(), this.primaryEmail);
	  Assert.assertEquals(contactDetailsPage.readSecondaryEmail(), this.secondaryEmail);
	  Assert.assertEquals(contactDetailsPage.readPrimaryAddressStreet1(), this.primaryAddressStreet1);
	  Assert.assertEquals(contactDetailsPage.readPrimaryAddressStreet2(), this.primaryAddressStreet2);
	  Assert.assertEquals(contactDetailsPage.readPrimaryAddressCity(), this.primaryAddressCity);
	  Assert.assertEquals(contactDetailsPage.readPrimaryAddressState(), this.primaryAddressState);
	  Assert.assertEquals(contactDetailsPage.readPrimaryAddressPostalCode(), this.primaryAddressPostalCode);
	  Assert.assertEquals(contactDetailsPage.readSecondaryAddressStreet1(), this.secondaryAddressStreet1);
	  Assert.assertEquals(contactDetailsPage.readSecondaryAddressStreet2(), this.secondaryAddressStreet2);
	  Assert.assertEquals(contactDetailsPage.readSecondaryAddressCity(), this.secondaryAddressCity);
	  Assert.assertEquals(contactDetailsPage.readSecondaryAddressState(), this.secondaryAddressState);
	  Assert.assertEquals(contactDetailsPage.readSecondaryAddressPostalCode(), this.secondaryAddressPostalCode);
	  Assert.assertEquals(contactDetailsPage.readDescription(), this.description);
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  @DataProvider
  private static String[][] getData(ITestContext context) {

	  excel = new ExcelUtil("editContact.xlsx", "Arkusz2"); 
	  
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
