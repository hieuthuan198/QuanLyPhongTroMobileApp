package com.entities;

public class Motel1 {
    private String address;
    private String email;

    public Motel1() {
    }

    public Motel1(String address, String email) {
        this.address = address;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
