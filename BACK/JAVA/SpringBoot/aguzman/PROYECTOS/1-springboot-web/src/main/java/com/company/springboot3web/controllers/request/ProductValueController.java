package com.company.springboot3web.controllers.request;

public class ProductValueController {
    private String name;
    private String description;
    private Float price;

    public ProductValueController() {
    }
    public ProductValueController(String name, String description, Float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductValueController [name=" + name + ", description=" + description + ", price=" + price + "]";
    }
}
