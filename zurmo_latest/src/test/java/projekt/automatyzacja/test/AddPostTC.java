package projekt.automatyzacja.test;

import org.testng.annotations.Test;

import projekt.automatyzacja.page.DashboardPage;
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

public class AddPostTC {
 
	private WebDriver driver;
	private static ExcelUtil excel;
	private Menu menu;
	private DashboardPage dashboardPage;
	
	private String postText;

	@Factory(dataProvider = "getData")
    public AddPostTC(String postText) {
		this.postText = postText;
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
   * This test case will add a post on dashboard
   */
  
  @Test(priority=0)
  public void addPost() {
	  menu = new Menu(driver);
	  menu.homeButtonClick(); 	  
	  
	  dashboardPage = new DashboardPage(driver);
	  dashboardPage.textPostTextBox(this.postText);
	  dashboardPage.clickPostButton();
  }

  @Test(priority=1, dependsOnMethods={"addPost"})
  public void verifyAddedPost() {
	  dashboardPage = new DashboardPage(driver);
	 
	  String commentContent = driver.findElement(By.className("comment-content")).getText();
	  String[] commentContentLines = commentContent.split("\\n");
	  String commentContentLine2 = commentContentLines[1];
	  
	  Assert.assertEquals(commentContentLine2, this.postText);
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  @DataProvider
  private static String[][] getData(ITestContext context) {

	  excel = new ExcelUtil("addPost.xlsx", "Arkusz2"); 
	  
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
