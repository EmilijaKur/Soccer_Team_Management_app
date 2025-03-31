package com.example.soccer_team_management_app;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.soccer_team_management_app.adapter.MatchAdapter;
import com.example.soccer_team_management_app.adapter.PlayerAdapter;
import com.example.soccer_team_management_app.adapter.TeamAdapter;
import com.example.soccer_team_management_app.adapter.ViewPagerAdapter;
import com.example.soccer_team_management_app.fragments.MatchesFragment;
import com.example.soccer_team_management_app.fragments.PlayersFragment;
import com.example.soccer_team_management_app.fragments.TeamsFragment;
import com.example.soccer_team_management_app.model.Match;
import com.example.soccer_team_management_app.model.Player;
import com.example.soccer_team_management_app.provider.DataProvider;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.example.soccer_team_management_app.R;
import com.example.soccer_team_management_app.model.Team;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager; //for managing fragment navigation
    private TabLayout tabLayout; //for switching between different fragments

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Sets the layout file for this activity

        //Initialize data by creating sample teams, players, and matches
        List <Team> teams= DataProvider.createSampleTeams();
        List <Player> players= DataProvider.createSamplePlayers();
        List<Match> matches = DataProvider.createSampleMatches();

        //Create adapters to manage data display for each fragment
        TeamAdapter teamAdapter = new TeamAdapter(teams);
        PlayerAdapter playerAdapter = new PlayerAdapter(players);
        MatchAdapter matchAdapter = new MatchAdapter(matches);

        // Setup ViewPager with TabLayout to allow fragment navigation via swipe and tabs
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        // Add fragments to the ViewPagerAdapter, each representing a different section
        ViewPagerAdapter adapter=new ViewPagerAdapter(this);
        adapter.addFragment(TeamsFragment.newInstance(teamAdapter), "Teams");
        adapter.addFragment(PlayersFragment.newInstance(playerAdapter), "Players");
        adapter.addFragment(MatchesFragment.newInstance(matchAdapter), "Matches");

        viewPager.setAdapter(adapter);
        // Link the TabLayout with the ViewPager, setting tab titles dynamically
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(adapter.getPageTitle(position))).attach();
    }
}