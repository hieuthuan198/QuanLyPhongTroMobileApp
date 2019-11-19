package com.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Account implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("phonenumber")
    private String phoneNumber;
    @SerializedName("email")
    private String email;
    @SerializedName("status")
    private boolean status;
      private Set<Motel> motels = new HashSet<Motel>(0);


    public Account() {
    }

    public Account(Integer id, String username, String password, String phoneNumber, String email, boolean status, Set<Motel> motels) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
        this.motels = motels;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Motel> getMotels() {
        return motels;
    }

    public void setMotels(Set<Motel> motels) {
        this.motels = motels;
    }
}
