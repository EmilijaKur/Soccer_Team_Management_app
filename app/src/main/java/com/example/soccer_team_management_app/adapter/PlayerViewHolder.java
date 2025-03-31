package com.example.soccer_team_management_app.adapter;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.soccer_team_management_app.R;
public class PlayerViewHolder extends RecyclerView.ViewHolder{
    public TextView nameTextView, positionTextView, teamTextView, agetextView, jerseyNrTextView, countryTextView;
    // View holder for the individual items-players
    public PlayerViewHolder(View itemView){

        super(itemView);
        //Initializes UI elements
        nameTextView=itemView.findViewById(R.id.playerName);
        agetextView=itemView.findViewById(R.id.playerAge);
        countryTextView=itemView.findViewById(R.id.playerCountry);
        positionTextView=itemView.findViewById(R.id.playerPosition);
        teamTextView=itemView.findViewById(R.id.playerTeam);
        jerseyNrTextView=itemView.findViewById(R.id.playerJerseyNr);

    }
}
