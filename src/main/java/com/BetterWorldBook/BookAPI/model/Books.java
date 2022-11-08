package com.BetterWorldBook.BookAPI.model;


import javax.persistence.*;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKS_ID")
    private Long id;

   @Column(name= "NAME")
    private String name;

   @Column(name= "SKU")
    private String sku;

    @Column(name= "DESCRIPTION")
    private String description;

    @Column(name= "IMAGE")
    private String image;

   @Column(name= "PRICE")
    private Double price;

    @Column(name="IN_STOCK")
    private int inStock;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
