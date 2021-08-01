/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.models;

public class Customer {
    
    public int Id;
    public int DocumentTypeId;
    public String DocumentNumber;
    public String FirstName;
    public String SecondName;
    public String Surname;
    public String SecondSurname;
    public String Telephone;
    public String Address;
    public int CityId;
    public int UserId;
    //aki hacemos referencia a estos 
    public DocumentTypes DocumentTypes;
    public Cities Cities;
    public Users Users;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getDocumentTypeId() {
        return DocumentTypeId;
    }

    public void setDocumentTypeId(int DocumentTypeId) {
        this.DocumentTypeId = DocumentTypeId;
    }

    public String getDocumentNumber() {
        return DocumentNumber;
    }

    public void setDocumentNumber(String DocumentNumber) {
        this.DocumentNumber = DocumentNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getSecondSurname() {
        return SecondSurname;
    }

    public void setSecondSurname(String SecondSurname) {
        this.SecondSurname = SecondSurname;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int CityId) {
        this.CityId = CityId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public DocumentTypes getDocumentTypes() {
        return DocumentTypes;
    }

    public void setDocumentTypes(DocumentTypes DocumentTypes) {
        this.DocumentTypes = DocumentTypes;
    }

    public Cities getCities() {
        return Cities;
    }

    public void setCities(Cities Cities) {
        this.Cities = Cities;
    }

    public Users getUsers() {
        return Users;
    }

    public void setUsers(Users Users) {
        this.Users = Users;
    }
    
    
}
