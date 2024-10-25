package com.example.petapp;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class RepositorioLog extends SQLiteOpenHelper {
    public RepositorioLog(@Nullable Context context) {
        super(context, "log", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql ="create table log " +
                "(id integer not null primary key," +
                "data text," +
                "operacao text," +
                "usuario text)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void logar(Log log){
        String sql = "insert into log values(null," +
                "'" + log.data + "'," +
                "'" + log.operacao + "'," +
                "'" + log.usuario + "')";

        super.getWritableDatabase().execSQL(sql);
        android.util.Log.i("pet","SQL insert log: " + sql);
    }

}
