/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGame;
import InterfaceOfGame.*;
import gametoanhoc.GameToanHoc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author Developer Android
 */
public class MainClassOfGame {
    
    private static  int diem=0;
    private static int soDiem=0;
    private static int temb2=1;
    
    
    public static void main(String[] args) {
        MainInterFaceOfGame mainInterFaceOfGame = new MainInterFaceOfGame();
        Random r = new Random();
        Random r2 = new Random();
        Random r3 = new Random();
        GameToanHoc  gameToanHoc =new GameToanHoc();
        mainInterFaceOfGame.setLocationRelativeTo(null);
        mainInterFaceOfGame.setVisible(true);
        DialogOfEndGame dialogOfEndGame = new DialogOfEndGame();
        String[] strArr = new String[2];
        strArr[0]="+";
        strArr[1]="-";
        int hh=0;
        while (temb2==1) {  
           
            diem=-1;
            while (diem==-1) {         
            gameToanHoc.setSoA(r.nextInt(51));
            gameToanHoc.setSoB(r2.nextInt(51));
            gameToanHoc.setDau(strArr[r3.nextInt(2)]);
            
            mainInterFaceOfGame.jButtonSoA.setText(String.valueOf(gameToanHoc.getSoA()));
            mainInterFaceOfGame.jButtonSoB.setText(String.valueOf(gameToanHoc.getSoB()));
            mainInterFaceOfGame.jButtonDau.setText(String.valueOf(gameToanHoc.getDau()));
            int temb=r3.nextInt(2);
            if(temb==0){
                gameToanHoc.setKetQua(r.nextInt(101));
            }else{
                gameToanHoc.setKetQua(gameToanHoc.dapAn());
            }
            mainInterFaceOfGame.jButtonDapAn.setText(String.valueOf(gameToanHoc.getKetQua()));
            
            diem=0;
            
            mainInterFaceOfGame.jButtonChecker.setText(String.valueOf(soDiem));           
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    mainInterFaceOfGame.jButtonDung.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        if(gameToanHoc.kiemTra()){
                            diem=-1;  
                        }
                        
                    }
                    });       
                } 
            });
            
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    mainInterFaceOfGame.jButtonSai.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(!gameToanHoc.kiemTra()){
                            diem=-1; 
                        }
                    };       
                }); 
                }
            });

            thread.start();
            thread1.start();
            System.out.println(diem);
            try {
                        Thread.sleep(3000);
                        
                } catch (InterruptedException ex) {
                        System.out.println("Error");
            }
            
            if(diem==-1){
                    soDiem++;
                    continue;
            }else{
                    mainInterFaceOfGame.jButtonChecker.setText("0");
                    mainInterFaceOfGame.jButtonSoA.setText("0");
                    mainInterFaceOfGame.jButtonSoB.setText("0");
                    mainInterFaceOfGame.jButtonDapAn.setText("0");
                    mainInterFaceOfGame.jButtonDau.setText("+");
                    temb2=0;
                    break;    
            }
            
            
                }
            
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                   dialogOfEndGame.setLocationRelativeTo(null);
                   dialogOfEndGame.setVisible(true);
                   dialogOfEndGame.jButtonCo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        temb2=1;
                        dialogOfEndGame.setVisible(false);
                    }
                    });    
                }
            });
            thread2.start();
            for (int i = 1; i <= 5; i++) {
                dialogOfEndGame.jLabelTime.setText(String.valueOf(i));
                if(temb2==1){
                    continue;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.toString());
                }
            }
            dialogOfEndGame.setVisible(false);
            
            
        }
        
    }
    
}
