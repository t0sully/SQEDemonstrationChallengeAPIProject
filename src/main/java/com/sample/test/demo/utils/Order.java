package com.sample.test.demo.utils;

import java.util.List;
import org.apache.maven.surefire.shade.booter.org.apache.commons.lang3.StringUtils;

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

    public String toJsonString() {
        // Hacked for now
        String json = "{";
        if (StringUtils.isNotBlank(getId())) {
            json += "\n\"id\":\"" + getId() + "\"";
        }
        if (getItems() != null) {
            if (StringUtils.isNotBlank(getId())) {
                json += ",";
            }
            json += "\n\"items\":[";
            for (int i = 0; i < getItems().size(); i++) {
                if (i > 0) {
                    json += ",";
                }

                json += "\n" + getItems().get(i).toJsonString();
            }

            json += "\n]";
        }
        json += "\n}";
        return json;

    }

}
