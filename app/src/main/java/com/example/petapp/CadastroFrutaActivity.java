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

import java.util.ArrayList;

public class CadastroFrutaActivity extends AppCompatActivity {

    ArrayList<Fruta> listaFruta = new ArrayList<Fruta>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_fruta);
    }

    public void salvarFruta(View view) {

        EditText caixaNomeFruta = findViewById(R.id.editTextNomeFruta);
        EditText caixaPrecoFruta = findViewById(R.id.editTextPrecoFruta);

        String nomeFruta = caixaNomeFruta.getText().toString();
        String precoFruta = caixaPrecoFruta.getText().toString();

        if(nomeFruta.isEmpty() || precoFruta.isEmpty()){
            Toast.makeText(this,"preencha todos os campos",Toast.LENGTH_LONG).show();
            return;
        }
        Fruta fruta = new Fruta();
        fruta.nome = nomeFruta;
        fruta.preco = Double.parseDouble(precoFruta);
        listaFruta.add(fruta);

        Toast.makeText(this,"sucesso !!",Toast.LENGTH_LONG).show();

    }
}