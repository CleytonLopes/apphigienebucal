package com.example.apptela;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class SegundaActivity extends AppCompatActivity {

    //iniciando as variáveis
    private Button buttonAnterior1, buttonProximo1;
    private TextView txt_View;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        //Remover sombra do ActionBar(Caso opte)
        //getSupportActionBar().setElevation(0);

        //atribuir variável
        buttonProximo1 = findViewById(R.id.buttonProximo1);
        buttonAnterior1 = findViewById(R.id.buttonAnterior1);
        txt_View = findViewById(R.id.txt_View);

        //adicionando evento de clique próxima tela
        buttonProximo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), TerceiraActivity.class);
                startActivity(intent1);
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
                txt_View.setText(sDuracao);
            }

            @Override
            public void onFinish() {
                //alterando cor ao final da contagem
                buttonProximo1.setBackgroundResource(R.color.teal_700);
                //ocultar visualização de texto
                txt_View.setVisibility(View.GONE);
            }
        }.start();
    }

    //retornando a tela anterior
    public void VoltarTelaAnterior(View view) {
        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent2);
    }
}
