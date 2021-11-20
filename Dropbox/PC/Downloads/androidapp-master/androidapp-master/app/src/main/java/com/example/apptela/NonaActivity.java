package com.example.apptela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NonaActivity extends AppCompatActivity{

    //iniciando as variáveis
    private Button buttonPaginaInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nona);

        //Remover sombra do ActionBar(Caso opte)
        //getSupportActionBar().setElevation(0);

        //atribuir variável
        buttonPaginaInicial = findViewById(R.id.buttonPaginaInicial);

        //adicionando evento de clique próxima tela
        buttonPaginaInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player.mediaPlayer.stop();
                //Player.mediaPlayer.release();
                Player.mediaPlayer = null;
                Intent intent16 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent16);
            }
        });
    }
}