package com.example.soccer_team_management_app.model;

public class Team implements SoccerEntity{
    private String id;
    private String name;
    private String country;
    private String league;
    private String stadium;
    private int yearFounded;
    //constructor
    public Team(String id, String name, String country, String league, String stadium, int yearFounded){
        this.id=id;
        this.name=name;
        this.country=country;
        this.league=league;
        this.stadium=stadium;
        this.yearFounded=yearFounded;
    }
    @Override
    public String getId(){
        return id;
    }
    //@Override
    public String getName(){
        return name;
    }
    public String getCountry() {
        return country;
    }

    public String getLeague() {
        return league;
    }

    public String getStadium() {
        return stadium;
    }
    public int getYearFounded() {
        return yearFounded;
    }
}
