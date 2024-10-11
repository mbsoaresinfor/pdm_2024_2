package com.example.petapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    public void remover(View view) {
        EditText editText = findViewById(R.id.editTextIdPet);
        String idString = editText.getText().toString();
        try {
            Integer id = Integer.parseInt(idString);
            boolean resultado =DadosCompartilhados.lista
                    .removeIf(obj -> obj.id.equals(id));
            if(resultado){
                Toast.makeText(this,"Remoção realizado" +
                                " com sucesso.",
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"nâo encontrado id",
                        Toast.LENGTH_LONG).show();
            }

        }catch(Exception e){
            Toast.makeText(this,"digite somente numeros",
                    Toast.LENGTH_LONG).show();
            return;
        }


    }
}