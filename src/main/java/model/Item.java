package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Item {
    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("price")
    @Expose
    private Float price;

    @SerializedName("currency")
    @Expose
    private String currency;

    @SerializedName("date")
    @Expose
    private Date date;

    public Item(String type, String name, Float price, String currency) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.date = new Date();
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
