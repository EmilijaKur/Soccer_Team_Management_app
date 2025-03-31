package com.example.soccer_team_management_app.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;
import java.util.List;
/**
 * Custom adapter for managing fragments in a ViewPager2.
 * Allows dynamic addition of fragments and their corresponding titles.
 */
public class ViewPagerAdapter extends FragmentStateAdapter {
    private final List<Fragment> fragments=new ArrayList<>();
    // List to store fragment titles (used for displaying tab names)
    private final List<String> fragmentTitles=new ArrayList<>();
    /**
     * Constructor for ViewPagerAdapter.
     * It initializes the adapter with the parent FragmentActivity.
     *
     * @param fragmentActivity The activity that hosts the ViewPager2.
     */
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }
    /**
     * Adds a fragment along and its title to the adapter.
     *
     * @param fragment The fragment to be added.
     * @param title The title associated with the fragment (for tab display).
     */
    public void addFragment(Fragment fragment, String title){
        fragments.add(fragment);
        fragmentTitles.add(title);

    }
    //Returns the title of the fragment at a given position.
    public CharSequence getPageTitle(int position){
        return fragmentTitles.get(position);

    }
    /**
     * Creates a new fragment for the given position.
     * This method is called when the ViewPager2 needs to display a fragment.
     *
     * @param position The index of the fragment to be displayed.
     * @return The fragment at the specified position.
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }
    /**
    * @return The number of fragments in the adapter.
     */
    @Override
    public int getItemCount() {
        return fragments.size();
    }


}
