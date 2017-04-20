package model;

import java.util.Date;

public class Item {
    private Page page;

    private String name;

    private String price;

    private Date date;

    public Item(Page page,String name, String price) {
        this.page=page;
        this.name = name;
        this.price = price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
