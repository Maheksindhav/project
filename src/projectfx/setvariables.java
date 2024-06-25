/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfx;

import java.sql.Date;

/**
 *
 * @author mahek
 */
public class setvariables {

    private int ino;
    private String custnm;
     private String  mno;
    private int drs;
    private float gst, tam;
    String payment;

    public setvariables(int ino, String custnm, String mno, int drs, float gst, float tam, String payment) {
        this.ino = ino;
        this.custnm = custnm;
        this.mno = mno;
        this.drs = drs;
        this.gst = gst;
        this.tam = tam;
        this.payment = payment;
    }

    public int getIno() {
        return ino;
    }

    public String getCustnm() {
        return custnm;
    }

    public String getMno() {
        return mno;
    }

    public int getDrs() {
        return drs;
    }

    public float getGst() {
        return gst;
    }

    public float getTam() {
        return tam;
    }

    public String getPayment() {
        return payment;
    }

    public void setIno(int ino) {
        this.ino = ino;
    }

    public void setCustnm(String custnm) {
        this.custnm = custnm;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public void setDrs(int drs) {
        this.drs = drs;
    }

    public void setGst(float gst) {
        this.gst = gst;
    }

    public void setTam(float tam) {
        this.tam = tam;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    
    

  

   
}
