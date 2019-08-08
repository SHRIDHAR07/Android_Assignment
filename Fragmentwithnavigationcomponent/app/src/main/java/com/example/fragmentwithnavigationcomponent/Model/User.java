package com.example.fragmentwithnavigationcomponent.Model;
/**
 * Simple model class that will hold all the information with respect to user
 */
public class User {

    private String firstName;
    private String gender;
    private String country;
    private String state;
    private String phoneNumber;
    private String adharCard;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String  getGender() {
        return gender;
    }

    public void setGender(String  gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAdharCard() {
        return phoneNumber;

    }

    public void setAdharCard(String adharCard) {
        this.adharCard = adharCard;
    }
}