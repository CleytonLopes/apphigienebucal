package com.example.apptela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetimaActivity extends AppCompatActivity{

    //iniciando as variáveis
    private Button buttonAnterior6, buttonConcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setima);

        //Remover sombra do ActionBar (Caso opte)
        //getSupportActionBar().setElevation(0);

        //atribuir variável
        buttonAnterior6 = findViewById(R.id.buttonAnterior6);
        buttonConcluir = findViewById(R.id.buttonConcluir);

        //adicionando evento de clique próxima tela
        buttonConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent10 = new Intent(getApplicationContext(), OitavaActivity.class);
                startActivity(intent10);
            }
        });
    }

    //retornando a tela anterior
    public void VoltarTelaAnterior5(View view) {
        Intent intent11 = new Intent(getApplicationContext(), SextaActivity.class);
        startActivity(intent11);

    }
}