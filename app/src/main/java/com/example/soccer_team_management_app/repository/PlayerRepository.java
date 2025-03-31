package com.example.soccer_team_management_app.repository;
import com.example.soccer_team_management_app.model.Player;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
//Extends the generic Repository class for filtering Player objects.
public class PlayerRepository extends Repository<Player> {
    public List<Player> filterByTeam(String team) {
        return filter(player -> player.getTeam().equals(team));

    }
}
