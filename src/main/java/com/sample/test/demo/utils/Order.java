package com.sample.test.demo.utils;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class Order {

    private String id = "";
    private List<Pizza> items;

    public Order setId(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return id;
    }

    public Order setItems(List<Pizza> items) {
        this.items = items;
        return this;
    }

    public List<Pizza> getItems() {
        return items;
    }

}
