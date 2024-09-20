package com.example.petapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class RemoverPetActivity extends AppCompatActivity {
    ArrayList<Pet> listapet ; // criei a variavel
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover_pet);
        setTitle("Remover Pet");
        listapet =
                (ArrayList<Pet>) getIntent()
                        .getSerializableExtra("lista_pet");
        Log.i("pet", "Carregado Remoção Pet com sucesso");
    }
}