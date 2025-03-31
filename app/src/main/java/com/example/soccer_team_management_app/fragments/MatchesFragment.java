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
import com.example.soccer_team_management_app.adapter.MatchAdapter;
import java.util.Comparator;
/**
 * A fragment that displays a list of matches using a RecyclerView.
 * Provides functionality to sort matches button.
 */
public class MatchesFragment extends Fragment {
    private MatchAdapter adapter;

    public static MatchesFragment newInstance(MatchAdapter adapter) {
        MatchesFragment fragment = new MatchesFragment();
        fragment.adapter = adapter;
        return fragment;
    }
    /**
     * Inflates the fragment layout and sets up the RecyclerView with sorting and filtering buttons.
     *
     * @param inflater The LayoutInflater object to inflate views.
     * @param container The parent view that the fragment's UI should be attached to.
     * @param savedInstanceState A bundle containing previous state data.
     * @return The created inflated View for this fragment.
     */
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matches, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.match_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        // Set up sort button to sort matches alphabetically by teams names
        Button btnSort = view.findViewById(R.id.match_btn_sort);
        btnSort.setOnClickListener(v -> {
            adapter.sort(Comparator.comparing(match -> match.getHomeTeam() + " - " + match.getAwayTeam()));
        });

        return view;
    }
}
