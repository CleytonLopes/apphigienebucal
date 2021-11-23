package com.example.apptela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OitavaActivity extends AppCompatActivity{

    //iniciando as variáveis
    private Button buttonRecomecar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oitava);

        //Remover sombra do ActionBar(Caso opte)
        //getSupportActionBar().setElevation(0);


        //atribuir variável
        buttonRecomecar = findViewById(R.id.buttonRecomecar);

        //adicionando evento de clique próxima tela
        buttonRecomecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player.mediaPlayer.stop();
                Player.mediaPlayer.release();
                Player.mediaPlayer = null;
                Intent intent12 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent12);

            }
        });
    }
    // Sair do aplicativo
    public void SairTela1(View vi){
        Player.mediaPlayer.stop();
        Player.mediaPlayer.release();
        Player.mediaPlayer = null;
        finishAffinity();
        System.exit(0);
    }
}