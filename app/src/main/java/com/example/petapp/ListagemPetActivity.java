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
import java.util.List;

public class ListagemPetActivity extends AppCompatActivity {
    ArrayList<Pet> listapet ; // criei a variavel
    RepositorioPet repositorioPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_pet);
        setTitle(R.string.title_listagem_pet);
        listapet =
                (ArrayList<Pet>) getIntent()
                        .getSerializableExtra("lista_pet");
        Log.i("pet", "Carregado Listagem Pet com sucesso");

        repositorioPet = new RepositorioPet(this);
        // listando os dados no LogCat
        for(Pet pet : DadosCompartilhados.lista){
            Log.i("pet", "Nome pet: "+ pet.nome);
            Log.i("pet", "Idade pet: "+ pet.idade);
            Log.i("pet", "------------------------");
        }

        ListView listView = findViewById(R.id.listviewpet);
        List<Pet> listaDB = repositorioPet.listarPet();
        String[] dados = new String[listaDB.size()];
        // passando da lista para o vetor.
        for(int i=0; i < listaDB.size();i++){
            Pet pet = listaDB.get(i);
            dados[i] = pet.nome + " - "  +pet.idade;
        }
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        dados);

        listView.setAdapter(adapter);

    }
}