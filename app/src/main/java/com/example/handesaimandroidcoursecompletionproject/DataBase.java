package com.example.handesaimandroidcoursecompletionproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Yes";
    private static final int DATABASE_VERSION = 1;
    private static Context context;
    static private Boolean flag;//singleton
    static private DataBase dataBase;

    public static DataBase getInstance() {
        if(flag) return dataBase;
        dataBase = new DataBase(context);
        return dataBase;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Items ("
                +"ItemPrimaryKey Integer PRIMARY KEY AUTOINCREMENT,"
                +"number TEXT,"
                +"name TEXT,"
                +"price INTEGER"
                +")");
        db.execSQL("CREATE TABLE Users("
                +"UserPrimeryKey Integer PRIMARY KEY AUTOINCREMENT,"
                +"name TEXT,"
                +"id TEXT,"
                +"ForeginKeyShoppingList INTEGER,"
                +"priceTotal INTEGER"
                +")");
        db.execSQL("CREATE TABLE ShoppingLists("
                +"ShoppingListPrimeryKey PRIMARY KEY AUTOINCREMENT,"
                +"UserPrimeryKey Integer,"
                +"ItemPrimaryKey Integer,"
                +"FOREIGN KEY(UserPrimeryKey) REFERENCES Users(UserPrimaryKey) on delete cascade,"
                +"FOREIGN KEY(ItemPrimeryKey) REFERENCES Items(ItemPrimaryKey) on delete cascade"
                +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "ItemPrimaryKey");
        db.execSQL("DROP TABLE IF EXISTS " + "UserPrimeryKey");
        db.execSQL("DROP TABLE IF EXISTS " +"ShoppingListPrimeryKey");
        onCreate(db);

    }

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        flag = true;
    }

    static public Boolean createUser(String name, String id, ArrayList<Item> shoppingList){

    }
    static public Boolean updateUser(String name, ArrayList<Item> shoppingList){

    }
    static public User getUser(String name, String id){

    }
    static public Boolean createItem(String number, String name, int price){

    }
    static public ArrayList<Item> getItems(){

    }


}
