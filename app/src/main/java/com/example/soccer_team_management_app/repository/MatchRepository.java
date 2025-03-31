package com.example.soccer_team_management_app.repository;

import com.example.soccer_team_management_app.model.Match;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
//Extends the generic Repository class for filtering matches.
public class MatchRepository extends Repository<Match>{

    public List<Match> filterByTeam(String team) {
        return filter(match -> match.getHomeTeam().equals(team)||match.getAwayTeam().equals(team));

    }
}
