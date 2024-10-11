package com.example.petapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListagemPetActivity extends AppCompatActivity {
    ArrayList<Pet> listapet ; // criei a variavel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_pet);
        setTitle(R.string.title_listagem_pet);
        listapet =
                (ArrayList<Pet>) getIntent()
                        .getSerializableExtra("lista_pet");
        Log.i("pet", "Carregado Listagem Pet com sucesso");

        // listando os dados no LogCat
        for(Pet pet : DadosCompartilhados.lista){
            Log.i("pet", "Nome pet: "+ pet.nome);
            Log.i("pet", "Idade pet: "+ pet.idade);
            Log.i("pet", "------------------------");
        }

        ListView listView = findViewById(R.id.listviewpet);
        String[] dados =
                new String[DadosCompartilhados.lista.size()];
        // passando da lista para o vetor.
        for(int i=0; i < DadosCompartilhados.lista.size();i++){
            Pet pet = DadosCompartilhados.lista.get(i);
            dados[i] = pet.nome + " - "  +pet.idade;
        }
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        dados);

        listView.setAdapter(adapter);

    }
}