package com.praktikum.models;

public class Item {
    private String name;
    private String description;
    private String location;
    private ItemStatus status;

    public Item(String name, String description, String location, ItemStatus status) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }
}


