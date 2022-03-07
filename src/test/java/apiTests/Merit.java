package apiTests;

import businessModel.BusinessModel;
import endPoints.MeritEndpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import utils.ConfigurationReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(OrderAnnotation.class)
public class Merit {
    private static String deck_id = "";
    MeritEndpoints endpoints = new MeritEndpoints();
    @Order(1)
    @Test
    public void postBrandNewDeck(){

        BusinessModel response = endpoints.postBrandNewDeck();
        deck_id = response.getDeck_id();
        assertTrue(response.isSuccess());
        assertEquals(52,response.getRemaining());
        assertTrue(response.isShuffled());
    }


    @Order(2)
    @Test
    public void shuffleTheCards(){
        BusinessModel response = endpoints.shuffleTheCards("1");
        assertTrue(response.isSuccess());
        assertEquals(52,response.getRemaining());
        assertTrue(response.isShuffled());
    }

    @Order(3)
    @Test
    public void DrawACard(){
        BusinessModel response = endpoints.drawACard("1");
        assertTrue(response.isSuccess());
        assertEquals(52,response.getRemaining());
        assertTrue(response.isShuffled());
    }
    @Order(4)
    @Test
    public void reShuffleTheCards(){
        BusinessModel response = endpoints.reshuffleTheCards();
        assertTrue(response.isSuccess());
        assertEquals(52,response.getRemaining());
        assertTrue(response.isShuffled());
    }


    @Order(5)
    @Test
    public void brandNewDeck(){
        BusinessModel response = endpoints.brandNewDeck();
        assertTrue(response.isSuccess());
        assertEquals(54,response.getRemaining());
        assertFalse(response.isShuffled());
    }



}
