package endPoints;

import businessModel.BusinessModel;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.ConfigurationReader;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class MeritEndpoints {
    static String deck_id = "";
    static File file = new File("jokers.json");
    public BusinessModel postBrandNewDeck(){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Connection","keep-alive")
                .baseUri(ConfigurationReader.getProperty("baseUrl"))
                .body(file).
        when()
                .post("/api/deck/new").prettyPeek().
        then()
                .assertThat()
                .statusCode(200)
                .extract().response();
        return response.as(BusinessModel.class);
    }

    public BusinessModel shuffleTheCards(String deck_count){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Connection","keep-alive")
                .baseUri(ConfigurationReader.getProperty("baseUrl"))
                .queryParam("deck_count",deck_count).
        when()
                .post("/api/deck/new/shuffle").prettyPeek().
        then()
                .assertThat()
                .statusCode(200)
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        deck_id = jsonPath.getString("deck_id");
        return response.as(BusinessModel.class);
    }

    public BusinessModel drawACard(String count){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Connection","keep-alive")
                .baseUri(ConfigurationReader.getProperty("baseUrl"))
                .pathParam("deck_id",deck_id)
                .queryParam("count",count).
        when()
                .post("/api/deck/{{deck_id}}/draw").prettyPeek().
        then()
                .assertThat()
                .statusCode(200)
                .extract().response();
        return response.as(BusinessModel.class);
    }


    public BusinessModel reshuffleTheCards(){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Connection","keep-alive")
                .baseUri(ConfigurationReader.getProperty("baseUrl"))
                .pathParam("deck_id",deck_id).
        when()
                .post("/api/deck/{{deck_id}}/reshuffle").prettyPeek().
        then()
                .assertThat()
                .statusCode(200)
                .extract().response();
        return response.as(BusinessModel.class);
    }

    public BusinessModel brandNewDeck(){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Connection","keep-alive")
                .baseUri(ConfigurationReader.getProperty("baseUrl"))
                .queryParam("jokers_enabled",true).
        when()
                .post("/api/deck/new").prettyPeek().
        then()
                .assertThat()
                .statusCode(200)
                .extract().response();
        return response.as(BusinessModel.class);
    }
}
