package projekt.automatyzacja.test;

import org.testng.annotations.Test;

import projekt.automatyzacja.page.CatalogItemDetailsPage;
import projekt.automatyzacja.page.CreateCatalogItemPage;
import projekt.automatyzacja.page.Menu;
import projekt.automatyzacja.page.ProductsPage;
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

public class CreateCatalogItemTC {
	
	
	private WebDriver driver;
	private static ExcelUtil excel;
	private Menu menu;
	private ProductsPage productsPage;
	private CreateCatalogItemPage createCatalogItemPage;
	private CatalogItemDetailsPage catalogItemDetailsPage;
	
	
    private String name;
    private String description;
    private String categories;
    private String status;
    private String type;
    private String priceFrequency;
    private String sellPriceFormula;
    private String costCurrency;
    private String costValue;
    private String listPriceCurrency;
    private String listPriceValue;
    private String sellPriceCurrency;
    private String sellPriceValue;

  
    @Factory(dataProvider = "getData")
    public CreateCatalogItemTC(    String name,
								    String description,
								    String categories,
								    String status,
								    String type,
								    String priceFrequency,
								    String sellPriceFormula,
								    String costCurrency,
								    String costValue,
								    String listPriceCurrency,
								    String listPriceValue,
								    String sellPriceCurrency,
								    String sellPriceValue)
    {
        this.name = name;
	    this.description = description; 
	    this.categories = categories;
	    this.status = status;
	    this.type = type;
	    this.priceFrequency = priceFrequency;
	    this.sellPriceFormula = sellPriceFormula;
	    this.costCurrency = costCurrency;
	    this.costValue = costValue;
	    this.listPriceCurrency = listPriceCurrency;
	    this.listPriceValue = listPriceValue;
	    this.sellPriceCurrency = sellPriceCurrency;
	    this.sellPriceValue = sellPriceValue;
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
   * This test case will create a new catalog item
   */
  
  @Test(priority=0)
  public void createCatalogItem() {
	  menu = new Menu(driver);
	  menu.dotsButtonClick();
	  menu.productsButtonClick();
	  
      productsPage = new ProductsPage(driver);
	  productsPage.clickCreateCatalogItem();;
	  
	  createCatalogItemPage = new CreateCatalogItemPage(driver);
	  createCatalogItemPage.textName(this.name);
	  createCatalogItemPage.textDescription(this.description);
	  createCatalogItemPage.textCategories(this.categories);
	  createCatalogItemPage.selectSource(this.status);
	  createCatalogItemPage.selectType(this.type);
	  createCatalogItemPage.selectPriceFrequency(this.priceFrequency);
	  createCatalogItemPage.selectSellPriceFormula(this.sellPriceFormula);
	  createCatalogItemPage.selectCostCurrency(this.costCurrency);
	  createCatalogItemPage.textCostValue(this.costValue);
	  createCatalogItemPage.selecListPriceCurrency(this.listPriceCurrency);
	  createCatalogItemPage.textListPriceValue(this.listPriceValue);
	  createCatalogItemPage.selectSellPriceCurrency(this.sellPriceCurrency);
	  createCatalogItemPage.textSellPriceValue(this.sellPriceValue);
	  createCatalogItemPage.clickSave();

	  try {
	  WebElement saveDuplicates = (new WebDriverWait(driver, 30))
			  .until(ExpectedConditions.presenceOfElementLocated(By.linkText("click here")));
	  saveDuplicates.click();
	  } catch (TimeoutException e) {
		  e.printStackTrace();
	  }
	  
  }
  
  @Test(priority=1, dependsOnMethods={"createCatalogItem"})
  public void verifyCreatedCatalogItem() {
	  
	  catalogItemDetailsPage = new CatalogItemDetailsPage(driver);
	  
	  (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.className("ellipsis-content"))); 
	  
	  Assert.assertEquals(catalogItemDetailsPage.readName(), this.name);
	  Assert.assertEquals(catalogItemDetailsPage.readDescription(), this.description);
	  Assert.assertEquals(catalogItemDetailsPage.readCategories(), this.categories);
	  Assert.assertEquals(catalogItemDetailsPage.readStatus(), this.status);
	  Assert.assertEquals(catalogItemDetailsPage.readType(), "Product");
	  Assert.assertEquals(catalogItemDetailsPage.readPriceFrequency(), this.priceFrequency);
	  Assert.assertEquals(catalogItemDetailsPage.readSellPriceFormula(), "NA");
	  Assert.assertEquals(catalogItemDetailsPage.readCost(), "$"+this.costValue+".00");
	  Assert.assertEquals(catalogItemDetailsPage.readListPrice(), "$"+this.listPriceValue+".00");
	  Assert.assertEquals(catalogItemDetailsPage.readSellPrice(), "$"+this.sellPriceValue+".00");
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  
  @DataProvider
  private static String[][] getData(ITestContext context) {

	  excel = new ExcelUtil("createCatalogItem.xlsx", "Arkusz2"); 
	  
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
