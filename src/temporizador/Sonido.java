/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

/**
 *
 * @author User
 */

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;


public class Sonido {
    Clip clip;
    public Sonido() throws LineUnavailableException{
        clip = AudioSystem.getClip();
    }
    public void Break(){
        try {
            AudioInputStream breakS = AudioSystem
            .getAudioInputStream(new File("src/sonidos/break.wav").getAbsoluteFile());
            clip.open(breakS);
                clip.start();
                Thread.sleep(1000);
            clip.close();
        } catch (Exception e) {
            System.out.println("Error al reproducir el sonido.");
        }
    }
    public void finish(){
        try {
            AudioInputStream finishS = AudioSystem
            .getAudioInputStream(new File("src/sonidos/finish.wav").getAbsoluteFile());
            clip.open(finishS);
                clip.start();
                Thread.sleep(2500);
            clip.close();
        } catch (Exception e) {
            System.out.println("Error al reproducir el sonido.");
        }
    }
    public void tic(){
        try {
            AudioInputStream ticS = AudioSystem
            .getAudioInputStream(new File("src/sonidos/tic.wav").getAbsoluteFile());
            clip.open(ticS);
                clip.start();
                Thread.sleep(170);
            clip.close();
        } catch (Exception e) {
            System.out.println("Error al reproducir el sonido.");
        }
    }
    
}
