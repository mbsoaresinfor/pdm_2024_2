package com.example.petapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        // pegando os dados do pai
        String login = (String) getIntent().getSerializableExtra("login");
        Toast.makeText(this, "Bem-vindo: " + login,
                Toast.LENGTH_SHORT).show();
        setTitle("DashBoard");
    }

    public void cadastroPet(View view) {
        // abre a Activity de cadastro
        Intent intent = new Intent(this,CadastroPetActivity.class);
        startActivity(intent);
    }

    public void listagemPet(View view) {
        // abre a Activity de listagem
        Intent intent = new Intent(this,ListagemPetActivity.class);
        startActivity(intent);
    }
}