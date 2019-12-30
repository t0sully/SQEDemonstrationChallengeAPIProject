package com.sample.test.demo.tests;

import com.sample.test.demo.utils.Resources;
import com.sample.test.demo.utils.payLoad;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class PostOrdersTest {

    @BeforeTest
    public void getHost(){
        Resources.mainHost();
    }

    @Test(dataProvider = "getToppings")
    public void createOrders(String top1, String top2){

        Response resp = given().
                header("Content-Type", "application/json").
                body(payLoad.postOrdersData(top1, top2)).
                when().
                post(Resources.OrdersEndpoint()).
                then().assertThat().statusCode(201).and().contentType(ContentType.JSON).and().
                extract().response();
        String responseString = resp.asString();
        System.out.println(responseString);
        JsonPath js = new JsonPath(responseString);
        String id = js.get("id");
        System.out.println(id);

    }

    @DataProvider
    public Object[][] getToppings(){
        return new Object[][] {{"Mushrooms", "Extra cheese"}, {"Diced Mango", "Caramelized onions"},
                {"Classic Pepperoni", "Salami"}, {"Italian Ham", "Parmesan cheese"}};
    };


}
