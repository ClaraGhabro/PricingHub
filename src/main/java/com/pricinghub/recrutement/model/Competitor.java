package com.pricinghub.recrutement.model;

import org.springframework.context.annotation.ScopeMetadata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Competitor {
    private String name;
    private Date day;
    private float price;


    public Competitor() {}

    public Competitor(String[] line) throws ParseException {
        day = new SimpleDateFormat("dd/MM/yyyy").parse(line[0]);
        price = Float.parseFloat(line[1]);
        name = line[2];
    }

    public String getName() {
        return name;
    }
    public Date getDay() {
        return day;
    }
    public float getPrice() {
        return price;
    }

    public void setName(String name) { this.name = name;}
    public void setDay(Date day) { this.day = day; }
    public void setPrice(String price) { this.price = Float.parseFloat(price);}

    @Override
    public String toString() {
        return "Competitor {day: " + day + ", price: " + price + ", competitor: " + name + "}";
    }
}
