package com.example.petapp;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class CadastroPetActivity extends AppCompatActivity {
    ArrayList<Pet> listapet ; // criei a variavel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);
        setTitle("Cadastro Pet");
         listapet =
                (ArrayList<Pet>) getIntent()
                .getSerializableExtra("lista_pet");
        Log.i("pet", "Carregado Cadastro Pet com sucesso");
    }

    public void cadastrar(View view){
        EditText editTextNome =
                findViewById(R.id.editTextNomePet);
        EditText editTextIdade =
                findViewById(R.id.editTextIdadePet);
        String nome = editTextNome.getText().toString();
        String idade = editTextIdade.getText().toString();
        if(nome.isEmpty() || idade.isEmpty()){
            Toast.makeText(this,"Preencha os campos",
                    Toast.LENGTH_LONG).show();
            return;
        }
        Pet pet = new Pet();
        pet.nome = nome;
        pet.idade = Integer.parseInt(idade);
        DadosCompartilhados.lista.add(pet);
        Toast.makeText(this,"Cadastro realizado" +
                        " com sucesso.",
                Toast.LENGTH_LONG).show();
        // limpa a tela.
        editTextNome.setText("");
        editTextIdade.setText("");
    }


}