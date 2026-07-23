package edu.fiuba.algo3.sonido;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicaJuego {

    private static MediaPlayer reproductor;

    public static void iniciar(){

        Media media = new Media(
                MusicaJuego.class
                        .getResource("/sonidos/Mafia.mp3")
                        .toExternalForm()
        );

        reproductor = new MediaPlayer(media);
        reproductor.setCycleCount(MediaPlayer.INDEFINITE);
        reproductor.play();
    }

    public static void detener(){

        if(reproductor != null){
            reproductor.stop();
        }
    }
}
