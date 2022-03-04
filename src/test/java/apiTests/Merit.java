package apiTests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;



@TestMethodOrder(OrderAnnotation.class)
public class Merit {

    @Order(1)
    @Test
    public void test1(){

    }

    @Order(1)
    @Test
    public void test2(){

    }
    @Order(1)
    @Test
    public void test3(){

    }



}
