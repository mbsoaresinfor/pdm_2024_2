package com.example.petapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
        String sql = "insert into pet values(null,'" +
                pet.nome + "'," + pet.idade + ")";
      Log.i("pet","SQL insert pet: " + sql);
        super.getWritableDatabase().execSQL(sql);
    }

    public List<Pet> buscarPetPeloNome(String nome){
        ArrayList<Pet> lista = new ArrayList<Pet>();
        String sql = "select * from pet where "
                 + "nome = " + nome;
        Cursor cursor = getWritableDatabase()
                .rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Pet pet = new Pet();
            pet.id = cursor.getInt(0); // coluna 0
            pet.nome = cursor.getString(1); // coluna 1
            pet.idade = cursor.getInt(2);// coluna 2
            lista.add(pet);
            cursor.moveToNext();
        }
        cursor.close();
        return lista;
    }

    public List<Pet> listarPet(){
        ArrayList<Pet> lista = new ArrayList<Pet>();
        String sql = "select * from pet";
        Cursor cursor = getWritableDatabase()
                .rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Pet pet = new Pet();
            pet.id = cursor.getInt(0); // coluna 0
            pet.nome = cursor.getString(1); // coluna 1
            pet.idade = cursor.getInt(2);// coluna 2
            lista.add(pet);
            cursor.moveToNext();
        }
        cursor.close();
        return lista;
    }

    public Pet buscarPet(Integer id){
        String sql = "select * from pet where id ="
                + id;
        Cursor cursor = getWritableDatabase()
                .rawQuery(sql,null);
        cursor.moveToFirst();
        Pet pet = null;
        for(int i=0; i < cursor.getCount(); i++){
            pet = new Pet();
            pet.id = cursor.getInt(0); // coluna 0
            pet.nome = cursor.getString(1); // coluna 1
            pet.idade = cursor.getInt(2);// coluna 2
            cursor.moveToNext();
        }
        cursor.close();
        return pet;
    }


    public void removerPet(Integer id){
        String sql = "delete from pet where id =" + id;
        getWritableDatabase().execSQL(sql);
        Log.i("pet","SQL delete pet: " + sql);
    }

    public void atualizarPet(Pet pet){
        String sql = "update pet set " +
                "nome = '" + pet.nome + "',"+
                "idade = " + pet.idade +
                " where id = " + pet.id;
        getWritableDatabase().execSQL(sql);
        Log.i("pet","SQL update pet: " + sql);
    }






    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
