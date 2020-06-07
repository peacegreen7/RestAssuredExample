package Tests;

import org.junit.*;
import org.junit.runners.MethodSorters;
import Helpers.SeleniumHelpers;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) //For Ascending order test execution

public class FilterRequest {

	//Instantiate a Helper Methods (help) Object
    SeleniumHelpers obj = new SeleniumHelpers();

    @Before
    public void setup () throws InterruptedException{
        //Test Setup
        obj.init("driver/chromedriver.exe", "http://ktvn-test.s3-website.us-east-1.amazonaws.com/");
        obj.LoginPage("admin@test.com", "test123");
    }
   
    @Test
    public void TC01_verifyResultAfterFilterCorrect() throws InterruptedException {
    	//Verify all result after filter have Inactive Status
    	obj.selectFilter(5);
    	Assert.assertEquals("True", true , obj.isGetCorrectRequestStatus("Inactive"));
    }
    
    @Test
    public void TC02_verifyResultAfterFilterFalse() throws InterruptedException {
    	//Verify all result after filter have Inactive Status
    	obj.selectFilter(5);
    	Assert.assertEquals("True", false , obj.isGetCorrectRequestStatus("Inactive"));
    }
    
    
    @After
    public void afterTest (){
        //Reset Values
        obj.reset();
    }
}
