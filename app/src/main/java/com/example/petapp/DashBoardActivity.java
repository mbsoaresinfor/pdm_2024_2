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

import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity {

    ArrayList<Pet> listaPet = new ArrayList<Pet>();


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
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista_pet",listaPet);
        Intent intent = new Intent(this,
                        CadastroPetActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void listagemPet(View view) {
        // abre a Activity de listagem
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista_pet",listaPet);
        Intent intent = new Intent(this,
                ListagemPetActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void atualizarPet(View view) {
        // abre a Activity de atualizacao
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista_pet",listaPet);
        Intent intent = new Intent(this,
                AtualizarPetActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void removerPet(View view) {
        // abre a Activity de remocao
        Intent intent = new Intent(this,
                RemoverPetActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista_pet",listaPet);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}