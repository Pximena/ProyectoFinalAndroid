package com.i044114_i012114.proyectofinalandroid;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.i044114_i012114.proyectofinalandroid.Adapters.UserAdapter;
import com.i044114_i012114.proyectofinalandroid.Helpers.SqliteHelper;
import com.i044114_i012114.proyectofinalandroid.Models.Users;
import com.i044114_i012114.proyectofinalandroid.Views.LoginUserActivity;
import com.i044114_i012114.proyectofinalandroid.Views.ProductListActivity;
import com.i044114_i012114.proyectofinalandroid.Views.RegisterUserActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }

    public void goToResgister (View view){
        Intent intent = new Intent(this, RegisterUserActivity.class);
        startActivity(intent);

    }

    public void goToLogin (View view){
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);

    }


}
