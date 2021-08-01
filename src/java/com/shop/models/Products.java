/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.models;

import java.util.List;


public class Products {
    //agregando propiedad para que sea lista de varias fotos 
    //porque puede haber un producto con varias fotos 
  public String Guid;

    public String getGuid() {
        return Guid;
    }

    public void setGuid(String Guid) {
        this.Guid = Guid;
    }
  
    
    
    public int Id;
    public int CategoryId; // LLAVE FORANEA QUE APUNTA A UNA CLASE PADRE hace referencia
    public String Name;
    public double Price;
    public double ShippingCost;
    public String Warranty;
    public String Description;
    public int Quantity;
    public int StateId;
    public int CustomerId;
    
    public Categories Categories ; //esta clase padre 
    public States states;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getShippingCost() {
        return ShippingCost;
    }

    public void setShippingCost(double ShippingCost) {
        this.ShippingCost = ShippingCost;
    }

    public String getWarranty() {
        return Warranty;
    }

    public void setWarranty(String Warranty) {
        this.Warranty = Warranty;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getStateId() {
        return StateId;
    }

    public void setStateId(int StateId) {
        this.StateId = StateId;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public Categories getCategories() {
        return Categories;
    }

    public void setCategories(Categories Categories) {
        this.Categories = Categories;
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }
    
    
    
}
