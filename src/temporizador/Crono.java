/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.awt.Color;
import javax.sound.sampled.LineUnavailableException;



/**
 *
 * @author User
 */
public class Crono extends Thread{
    
    private int seconds=0;
    private int minutes=0;
    private int time_break;
    int auxBreak=0;
    private int timeSeconds;
    private int timeMinutes;
    private int rondas;
    private int auxron=0;
    private boolean terminar;
    boolean parar = false;
    Cronometro cr;
    Sonido sound;
            
    public Crono(Cronometro g) throws LineUnavailableException{
        this.cr=g;
        this.terminar = false;
        sound = new Sonido();
    }
    
    
     @Override
    public void run() {
        animar();      
    }
    //separa el String que ingresa para coger el tiempo del temporizador
    void timeTeporiza(String tim,int  descanso,int Nrondas ){
        this.time_break=descanso;
        this.rondas=Nrondas;
        String cad []=tim.split(":");
        this.timeSeconds = Integer.parseInt(cad[1]); 
        this.timeMinutes = Integer.parseInt(cad[0]);
    }
    
    public void animar(){
        cr.setVisible(true);
        while (!terminar){
            cr.getLblImage().setForeground(Color.BLUE);
            cr.getLblImage().setText(auxron+1+"");
            if (parar==false){
                if (auxBreak==0){
                    if (seconds <60){
                    seconds ++;
                    }else{
                        if (seconds==60){
                            seconds=0;
                            minutes++;
                        }
                    }
                    
                    cr.getLblCrono().setForeground(Color.BLACK);
                    cr.getLblCrono().setText(minutes+":"+seconds);
                    if(minutes==timeMinutes && seconds==timeSeconds){
                        minutes=0;
                        seconds=0;
                        auxBreak ++;
                        sound.Break();
                        
                    }
                }else{
                    cr.getLblCrono().setForeground(Color.RED);
                    cr.getLblCrono().setText("Break");
                    
                    if (auxBreak==time_break){
                        auxron++;
                        auxBreak=0;
                        sound.Break();
                    }else{
                        if(time_break-auxBreak <4){
                            sound.tic();
                        }
                        auxBreak++;
                    }
                    if(auxron==rondas){
                        terminar = true;
                        cr.getLblCrono().setText("00:00");
                        sound.finish();
                    } 
                }
            }else{
                
            }
            
            try {
                Crono.sleep(1000);
            }catch(InterruptedException e) {
                System.out.println("Error"+ e);
            }
            
            
        }      
                  
    }
        
}
