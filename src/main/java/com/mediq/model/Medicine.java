package com.mediq.model;

public class Medicine {
    private String name;
    private String expiry;
    private int quantity;

    public Medicine(String name, String expiry, int quantity) {
        this.name = name;
        this.expiry = expiry;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public String getExpiry() { return expiry; }
    public int getQuantity() { return quantity; }
}