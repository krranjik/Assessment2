package com.example.assessment2.Module;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String dob;
    private String gender;
    private String country;
    private String phone;
    private String email;
    private int imgg;

    public User(String name, String dob, String gender, String country, String phone, String email, int imgg) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.imgg = imgg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImgg() {
        return imgg;
    }

    public void setImgg(int imgg) {
        this.imgg = imgg;
    }
}
