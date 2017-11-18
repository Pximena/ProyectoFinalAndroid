package com.i044114_i012114.proyectofinalandroid.Views;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.i044114_i012114.proyectofinalandroid.Helpers.SqliteHelper;
import com.i044114_i012114.proyectofinalandroid.LoginActivity;
import com.i044114_i012114.proyectofinalandroid.R;
import com.i044114_i012114.proyectofinalandroid.Utilities.Constants;

public class RegisterUserActivity extends AppCompatActivity {
   TextInputEditText textInputEditTextId;
    TextInputEditText textInputEditTextName;
    TextInputEditText textInputEditTextPhone;
    TextInputEditText textInputEditTextEmail;
    TextInputEditText textInputEditTextAddress;
    TextInputEditText textInputEditTextPassword;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        textInputEditTextId = (TextInputEditText) findViewById(R.id.id_tv_id);
        textInputEditTextName = (TextInputEditText) findViewById(R.id.id_tv_name);
        textInputEditTextPhone = (TextInputEditText) findViewById(R.id.id_tv_phone);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.id_tv_email);
        textInputEditTextAddress = (TextInputEditText) findViewById(R.id.id_tv_address);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.id_tv_password);

        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);
    }

    public void onClickCreateUser(View view){
        String stringId = textInputEditTextId.getText().toString();
        String stringName = textInputEditTextName.getText().toString();
        String stringPhone = textInputEditTextPhone.getText().toString();
        String stringEmail = textInputEditTextEmail.getText().toString();
        String stringAddress = textInputEditTextEmail.getText().toString();
        String stringPassword = textInputEditTextPassword.getText().toString();

        if (TextUtils.isEmpty(stringId)){
            Toast.makeText(this, "El campo de id esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringName)){
            Toast.makeText(this, "El campo nombre esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringPhone)){
            Toast.makeText(this, "El campo de telefono esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringEmail)){
            Toast.makeText(this, "El campo de email esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringAddress)){
            Toast.makeText(this, "El campo de direccion esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringPassword)){
            Toast.makeText(this, "El campo de contraseña esta vacio", Toast.LENGTH_SHORT).show();
        }else{
            createUser();
        }
    }

    public void createUser(){
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.TABLA_FIELD_ID, textInputEditTextId.getText().toString());
        values.put(Constants.TABLA_FIELD_NAME, textInputEditTextName.getText().toString());
        values.put(Constants.TABLA_FIELD_PHONE, textInputEditTextPhone.getText().toString());
        values.put(Constants.TABLA_FIELD_EMAIL, textInputEditTextEmail.getText().toString());
        values.put(Constants.TABLA_FIELD_ADDRESS, textInputEditTextAddress.getText().toString());
        values.put(Constants.TABLA_FIELD_PASSWORD, textInputEditTextPassword.getText().toString());

        Long idResult = db.insert(Constants.TABLA_NAME_USERS,null, values);

        textInputEditTextId.setText("");
        textInputEditTextName.setText("");
        textInputEditTextPhone.setText("");
        textInputEditTextEmail.setText("");
        textInputEditTextAddress.setText("");
        textInputEditTextPassword.setText("");

       Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
