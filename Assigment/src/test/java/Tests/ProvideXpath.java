package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Helpers.SeleniumHelpers;

public class ProvideXpath {
	//Instantiate a Helper Methods (help) Object
    SeleniumHelpers obj = new SeleniumHelpers();

    @Before
    public void setup () throws InterruptedException{
        //Test Setup
        obj.init("driver/chromedriver.exe", "http://ktvn-test.s3-website.us-east-1.amazonaws.com/");
        obj.LoginPage("admin@test.com", "test123");
    }
   
    @Test
    public void TC01_verifyxPath() throws InterruptedException {
    	obj.getXpath("Approved", "2019");
    }
    
    @After
    public void afterTest (){
        //Reset Values
        obj.reset();
    }
}
