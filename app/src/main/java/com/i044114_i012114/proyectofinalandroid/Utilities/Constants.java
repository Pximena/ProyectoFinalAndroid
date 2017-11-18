package com.i044114_i012114.proyectofinalandroid.Utilities;

/**
 * Created by ACER on 13/11/2017.
 */

public class Constants {

    public static final String TABLA_NAME_USERS = "users";
    public static final String TABLA_FIELD_ID = "id";
    public static final String TABLA_FIELD_NAME = "name";
    public static final String TABLA_FIELD_PHONE = "phone";
    public static final String TABLA_FIELD_EMAIL = "email";
    public static final String TABLA_FIELD_ADDRESS= "address";
    public static final String TABLA_FIELD_PASSWORD= "password";
    public static final String CREATE_TABLE_USERS =
            "CREATE TABLE "+ TABLA_NAME_USERS+" ("+
                    TABLA_FIELD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_NAME+" TEXT, "+
                    TABLA_FIELD_PHONE+" TEXT, "+
                    TABLA_FIELD_EMAIL+" TEXT, " +
                    TABLA_FIELD_ADDRESS+" TEXT, "+
                    TABLA_FIELD_PASSWORD+ "TEXT)";

    public static final String TABLE_NAME_PRODUCTS = "products";
    public static final String TABLE_FIELD_PRODUCTS_ID = "id";
    public static final String TABLE_FIELD_PRODUCTS_NAME = "name";
    public static final String TABLE_FIELD_PRODUCTS_DESCRIPTION = "description";
    public static final String TABLE_FIELD_PRODUCTS_PRICE = "quantity";
    public static final String TABLE_FIELD_PRODUCTS_IMAGE = "image";
    public static final String CREATE_TABLE_PRODUCTS =
            "CREATE TABLE "+ TABLE_NAME_PRODUCTS+" ("+
                    TABLE_FIELD_PRODUCTS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLE_FIELD_PRODUCTS_NAME+" TEXT, "+
                    TABLE_FIELD_PRODUCTS_DESCRIPTION+" TEXT, "+
                    TABLE_FIELD_PRODUCTS_PRICE+" TEXT, "+
                    TABLE_FIELD_PRODUCTS_IMAGE+" TEXT)";



}

