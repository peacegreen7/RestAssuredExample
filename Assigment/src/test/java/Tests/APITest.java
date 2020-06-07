package Tests;

import Utils.Utils;
import io.restassured.response.Response;
import org.junit.*;
import org.junit.runners.MethodSorters;

import Helpers.ApiHelpers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //For Ascending order test execution
public class APITest {

    private Response response = null;
    ApiHelpers obj = new ApiHelpers();

    @Before
    public void setup (){
        //Test Setup
        Utils.setBaseURI(); //Setup Base URI
        response = Utils.getResponse(); //Get response
    }

    @Test
    public void TC01_verifyStatusCode() {
        //Verify the status code is 200
        Assert.assertEquals("Status Check Success!", 200, response.getStatusCode());
    }
   
    @Test
    public void TC02_verifyItemId() {
        //Verify the id is correct
        Assert.assertEquals("Id is true", "1", obj.getItemId(response));
    }

    @Test
    public void TC03_verifyItemTitle() {
        //Verify title is correct
        Assert.assertEquals("Title is true", "Post 1", obj.getItemTitle(response));
        
    }

    @After
    public void afterTest (){
        //Reset Values
        Utils.resetBaseURI();
    }
    
}

