/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.models;


public class ProductPhotos {
    public int Id;
    public int ProductId;
    public String Guid;

      public Products Products; //hace refencia
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public String getGuid() {
        return Guid;
    }

    public void setGuid(String Guid) {
        this.Guid = Guid;
    }

    public Products getProducts() {
        return Products;
    }

    public void setProducts(Products Products) {
        this.Products = Products;
    }
    
    
   
}
