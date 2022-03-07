package apiTests;

import businessModel.BusinessModel;
import endPoints.MeritEndpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utils.ConfigurationReader;

import java.io.File;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllInOne {
    static File file = new File("jokers.json");
    private static String deck_id = "";
    MeritEndpoints endpoints = new MeritEndpoints();
    @BeforeAll
    @Test
    public static void setUp(){
        RestAssured.baseURI = "https://deckofcardsapi.com";
        basePath = "/api";
    }
    @Order(1)
    @Test
    public void postBrandNewDeck(){
        given()
                .contentType(ContentType.JSON)
                .header("Connection","keep-alive")
                .body(file).
        when()
                .post("/deck/new").prettyPeek().
        then()
                .assertThat()
                .statusCode(200)
                .body("success",is(true),
                      "remaining",is(52),
                      "shuffled",is(false));
    }



    @Order(2)
    @Test
    public void shuffleTheCards(){

    }
}
