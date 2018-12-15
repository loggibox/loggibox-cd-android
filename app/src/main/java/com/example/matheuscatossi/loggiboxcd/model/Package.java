package com.example.matheuscatossi.loggiboxcd.model;

public class Package {

    private String weight;
    private String date;
    private String address_delivery;
    private String address_deliveryman;
    private DeliveryMan deliveryman;
    private String document_deliveryman;
    private String name_deliveryman;
    private String code;

    public Package() {

    }

    public Package(String weight, String date, String address_delivery, String address_deliveryman, String code, String document_deliveryman, String name_deliveryman){
        this.weight = weight;
        this.date = date;
        this.address_delivery = address_delivery;
        this.address_deliveryman = address_deliveryman;
        this.code = code;
        this.name_deliveryman = name_deliveryman;
        this.document_deliveryman = document_deliveryman;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress_delivery() {
        return address_delivery;
    }

    public void setAddress_delivery(String address_delivery) {
        this.address_delivery = address_delivery;
    }

    public String getAddress_deliveryman() {
        return address_deliveryman;
    }

    public void setAddress_deliveryman(String address_deliveryman) {
        this.address_deliveryman = address_deliveryman;
    }

    public DeliveryMan getDeliveryman() {
        return deliveryman;
    }

    public void setDeliveryman(DeliveryMan deliveryman) {
        this.deliveryman = deliveryman;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDocument_deliveryman() {
        return document_deliveryman;
    }

    public void setDocument_deliveryman(String document_deliveryman) {
        this.document_deliveryman = document_deliveryman;
    }

    public String getName_deliveryman() {
        return name_deliveryman;
    }

    public void setName_deliveryman(String name_deliveryman) {
        this.name_deliveryman = name_deliveryman;
    }
}
