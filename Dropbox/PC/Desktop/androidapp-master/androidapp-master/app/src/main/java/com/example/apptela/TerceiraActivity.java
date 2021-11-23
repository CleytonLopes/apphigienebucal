package com.example.apptela;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TerceiraActivity extends AppCompatActivity {

    //iniciando as variáveis
    private Button buttonAnterior2, buttonProximo2;
    private TextView txt_View2;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        //Remover sombra do ActionBar(Caso opte)
        //getSupportActionBar().setElevation(0);

        //atribuir variável
        buttonAnterior2 = findViewById(R.id.buttonAnterior2);
        buttonProximo2 = findViewById(R.id.buttonProximo2);
        txt_View2 = findViewById(R.id.txt_View2);

        //adicionando evento de clique próxima tela
        buttonProximo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), QuartaActivity.class);
                startActivity(intent3);
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
                txt_View2.setText(sDuracao);
            }

            @Override
            public void onFinish() {
                //alterando cor ao final da contagem
                buttonProximo2.setBackgroundResource(R.color.teal_700);
                //ocultar visualização de texto
                txt_View2.setVisibility(View.GONE);
            }
        }.start();
    }

    //retornando a tela anterior
    public void VoltarTelaAnterior1(View view) {
        Intent intent4 = new Intent(getApplicationContext(), SegundaActivity.class);
        startActivity(intent4);
    }
}