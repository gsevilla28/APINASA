package idmexico.com.mx.nasaapi.sql;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Administrator on 18/08/2016.
 */
public class SqLiteHelper extends SQLiteOpenHelper {

    /*nombre y version de la base de datos*/
    private static final String DATABASE_NAME="APINASA";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "FAVORITAS";
    public static final String COLUMN_ID= BaseColumns._ID;
    public static final String COLUMN_APP_TITULO = "TITLE";
    public static final String COLUMN_APP_DESCRIPCION = "DESCRIPCION";
    public static final String COLUMN_APP_FECHA = "FECHA";
    public static final String COLUMN_APP_RESOURCE = "RESOURCE_IMG";

    private static final String CREATE_TABLE ="CREATE TABLE " + TABLE_NAME +
            " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_APP_TITULO + " TEXT NOT NULL, " +
            COLUMN_APP_DESCRIPCION + " TEXT NOT NULL, " +
            COLUMN_APP_FECHA + " TEXT NOT NULL, " +
            COLUMN_APP_RESOURCE + " INTEGER)";


    public SqLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
