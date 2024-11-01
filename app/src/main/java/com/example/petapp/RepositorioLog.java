package com.example.petapp;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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

    public List<Log> listarLogs(String usuario){

            ArrayList<Log> lista = new ArrayList<Log>();
            StringBuilder sql = new StringBuilder("select * from log ");
            if(usuario != null) {
                sql.append(" where usuario = '");
                sql.append(usuario);
                sql.append("'");
            }

            Cursor cursor = getWritableDatabase()
                    .rawQuery(sql.toString(),null);
            cursor.moveToFirst();
            for(int i=0; i < cursor.getCount(); i++){
                Log log = new Log();
                log.id = cursor.getInt(0); // coluna 0
                log.data = cursor.getString(1); // coluna 1
                log.operacao = cursor.getString(2);// coluna 2
                log.usuario = cursor.getString(3);// coluna 3
                lista.add(log);
                cursor.moveToNext();
            }
            cursor.close();
            return lista;
        }
}
