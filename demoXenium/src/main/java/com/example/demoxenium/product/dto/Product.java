package com.example.demoxenium.product.dto;

public class Product {
    private String id;
    private String productName;
    private String thumb;
    private String status;
    private int amount;
    private int price;
    private String content;
    private String summary;
    private String indate;
    private String marketType;

    private String catename;

    public Product() {
    }

    public Product(String id, String productName, String thumb, String status, int amount, int price, String content, String summary, String indate, String marketType, String catename) {
        this.id = id;
        this.productName = productName;
        this.thumb = thumb;
        this.status = status;
        this.amount = amount;
        this.price = price;
        this.content = content;
        this.summary = summary;
        this.indate = indate;
        this.marketType = marketType;
        this.catename = catename;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getThumb() {
        return thumb;
    }

    public String getStatus() {
        return status;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }

    public String getSummary() {
        return summary;
    }

    public String getIndate() {
        return indate;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public String getCatename() {
        return catename;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", thumb='" + thumb + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", content='" + content + '\'' +
                ", summary='" + summary + '\'' +
                ", indate='" + indate + '\'' +
                ", marketType='" + marketType + '\'' +
                ", catename='" + catename + '\'' +
                '}';
    }
}
