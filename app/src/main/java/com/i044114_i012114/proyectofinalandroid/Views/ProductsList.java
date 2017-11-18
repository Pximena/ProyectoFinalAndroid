package com.i044114_i012114.proyectofinalandroid.Views;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.i044114_i012114.proyectofinalandroid.Helpers.SqliteHelper;

/**
 * Created by ACER on 15/11/2017.
 */

public class ProductsList {
    SqliteHelper sqliteHelper;

   public static String[] arreglo() {

        String[ ][ ]  arrayproducts = new String[5][4];
        arrayproducts [0] [0] = "ACETAMINOFEN";
        arrayproducts [0] [1] = "Presentacion en tabletas y jarabe para niño y adulto";
        arrayproducts [0] [2] = "30";
        arrayproducts [0] [3] = "http://3.bp.blogspot.com/-Gffbq6aKPoU/VWHeovCOkhI/AAAAAAAAAFk/O4Qax3ZjSzc/s1600/acetaminofen%2B%25281%2529.jpg";
        arrayproducts [1] [0] = "IBUPROFENO";
        arrayproducts [1] [1] = "Presentacion en grajeas x 12 de 200gr c/u. Dolor y fiebre";
        arrayproducts [1] [2] = "50";
        arrayproducts [1] [3] = "http://www.resumenlatinoamericano.org/wp-content/uploads/2015/05/IBUPROFENO.jpg";
        arrayproducts [2] [0] = "AMOXICILINA";
        arrayproducts [2] [1] = "Presentacion en capsulas de 500mg caja x 50. Distribuido por Genfar";
        arrayproducts [2] [2] = "120";
        arrayproducts [2] [3] = "https://www.farmalisto.com.co/94653-thickbox_default/comprar-amoxicilina-500-mg-caja-x-50-capsulas-rx2-precio-7702605100309.jpg";
        arrayproducts [3] [0] = "ADVIL";
        arrayproducts [3] [1] = "Liquid gels, 16 capsulas. Para mejor alivio";
        arrayproducts [3] [2] = "20";
        arrayproducts [3] [3] = "http://neopharmgroup.com/wp-content/uploads/2012/12/advil.jpg";
        arrayproducts [4] [0] = "AMPICILINA";
        arrayproducts [4] [1] = "Tabletas, Capsulas y Jarabe, infecciones causadas por basterias ";
        arrayproducts [4] [2] = "30";
        arrayproducts [4] [3] = "http://tecnoquimicasfarma.com.ec/portals/9/Images/antiinfecciosos/AmpicilinaE.jpg";
        arrayproducts [5] [0] = "BISOLVON";
        arrayproducts [5] [1] = "Jarabe. Efectivo contra la tos y flema";
        arrayproducts [5] [2] = "30";
        arrayproducts [5] [3] = "https://www.farmalisto.com.co/94954-thickbox_default/comprar-bisolvon-jarabe-caja-con-frasco-x-120-ml-precio-7703381000777.jpg";
        return arrayproducts[0];
    }

    public void registrosproducts(){
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            ProductsList productsList = new ProductsList();

            for (int i = 0; i < arreglo().length; i++) {
                values.put("nameprod", productsList.arreglo()[i]);
                values.put("quantity", productsList.arreglo()[i]);
                db.insert("products", null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

    }
}
