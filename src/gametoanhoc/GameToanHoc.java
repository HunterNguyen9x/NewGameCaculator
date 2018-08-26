/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametoanhoc;

/**
 *
 * @author Developer Android
 */
public class GameToanHoc {
    private int soA;
    private int soB;
    private String dau;
    private int ketQua;

    
    
    public GameToanHoc(int soA, int soB) {
        this.soA = soA;
        this.soB = soB;

    }

    public GameToanHoc(int soA, int soB, String dau) {
        this.soA = soA;
        this.soB = soB;

        this.dau = dau;
    }
    public int getKetQua() {
        return ketQua;
    }

    public void setKetQua(int ketQua) {
        this.ketQua = ketQua;
    }
    public String getDau() {
        return dau;
    }

    public void setDau(String dau) {
        this.dau = dau;
    }
    
    public GameToanHoc() {
    }

    public int getSoA() {
        return soA;
    }

    public void setSoA(int soA) {
        this.soA = soA;
    }

    public int getSoB() {
        return soB;
    }

    public void setSoB(int soB) {
        this.soB = soB;
    }

    
    public int  dapAn(){
        if(dau.equals("+")){
            return soA+soB;
        }else{
            return soA-soB;
        }
    }
    public boolean kiemTraCong(){
        if(this.soA+this.soB == this.ketQua){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean kiemTraTru(){
        if(this.soA+this.soB == this.ketQua){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean kiemTra(){
        if(dau.equals("+")){
            return kiemTraCong();
        }else{
            return kiemTraTru();
        }
    }
    
}
