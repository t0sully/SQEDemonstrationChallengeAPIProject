package com.sample.test.demo.tests;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sample.test.demo.utils.Resources;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetOrdersTest {

    @BeforeTest
    public void getHost(){
        Resources.mainHost();
    }

    @Test
    public void getListOfOrders(){

        given().when().get(Resources.OrdersEndpoint()).then().assertThat().statusCode(200).contentType(ContentType.JSON).
              body("id[2]", equalTo("3"));

    }

    @Test(dataProvider = "getId")
    public void getOrdersById(String a){

        given().when().get(Resources.getOrdersId(a)).then().assertThat().statusCode(200).contentType(ContentType.JSON).
                assertThat().body("items", notNullValue());

    }

    @DataProvider
    public Object[] getId(){
        return new Object[][] { {"1"}, {"2"}, {"3"}};
    }













}
