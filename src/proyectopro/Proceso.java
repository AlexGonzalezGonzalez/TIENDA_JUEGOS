/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopro;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author estudios
 */
public class Proceso extends Thread {

    File sonido = new File("stayingAlive.wav");

    /**
     *Instanciamos un objeto de tipo Timer 
     */
    Timer timer;
    /**
     *Constructor de la clase Proceso
     */
    public Proceso() {
        timer = new Timer();
        timer.schedule(new Musica(), 0, 242000);
    }

    /**
     *
     */
    public class Musica extends TimerTask {

        /**
         *
         */
        @Override
        public void run() {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sonido.getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
                Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
