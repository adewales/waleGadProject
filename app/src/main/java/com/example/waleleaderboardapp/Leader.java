package com.example.waleleaderboardapp;

public class Leader {

    public String name;
    public Double hours;
    public String country;
    public String badgeUrl;

    public Leader(String name, Double hours, String country, String badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }
}
