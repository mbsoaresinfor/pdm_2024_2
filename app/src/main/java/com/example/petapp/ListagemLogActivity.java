package com.example.petapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class ListagemLogActivity extends AppCompatActivity {

    RepositorioLog repositorioLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_log);
        repositorioLog = new RepositorioLog(this);


    }

    public void buscarLogs(View view) {
        String usuario = buscarUsuarioTela();
        buscarEAtualizaDadosTela(usuario);
    }

    private String buscarUsuarioTela(){
        EditText editTextUsuario = findViewById(R.id.editTextUsuario);
        String usuario = null;
        if(!editTextUsuario.getText()
                .toString().isEmpty()){
            usuario =editTextUsuario.getText().toString();
        }
        return usuario;
    }
    private void buscarEAtualizaDadosTela(String usuario){
        List<Log> lista = repositorioLog
                .listarLogs(usuario);
        String[] dados = new String[lista.size()];
        // passando da lista para o vetor.
        for(int i=0; i < lista.size();i++){
            Log log = lista.get(i);
            dados[i] = log.usuario + "\n" + log.data + " - "  +log.operacao;
        }
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        dados);
        ListView listView = findViewById(R.id.listViewLog);
        listView.setAdapter(adapter);
    }

    public void remover(View view) {
        repositorioLog.
                removerLogUsuario(DadosCompartilhados.usuarioLogado);
        String usuario = buscarUsuarioTela();
        buscarEAtualizaDadosTela(usuario);
    }
}