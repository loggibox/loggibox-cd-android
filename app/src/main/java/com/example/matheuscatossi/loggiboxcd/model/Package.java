package com.example.matheuscatossi.loggiboxcd.model;

public class Package {

    private String id;
    private double weight;
    private String deadline;
    private int deadline_days;
    private String delivery_address;
    private String document_deliveryman;
    private String name_deliveryman;
    private String id_user;
    private User user;
    private String route_start;
    private String route_end;
    private boolean delivered;
    private boolean delivering;
    private boolean distribution_center;


    public Package(String id, double weight, String deadline, int deadline_days, String delivery_address, String document_deliveryman, String name_deliveryman, String id_user, User user, String route_start, String route_end, boolean delivered, boolean delivering, boolean distribution_center) {
        this.id = id;
        this.weight = weight;
        this.deadline = deadline;
        this.deadline_days = deadline_days;
        this.delivery_address = delivery_address;
        this.document_deliveryman = document_deliveryman;
        this.name_deliveryman = name_deliveryman;
        this.id_user = id_user;
        this.user = user;
        this.route_start = route_start;
        this.route_end = route_end;
        this.delivered = delivered;
        this.delivering = delivering;
        this.distribution_center = distribution_center;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getDeadline_days() {
        return deadline_days;
    }

    public void setDeadline_days(int deadline_days) {
        this.deadline_days = deadline_days;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
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

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRoute_start() {
        return route_start;
    }

    public void setRoute_start(String route_start) {
        this.route_start = route_start;
    }

    public String getRoute_end() {
        return route_end;
    }

    public void setRoute_end(String route_end) {
        this.route_end = route_end;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public boolean isDelivering() {
        return delivering;
    }

    public void setDelivering(boolean delivering) {
        this.delivering = delivering;
    }

    public boolean isDistribution_center() {
        return distribution_center;
    }

    public void setDistribution_center(boolean distribution_center) {
        this.distribution_center = distribution_center;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
