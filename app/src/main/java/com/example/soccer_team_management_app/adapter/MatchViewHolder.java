package com.example.soccer_team_management_app.adapter;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.soccer_team_management_app.R;
public class MatchViewHolder extends RecyclerView.ViewHolder {
    // View holder for the individual items-matches
    public TextView homeTeamTextView, awayTeamTextView, scoreTextView, dateTextView, leagueTextView, stadiumTextView;
    public MatchViewHolder(View itemView){

        super(itemView);
        //Initializes UI elements
        homeTeamTextView=itemView.findViewById(R.id.homeTeam);
        awayTeamTextView=itemView.findViewById(R.id.awayTeam);
        scoreTextView=itemView.findViewById(R.id.matchScore);
        leagueTextView=itemView.findViewById(R.id.matchLeague);
        dateTextView=itemView.findViewById(R.id.matchDate);
        stadiumTextView=itemView.findViewById(R.id.matchStadium);

    }
}
