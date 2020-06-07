package Helpers;

import io.restassured.response.Response;

public class ApiHelpers {
	//Get Item Ids (For API_TC02)
    public String getItemId (Response response) {
        String id = response.jsonPath().getString("id");
        return id;
    }

    //Get Title (For API_TC03)
    public String getItemTitle (Response response) {
    	String title = response.jsonPath().getString("title"); 
        return title;
    }

}
