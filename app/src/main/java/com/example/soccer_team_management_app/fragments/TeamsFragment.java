package com.example.soccer_team_management_app.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.soccer_team_management_app.R;
import com.example.soccer_team_management_app.adapter.TeamAdapter;
import com.example.soccer_team_management_app.model.Team;
import java.util.Comparator;
import java.util.function.Predicate;
/**
 * A fragment that displays a list of soccer teams using a RecyclerView.
 * Provides functionality to filter and sort teams using buttons.
 */
public class TeamsFragment extends Fragment {
    private TeamAdapter adapter;
    /**
     * Create a new instance of the fragment with an assigned adapter.
     *
     * @param adapter The adapter for displaying teams.
     * @return A new instance of TeamsFragment.
     */
    public static TeamsFragment newInstance(TeamAdapter adapter) {
        TeamsFragment fragment = new TeamsFragment();
        fragment.adapter = adapter;
        return fragment;
    }

    @NonNull
    @Override
    /**
     * Inflates the fragment layout and sets up the RecyclerView with sorting and filtering buttons.
     *
     * @param inflater The LayoutInflater object to inflate views.
     * @param container The parent view that the fragment's UI should be attached to.
     * @param savedInstanceState A bundle containing previous state data.
     * @return The created and inflated View for this fragment.
     */
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Set up filter button to show only teams from "Premier League"
        Button btnFilter = view.findViewById(R.id.btn_filter);
        btnFilter.setOnClickListener(v -> {
            adapter.filter(team -> team.getLeague().equals("Premier League"));
        });
        // Set up sort button to sort teams alphabetically by name
        Button btnSort = view.findViewById(R.id.btn_sort);
        btnSort.setOnClickListener(v -> {
            adapter.sort(Comparator.comparing(Team::getName));
        });

        return view;

    }
}
