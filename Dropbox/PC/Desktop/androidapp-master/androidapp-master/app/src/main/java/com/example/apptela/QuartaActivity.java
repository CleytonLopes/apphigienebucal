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

public class QuartaActivity extends AppCompatActivity {
    //iniciando as variáveis
    private Button buttonAnterior3, buttonProximo3;
    private TextView txt_View3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarta);

        //Remover sombra do ActionBar(Caso opte)
        //getSupportActionBar().setElevation(0);

        //atribuir variável
        buttonAnterior3 = findViewById(R.id.buttonAnterior3);
        buttonProximo3 = findViewById(R.id.buttonProximo3);
        txt_View3 = findViewById(R.id.txt_View3);

        //adicionando evento de clique próxima tela
        buttonProximo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getApplicationContext(), QuintaActivity.class);
                startActivity(intent5);
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
                txt_View3.setText(sDuracao);
            }

            @Override
            public void onFinish() {
                //alterando cor ao final da contagem
                buttonProximo3.setBackgroundResource(R.color.teal_700);
                //ocultar visualização de texto
                txt_View3.setVisibility(View.GONE);
            }
        }.start();
    }

    //retornando a tela anterior
    public void VoltarTelaAnterior2(View view) {
        Intent intent4 = new Intent(getApplicationContext(), TerceiraActivity.class);
        startActivity(intent4);
    }
}