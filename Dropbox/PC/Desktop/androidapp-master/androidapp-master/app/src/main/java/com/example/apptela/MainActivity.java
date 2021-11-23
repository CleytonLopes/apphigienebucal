package com.example.apptela;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    //iniciando as variáveis
    private Button buttonAvancar, buttonCreditos, buttonSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Remover sombra do ActionBar(Caso opte)
        //getSupportActionBar().setElevation(0);
        Player.create(getApplicationContext());
        Player.mediaPlayer.start();

        //atribuir variável
        buttonAvancar = findViewById(R.id.buttonAvancar);
        buttonCreditos = findViewById(R.id.buttonCreditos);
        buttonSair = findViewById(R.id.buttonSair);

        //adicionando evento de clique próxima tela
        buttonAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);
                startActivity(intent);
            }
        });
    }

    //Tela de créditos
    public void UltimaTela(View v) {
        Intent intent15 = new Intent(getApplicationContext(), NonaActivity.class);
        startActivity(intent15);
    }

    // Sair do aplicativo
    public void SairTela(View v){
        Player.mediaPlayer.stop();
        Player.mediaPlayer.release();
        Player.mediaPlayer = null;
        finishAffinity();
        System.exit(0);
    }


    public void pararMusica(View vie){
        Player.mediaPlayer.stop();
    }

    /*//Iniciando butão de remover som
    // um clique muta a música
    // clicando novamente irá ativar a música
    public void buttonMute(View view){
        if (Player.mute) {
            Player.mediaPlayer.setVolume(0,0);
            Player.mute = false;
        } else{
            Player.mediaPlayer.setVolume(1,1);
            Player.mute = true;
        }
    }*/
}