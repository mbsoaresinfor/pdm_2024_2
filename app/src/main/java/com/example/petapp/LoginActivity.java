package com.example.petapp;

import android.content.Intent;
import android.content.res.Resources;
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

import java.util.Arrays;
import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        Resources res = getResources();
        String texto = String.
                format(res
                        .getString(
                                R.string
                                        .teste),
    "abc");
        Log.i("pet",texto);


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

        List<String> listaLogin = Arrays.asList("admin","marcelo","pedro",
                "maria","joao","jose","ines");

        if(listaLogin.contains(conteudoLogin) && conteudoSenha.equals("123")){
            // abrindo o dashboard com parametros
            Bundle bundle = new Bundle();
            bundle.putString("login",conteudoLogin);
            Intent intent = new Intent(this,DashBoardActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);

        }else{
            Toast.makeText(this, "Usuario ou senha inválida", Toast.LENGTH_SHORT).show();
            return;
        }




    }
}