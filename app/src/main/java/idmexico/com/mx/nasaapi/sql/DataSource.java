package idmexico.com.mx.nasaapi.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import idmexico.com.mx.nasaapi.model.APOD;

/**
 * Created by Administrator on 18/08/2016.
 */
public class DataSource {

    private final SQLiteDatabase sql;
    private final ContentValues contentValues = new ContentValues();

    public DataSource(Context context) {
        SqLiteHelper helper = new SqLiteHelper(context);
        sql= helper.getWritableDatabase();
    }

    public long SaveFavorite(String title, String descripcion,String fecha, String image){
        contentValues.put(SqLiteHelper.COLUMN_APP_TITULO,title);
        contentValues.put(SqLiteHelper.COLUMN_APP_DESCRIPCION,descripcion);
        contentValues.put(SqLiteHelper.COLUMN_APP_FECHA,fecha);
        contentValues.put(SqLiteHelper.COLUMN_APP_RESOURCE, image);

        long data = sql.insert(SqLiteHelper.TABLE_NAME,null,contentValues);
        contentValues.clear();

        return data;

    }

    public List<APOD> getAllFavorites(){
        APOD apod = null;
        List<APOD> listApod = new ArrayList<>();

        Cursor c = sql.query(SqLiteHelper.TABLE_NAME,null,null,null,null,null,null,null);

        while (c.moveToNext()){
            apod = new APOD();
            apod.setTitle(c.getString(c.getColumnIndexOrThrow(SqLiteHelper.COLUMN_APP_TITULO)));
            apod.setExplanation(c.getString(c.getColumnIndexOrThrow(SqLiteHelper.COLUMN_APP_DESCRIPCION)));
            apod.setDate(c.getString(c.getColumnIndexOrThrow(SqLiteHelper.COLUMN_APP_FECHA)));
            apod.setUrl(c.getString(c.getColumnIndexOrThrow(SqLiteHelper.COLUMN_APP_RESOURCE)));
            listApod.add(apod);
        }
        return listApod;


    }






}
