package com.sample.test.demo.utils;

import java.util.List;
import org.apache.maven.surefire.shade.booter.org.apache.commons.lang3.StringUtils;

public class Pizza {

    private String item = "";
    private String pizza = "";
    private List<String> toppings;

    public Pizza setItem(String item) {
        this.item = item;
        return this;
    }

    public String getItem() {
        return item;
    }

    public Pizza setPizza(String pizza) {
        this.pizza = pizza;
        return this;
    }

    public String getPizza() {
        return pizza;
    }

    public Pizza setToppings(List<String> toppings) {
        this.toppings = toppings;
        return this;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public String toJsonString() {
        // Hacked for now
        String json = "{";
        if (StringUtils.isNotBlank(getItem())) {
            json += "\n\"item\":\"" + getItem() + "\"";
        }
        if (StringUtils.isNotBlank(getPizza())) {
            if (StringUtils.isNotBlank(getItem())) {
                json += ",";
            }
            json += "\n\"pizza\":\"" + getPizza() + "\"";
        }
        if (getToppings() != null) {
            if (StringUtils.isNotBlank(getItem()) || StringUtils.isNotBlank(getPizza())) {
                json += ",";
            }
            json += "\n\"toppings\":[";
            for (int i = 0; i < getToppings().size(); i++) {
                if(i>0) {
                    json += ",";
                }
            
                json += "\n\"" + getToppings().get(i) + "\"";
            }

            json += "\n]";
        }
        json += "\n}";
        return json;

    }

}
