package com.example.soccer_team_management_app.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.soccer_team_management_app.R;
// View holder for the individual items-teams
public class TeamViewHolder extends RecyclerView.ViewHolder {
    public TextView nameTextView, countryTextView, leagueTextView, stadiumTextView, yearFoundedtextView;
    public TeamViewHolder(View itemView){
        //calls the constructor of its superclass, RecyclerView.ViewHolder
        super(itemView);
        //Initializes UI elements
        nameTextView=itemView.findViewById(R.id.teamName);
        countryTextView=itemView.findViewById(R.id.countryName);
        leagueTextView=itemView.findViewById(R.id.leagueName);
        stadiumTextView=itemView.findViewById(R.id.teamStadium);
        yearFoundedtextView=itemView.findViewById(R.id.teamFounded);

    }
}
