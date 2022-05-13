package com.example.companyDrrbni.Models;

public class Company {
    private String name,Email,category,governorate,address,whatsApp,linkFacebook,UserId;
    private boolean isActive,isVerify;

    public Company(String name, String email, String category, String governorate, String address, String whatsApp, String linkFacebook, String userId,boolean isVerify,boolean isActive) {
        this.name = name;
        Email = email;
        this.category = category;
        this.governorate = governorate;
        this.address = address;
        this.whatsApp = whatsApp;
        this.linkFacebook = linkFacebook;
        this.UserId = userId;
        this.isVerify = isVerify;
        this.isActive = isActive;
    }

    public Company() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public String getLinkFacebook() {
        return linkFacebook;
    }

    public void setLinkFacebook(String linkFacebook) {
        this.linkFacebook = linkFacebook;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
