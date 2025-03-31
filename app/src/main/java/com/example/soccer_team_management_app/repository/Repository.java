package com.example.soccer_team_management_app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
//A generic class designed to be used by reusable for different types of entities(Teams,...)
public class Repository <T>{
    private List<T> items=new ArrayList<>();
    // Method to retrieve all items in the repository.
    public List<T> getAll(){
        return new ArrayList<>(items);
    }
    /**
     * Add an item to the container
     *
     * @param item the item to add
     * @throws IllegalArgumentException if the item is null
     */
    public void add(T item){
        if (item==null){
            throw new IllegalArgumentException("Item cannot be null");

        }
        items.add(item);
    }
    // A method that filters the list based on a given predicate.
    public List<T> filter(Predicate<T> predicate){
        List<T> result=new ArrayList<>();
        // Iterates over the items and applies the predicate to each item.
        //If the item satisfies the condition, adds it to the result list.
        for(T item : items){
            if(predicate.test(item)){
                result.add(item);
            }
        }
        return result;
    }


}
