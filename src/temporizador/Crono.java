/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import javax.swing.JOptionPane;

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
    private boolean parar=true;
            
            
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
        while (parar){
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
                System.out.println(minutes+":"+seconds);
            }else{
                System.out.println("descanso"+minutes+":"+seconds);
                if (auxBreak==time_break){
                    auxron++;
                    auxBreak=0;
                }else{
                    
                    auxBreak++;
                }
                if(auxron==rondas){
                    parar=false;
                    //JOptionPane.showMessageDialog(null, "HA TERMINADO TU TIEMPO");
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
