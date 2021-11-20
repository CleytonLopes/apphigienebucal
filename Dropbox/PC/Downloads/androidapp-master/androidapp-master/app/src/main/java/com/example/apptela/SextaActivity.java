package com.example.apptela;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SextaActivity extends AppCompatActivity {

    //iniciando as variáveis
    private Button buttonAnterior5, buttonProximo5;
    private TextView txt_View5;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexta);

        //Remover sombra do ActionBar(Caso opte)
        //getSupportActionBar().setElevation(0);

        buttonAnterior5 = findViewById(R.id.buttonAnterior5);
        buttonProximo5 = findViewById(R.id.buttonProximo5);
        txt_View5 = findViewById(R.id.txt_View5);

        //adicionando evento de clique próxima tela
        buttonProximo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 = new Intent(getApplicationContext(), SetimaActivity.class);
                startActivity(intent8);
            }
        });
    }

    @Override
    protected void onStart() {

        super.onStart();
        //iniciando tempo de duração
        long duracao = TimeUnit.SECONDS.toMillis(11);
        //inicializar cronômetro de contagem regressiva
        new CountDownTimer(duracao, 1000) {
            @Override
            public void onTick(long l) {
                //converter milissegundo em minuto e segundo
                String sDuracao = String.format(Locale.ENGLISH, "%02d : %02d", TimeUnit.MILLISECONDS.toMinutes(l),
                        TimeUnit.MILLISECONDS.toSeconds(l) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                //definir string de conversão na visualização de texto
                txt_View5.setText(sDuracao);
            }

            @Override
            public void onFinish() {
                //alterando cor ao final da contagem
                buttonProximo5.setBackgroundResource(R.color.teal_700);
                //ocultar visualização de texto
                txt_View5.setVisibility(View.GONE);
            }
        }.start();
    }

    //retornando a tela anterior
    public void VoltarTelaAnterior4(View view) {
        Intent intent9 = new Intent(getApplicationContext(), QuintaActivity.class);
        startActivity(intent9);
    }
}