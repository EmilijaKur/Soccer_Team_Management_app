package com.example.soccer_team_management_app.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccer_team_management_app.R;
import com.example.soccer_team_management_app.iterator.TeamIterator;

import java.util.ArrayList;
import java.util.List;
import com.example.soccer_team_management_app.iterator.TeamIterator;
import com.example.soccer_team_management_app.model.Team;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TeamAdapter extends RecyclerView.Adapter<TeamViewHolder> {
    private List<Team> teams;// Original list
    private List<Team> filteredTeams; // Filtered list for RecyclerView

    public TeamAdapter(List<Team> teams){
        this.teams=new ArrayList<>(teams);
        this.filteredTeams=new ArrayList<>(teams);

    }
    @NonNull
    @Override
    // Inflate the item layout and create a new view holder
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new TeamViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false));

    }
    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position){
        // Get the team data for the current position
        Team team=filteredTeams.get(position);
        // Set the data in the views of the holder
        holder.nameTextView.setText(team.getName());
        holder.countryTextView.setText(team.getCountry());
        holder.leagueTextView.setText(team.getLeague());
        holder.stadiumTextView.setText(team.getStadium());
        holder.yearFoundedtextView.setText(String.valueOf(team.getYearFounded()));

    }
    //Returns the number of teams in filteredTeams, so the RecyclerView would know how many items to display
    @Override
    public int getItemCount(){
        return filteredTeams.size();

    }
    public void filter(Predicate<Team> predicate){
        // Filters teams based on the provided condition and converts the filtered stream back to a list
        filteredTeams=teams.stream().filter(predicate).collect(Collectors.toList());
        // Refreshes RecyclerView to reflect the new order
        notifyDataSetChanged();

    }
    public void sort(Comparator<Team> comparator){
        // Sorts teams based on the given comparator
        filteredTeams=teams.stream().sorted(comparator).collect(Collectors.toList());
        notifyDataSetChanged();

    }

}
