package com.i044114_i012114.proyectofinalandroid.Views;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.i044114_i012114.proyectofinalandroid.Adapters.ProductAdapter;
import com.i044114_i012114.proyectofinalandroid.Helpers.SqliteHelper;
import com.i044114_i012114.proyectofinalandroid.Models.Products;
import com.i044114_i012114.proyectofinalandroid.R;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    RecyclerView recyclerViewProduct;
    ProductAdapter productAdapter;
    List<Products> productList = new ArrayList<>();
    SqliteHelper sqliteHelper;
    //FloatingActionButton floatingActionButtonCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        recyclerViewProduct = (RecyclerView) findViewById(R.id.id_rv_product);
        sqliteHelper = new SqliteHelper(this, "bd_products", null, 1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewProduct.setLayoutManager(linearLayoutManager);

        listProducts();
    }

    public void listProducts(){
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select id,name,description,price,image from products order by id desc", null);

        while (cursor.moveToNext()){
            Products product = new Products();
            product.setId(cursor.getInt(0));
            product.setName(cursor.getString(1));
            product.setDescription(cursor.getString(2));
            product.setQuantity(cursor.getString(3));
            product.setImage(cursor.getString(4));
            productList.add(product);
        }

        cursor.close();

        processData();
    }

    public void processData(){
        if (productList.size() != 0){
            productAdapter = new ProductAdapter(productList, getApplicationContext());
            recyclerViewProduct.setAdapter(productAdapter);
        }else{
            Toast.makeText(this, "No hay productos registrados", Toast.LENGTH_SHORT).show();
        }
    }
}
