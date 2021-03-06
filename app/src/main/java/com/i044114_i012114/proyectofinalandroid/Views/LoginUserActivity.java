package com.i044114_i012114.proyectofinalandroid.Views;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.i044114_i012114.proyectofinalandroid.Adapters.UserAdapter;
import com.i044114_i012114.proyectofinalandroid.Helpers.SqliteHelper;
import com.i044114_i012114.proyectofinalandroid.LoginActivity;
import com.i044114_i012114.proyectofinalandroid.Models.Users;
import com.i044114_i012114.proyectofinalandroid.R;
import com.i044114_i012114.proyectofinalandroid.Utilities.Constants;

import java.util.ArrayList;
import java.util.List;

public class LoginUserActivity extends AppCompatActivity {

    SqliteHelper sqliteHelper;
    private Cursor fila;
    EditText editTextUser;
    EditText editTextPassword;
    TextView textViewn;
    TextView textViewp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);

        editTextUser = (EditText) findViewById(R.id.id_et_users);
        editTextPassword = (EditText) findViewById(R.id.id_et_password);

        }

        public void login (View view){
            SQLiteDatabase db= sqliteHelper.getWritableDatabase();
            Cursor cursor = db.rawQuery("select name,password from users where name = '"+editTextUser.getText()+"' and password = '"+editTextPassword+"'", null);

            if (cursor.moveToFirst()==true){
               if (editTextUser.equals(Constants.TABLA_FIELD_NAME) && editTextPassword.equals(Constants.TABLA_FIELD_PASSWORD)){
                   Intent intent = new Intent(this, ProductListActivity.class);
                   startActivity(intent);
               }else{
                   Toast.makeText(this, "no se encontro el usuario", Toast.LENGTH_SHORT).show();
               }
            }

            cursor.close();
        }


    }

