package com.example.handesaimandroidcoursecompletionproject;

import java.util.ArrayList;

public class User {
    private String name;
    private String id;
    private ArrayList<Item> shoppingList;//Should totaly be a map of Item,Integer to count items in the shoppingList, but whatever.
    private int priceTotal;

    public void setName(String name) {
        this.name = name;
    }

    public boolean add(Item item) {
        return shoppingList.add(item);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setShoppingList(ArrayList<Item> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public void setPriceTotal(int priceTotal) {
        this.priceTotal = priceTotal;
    }
}
