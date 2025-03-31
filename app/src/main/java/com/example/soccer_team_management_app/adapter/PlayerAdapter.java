package com.example.soccer_team_management_app.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.soccer_team_management_app.R;
import com.example.soccer_team_management_app.model.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerViewHolder>{
    private final List<Player> players; // Original list
    private List<Player> filteredPlayers;
    //Constructor
    public PlayerAdapter(List<Player> players){
        this.players=new ArrayList<>(players);
        this.filteredPlayers=new ArrayList<>(players);
    }
    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new PlayerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false));

    }
    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        // Get the player data for the current position
        Player player = filteredPlayers.get(position);
        // Set the data in the views of the holder
        holder.nameTextView.setText(player.getName());
        holder.agetextView.setText(String.valueOf(player.getAge()));
        holder.countryTextView.setText(player.getCountry());
        holder.positionTextView.setText(player.getPosition());
        holder.teamTextView.setText(player.getTeam());
        holder.jerseyNrTextView.setText(String.valueOf(player.getJerseyNumber()));
    }
    @Override
    public int getItemCount() {
        return filteredPlayers.size();
    }

    public void sort(Comparator<Player> comparator){
        // Sorts players based on the given comparator
        filteredPlayers=players.stream().sorted(comparator).collect(Collectors.toList());
        notifyDataSetChanged();

    }


}
