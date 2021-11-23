package com.example.apptela;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Player {
    // instanciar do player de aúdio
     static MediaPlayer mediaPlayer;
     //variavel para guardar a informação sobre o volume
     static boolean mute = false;

    /**
     * @param context
     * Método para criar instancia de player de aúdio
     */
     //Método para criar instancia
     static void create(Context context){
         //Chamada da música
         mediaPlayer = MediaPlayer.create(context,R.raw.musicafundo);
         //Define tipo de mídia
         mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
     }


}
