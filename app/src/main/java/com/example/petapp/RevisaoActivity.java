package com.example.petapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RevisaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisao);

    }

    public void validar(View view) {
        EditText editTextNome =
                findViewById(R.id.editTextNomeRevisao);

        EditText editTextIdade =
                findViewById(R.id.editTextIdadeRevisao);

        String nome = editTextNome.getText().toString();
        String idade = editTextIdade.getText().toString();
        if(nome.isEmpty() || idade.isEmpty()){
            Toast.makeText(this, R.string.preencha_campos,
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if(nome.equals("maria") && idade.equals("50")){
            Toast.makeText(this, R.string.acertou_nome_idade,
                    Toast.LENGTH_SHORT).show();
            return;
        }
    }
}