package org.example;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Sonido {
    public Clip clip;


    public void cargarSonido(String ruta) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File sonido=new File(ruta);
        AudioInputStream audio= AudioSystem.getAudioInputStream(sonido);
        clip=AudioSystem.getClip();
        clip.open(audio);
    }
    public void reproducir(){
        if(clip!=null){
            clip.setFramePosition(0);
            clip.start();
        }
    }
}