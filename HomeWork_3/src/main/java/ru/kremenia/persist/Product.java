package ru.kremenia.persist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Long id;

    private String productName;

    private String price;

    public Product(String productName) {
        this.productName = productName;
    }

//    public Long getId() {
//        return id;
//    }

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
}