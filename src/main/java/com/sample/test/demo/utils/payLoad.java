package com.sample.test.demo.utils;

public class payLoad {

    public static String postOrdersData(String top1, String top2 ){

        return "{\n" +
                "   \"items\": [\n" +
                "      {\n" +
                "         \"pizza\": \"Medium 8 Slices - 2 toppings\",\n" +
                "         \"toppings\": [\n" +
                "            \""+top1+"\",\n" +
                "            \""+top2+"\"\n" +
                "         ]\n" +
                "      }\n" +
                "   ]\n" +
                "}\n";
    }
}
