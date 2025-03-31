package com.example.soccer_team_management_app.repository;
import com.example.soccer_team_management_app.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
//extends the generic Repository class for filtering Team objects.
public class TeamRepository extends Repository<Team>{
    public List<Team> filterByLeague(String league){

        // Passes a lambda expression that checks if a team's league matches the given league string.
        return filter(team -> team.getLeague().equals(league));

    }
}
