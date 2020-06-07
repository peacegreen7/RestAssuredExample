package Tests;

import org.junit.*;
import org.junit.runners.MethodSorters;
import Helpers.SeleniumHelpers;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) //For Ascending order test execution

public class SortTest {

	//Instantiate a Helper Methods (help) Object
    SeleniumHelpers obj = new SeleniumHelpers();

    @Before
    public void setup () throws InterruptedException{
        //Test Setup
        obj.init("driver/chromedriver.exe", "http://ktvn-test.s3-website.us-east-1.amazonaws.com/");
        obj.LoginPage("admin@test.com", "test123");
    }
   
    @Test
    public void TC01_verifyASCSortTrue() throws InterruptedException {
    	//Verify data sort ASC is true
    	obj.doSort(2);
    	Assert.assertEquals("List is order by ASC", obj.getDataASC(), obj.getCurrentData());
    }
    
    @Test
    public void TC02_verifyASCSortFalse() throws InterruptedException {
    	//Verify data sort ASC is false
    	Assert.assertEquals("List is not order by ASC", obj.getDataASC(), obj.getCurrentData());
    }
    
    @Test
    public void TC03_verifyDESCSortTrue() throws InterruptedException {
    	//Verify data sort DESC is true
    	obj.doSort(1);
    	Assert.assertEquals("List is order by DESC", obj.getDataDESC(), obj.getCurrentData());
    }
    
    @Test
    public void TC04_verifyDESCSortFalse() throws InterruptedException {
    	//Verify data sort ASC is false
    	Assert.assertEquals("List is not order by DESC", obj.getDataDESC(), obj.getCurrentData());
    }
   
    
    @After
    public void afterTest (){
        //Reset Values
        obj.reset();
    }
}
