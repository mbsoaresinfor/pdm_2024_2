package com.example.petapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void logar(View view) {
        // pegando os componentes da interface grafica e colocando
        // aqui no Java.
        EditText login = findViewById(R.id.editTextLogin);
        EditText senha = findViewById(R.id.editTextSenha);

        // pegando o conteudo da caixa de login
        String conteudoLogin = login.getText().toString();
        // pegando o conteudo da caixa de senha
        String conteudoSenha = senha.getText().toString();

        if(conteudoLogin.isEmpty()){
            Toast.makeText(this, "Preencha o campo login",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if(conteudoSenha.isEmpty()){
            Toast.makeText(this, "Preencha o campo senha",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if(conteudoLogin.equals("admin") && conteudoSenha.equals("123")){
            // abrindo o dashboard
            Intent intent = new Intent(this,DashBoardActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Usuario ou senha inválida", Toast.LENGTH_SHORT).show();
            return;
        }




    }
}