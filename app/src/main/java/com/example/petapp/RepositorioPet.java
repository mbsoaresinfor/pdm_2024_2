package com.example.petapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class RepositorioPet extends SQLiteOpenHelper {

    public RepositorioPet(@Nullable Context context) {
        super(context, "pet", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql ="create table pet " +
                "(id integer not  null primary key," +
                "nome text," +
                "idade integer)";
        sqLiteDatabase.execSQL(sql);
        Log.i("pet","Criado com sucesso a tabela pet");
    }

    public void adicionarPet(Pet pet){
        String sql = "insert into pet values(' " +
                pet.nome + "'," + pet.idade + ")";
      Log.i("pet","SQL insert pet: " + sql);
        super.getWritableDatabase().execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
