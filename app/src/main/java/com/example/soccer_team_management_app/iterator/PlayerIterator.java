package com.example.soccer_team_management_app.iterator;

import com.example.soccer_team_management_app.model.Player;

import java.util.List;
//iterates over a list of Player objects.
public class PlayerIterator implements CustomIterator<Player>{
    private List<Player> players;
    private int position=0;
    @Override
    public boolean hasNext(){
        return position< players.size();
    }
    @Override
    public Player next(){
        if(!hasNext()){
            throw new IndexOutOfBoundsException("No more players available");

        }
        return players.get(position++);
    }
    //reset the iterator's position to the beginning of the list
    public void reset(){
        position=0;
    }


}
