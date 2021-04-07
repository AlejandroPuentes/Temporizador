/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.awt.Color;



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
    Cronometro cr;
            
    public Crono(Cronometro g){
        this.cr=g;
        this.terminar = false;
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
            if (auxBreak==0){
                if (seconds <60){
                seconds ++;
                }else{
                    if (seconds==60){
                        seconds=0;
                        minutes++;
                    }
                }
                if(minutes==timeMinutes && seconds==timeSeconds){
                    minutes=0;
                    seconds=0;
                    auxBreak ++;
                }
                cr.getLblCrono().setForeground(Color.BLACK);
                cr.getLblCrono().setText(minutes+":"+seconds);
            }else{
                cr.getLblCrono().setForeground(Color.RED);
                cr.getLblCrono().setText(minutes+":"+seconds);
                if (auxBreak==time_break){
                    auxron++;
                    auxBreak=0;
                }else{
                    
                    auxBreak++;
                }
                if(auxron==rondas){
                    terminar = true;
                    cr.getLblCrono().setText("00:00");
                } 
            }
            try {
                Crono.sleep(1000);
            }catch(InterruptedException e) {
                System.out.println("Error"+ e);
            }
            
            
        }      
                  
    }
        
}
