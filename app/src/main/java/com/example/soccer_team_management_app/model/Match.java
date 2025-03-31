package com.example.soccer_team_management_app.model;

public class Match implements SoccerEntity {
    private String id, homeTeam, awayTeam, score, league, date, stadium;
    //constructor
    public Match(String homeTeam, String awayTeam, String score, String league, String date, String stadium){
        this.homeTeam=homeTeam;
        this.awayTeam=awayTeam;
        this.score=score;
        this.league=league;
        this.date=date;
        this.stadium=stadium;
    }
    @Override
    public String getId(){
        return id;
    }
    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }
    public String getScore() {
        return score;
    }

    public String getStadium() {
        return stadium;
    }
    public String getLeague() {
        return league;
    }
    public String getDate() {
        return date;
    }
}
