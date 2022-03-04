package endPoints;

import io.restassured.http.ContentType;
import utils.ConfigurationReader;

import static io.restassured.RestAssured.given;

public class Merit {


    public void authorize(){
        given().contentType(ContentType.JSON)
                .header("Origin","")
                .baseUri(ConfigurationReader.getProperty("baseUrl"));
    }
}
