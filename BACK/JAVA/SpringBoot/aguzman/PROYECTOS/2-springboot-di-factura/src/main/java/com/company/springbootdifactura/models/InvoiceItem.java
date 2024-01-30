package com.company.springbootdifactura.models;

public class InvoiceItem {
    private Long id;
    private Integer quantity;
    private Float price;
    private Float sum;
    private Product product;


    public InvoiceItem(Long id, Integer quantity, Float price, Float sum, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.sum = sum;
        this.product = product;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Float getSum() {
        return sum;
    }
    public void setSum(Float sum) {
        this.sum = sum;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }


    @Override
    public String toString() {
        return "InvoiceItem [id=" + id + ", quantity=" + quantity + ", price=" + price + ", sum=" + sum + ", product="
                + product + "]";
    }
}
