package apiTests;

import businessModel.BusinessModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utils.ConfigurationReader;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Spartan {
    public static int id = 3;
    @BeforeAll
    @Test
    public static void setUp(){
        RestAssured.baseURI = "http://54.147.216.159:8000";
        basePath = "/api";
    }
    @Order(1)
    @Test
    public void displayOneSpartan(){
        given()
                .contentType(ContentType.JSON)
                .pathParam("id",id).

        when()
                .get("/spartans/{id}").prettyPeek().
        then()
                .assertThat()
                .statusCode(200)
                .body("id",is(3),
                      "name",is("Tulpar"),
                      "gender",is("Male"),
                      "phone",is(1112223330)  );
    }



    @Order(2)
    @Test
    public void shuffleTheCards(){


    }
}
