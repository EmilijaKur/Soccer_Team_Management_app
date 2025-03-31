package com.example.soccer_team_management_app.model;

public class Player implements SoccerEntity{
    private String id;
    private String name;
    private String country, position, team;
    private int age, jerseyNumber;

    //constructor
    public Player(String name, int age, String country, String position, String team,  int jerseyNumber){
        this.id=id;
        this.name=name;
        this.country=country;
        this.position=position;
        this.team=team;
        this.age=age;
        this.jerseyNumber=jerseyNumber;
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

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }
    public int getAge() {
        return age;
    }
    public int getJerseyNumber() {
        return jerseyNumber;
    }
}
