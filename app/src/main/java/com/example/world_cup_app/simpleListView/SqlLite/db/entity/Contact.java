package com.example.world_cup_app.simpleListView.SqlLite.db.entity;

public class Contact {

    //constants for database-1
    public static final String  TABLE_NAME ="Contacts";
    public static final String  COLUMN_ID ="contact_id";
    public static final String  COLUMN_NAME ="contact_name";
    public static final String  COLUMN_EMAIL ="contact_email";

    //variables 2
    private String name;
    private String email;

    private int id;

    //3-Constructors
    public  Contact(){

    }

    public Contact(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    //getter and setter -4


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //SQL Query : Creating the Table
    //thats perfom the creating the table

    public static final String CREATE_TABLE = "CREATE TABLE "
            + Contact.TABLE_NAME + "("
            + Contact.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Contact.COLUMN_NAME + " TEXT, "
            + Contact.COLUMN_EMAIL + " DATETIME DEFAULT CURRENT_TIMESTAMP"
            + ")";


}
