package com.sample.test.demo.utils;

import io.restassured.RestAssured;

public class Resources {

    public static String mainHost(){
        return RestAssured.baseURI = "https://my-json-server.typicode.com";
    }

    public static String OrdersEndpoint(){
        return "/sa2225/demo/orders";
    }

    public static String getOrdersId(String id){
        return "/sa2225/demo/orders/"+id+"";

    }


}
