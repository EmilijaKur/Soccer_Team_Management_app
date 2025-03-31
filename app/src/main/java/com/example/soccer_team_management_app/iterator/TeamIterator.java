package com.example.soccer_team_management_app.iterator;

import com.example.soccer_team_management_app.model.Team;

import java.util.List;
//iterates over a list of Team objects.

public class TeamIterator implements CustomIterator<Team>{
    // The list of teams that this iterator will traverse
    private List<Team> teams;
    private int position=0;
    // Constructor
    public TeamIterator(List<Team> teams){
        this.teams=teams;
    }

    // Checks if there are more teams to iterate over.
    @Override
    public boolean hasNext(){
        //returns true if position is less than teams size
        return position<teams.size();
    }

    @Override
    public Team next(){
        if(!hasNext()){
            throw new IndexOutOfBoundsException("No more teams available");

        }
        return teams.get(position++);
        // Returns the next team in the list and advances the position to the next index.
    }
    //reset the iterator's position to the beginning of the list
    public void reset(){
        position=0;
    }

}
