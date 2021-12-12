package projekt.automatyzacja.page;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryExample {
    String userMode;

    @Factory(dataProvider = "userModeProvider")
    public FactoryExample(String userMode) {
        this.userMode = userMode;
    }

    @BeforeClass()
    public void setUp() {
        System.out.println("Before Running the class userMode is " + userMode);
    }

    @Test(description = "test method1")
    public void testMethod1() {
        System.out.println("Inside method 1 " + userMode );
    }

    @Test(description = "test method2")
    public void testMethod2() {
        System.out.println("Inside method 2 " + userMode);
    }

    @DataProvider
    private static String [][] userModeProvider() {
        return new String [][]{
                new String []{"Admin"},
                new String []{"Tenant"},
                new String []{"AdminUser"},
                new String []{"TenantUser"},
        };
    }

}