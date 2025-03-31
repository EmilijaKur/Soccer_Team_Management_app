package com.example.soccer_team_management_app.adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.soccer_team_management_app.R;
import com.example.soccer_team_management_app.model.Match;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MatchAdapter extends RecyclerView.Adapter<MatchViewHolder>{
    private final List<Match> matches; // Original list
    private List<Match> filteredMatches;
    //Constructor
    public MatchAdapter(List<Match> matches) {
        this.matches = new ArrayList<>(matches);
        this.filteredMatches = new ArrayList<>(matches);
    }
    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new MatchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false));

    }
    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        // Get the match data for the current position
        Match match = filteredMatches.get(position);
        // Set the data in the views of the holder
        holder.homeTeamTextView.setText(match.getHomeTeam());
        holder.awayTeamTextView.setText(match.getAwayTeam());
        holder.scoreTextView.setText(match.getScore());
        holder.leagueTextView.setText(match.getLeague());
        holder.dateTextView.setText(match.getDate());
        holder.stadiumTextView.setText(match.getStadium());
    }
    @Override
    public int getItemCount() {
        return filteredMatches.size();
    }
    // Sorts players based on the given comparator
    public void sort(Comparator<Match> comparator){
        filteredMatches=matches.stream().sorted(comparator).collect(Collectors.toList());
        notifyDataSetChanged();

    }
}
