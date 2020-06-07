package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Utils {
   
    //Sets Base URI
    public static void setBaseURI (){
        RestAssured.baseURI = "https://my-json-server.typicode.com/typicode/demo/posts/1";
    }

    //Reset Base URI (after test)
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }

    //Returns response
    public static Response getResponse() {
    	RequestSpecification httpRequest = RestAssured.given();
    	Response response = httpRequest.get("/");
        return response;
    }
}
