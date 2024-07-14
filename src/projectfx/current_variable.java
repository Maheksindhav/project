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
public class current_variable {
    float rate;
    Date mfg_date,exp_date;
    String batch;

    public current_variable(float rate, Date mfg_date, Date exp_date, String batch) {
        this.rate = rate;
        this.mfg_date = mfg_date;
        this.exp_date = exp_date;
        this.batch = batch;
    }

    public float getRate() {
        return rate;
    }

    public Date getMfg_date() {
        return mfg_date;
    }

    public Date getExp_date() {
        return exp_date;
    }

    public String getBatch() {
        return batch;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setMfg_date(Date mfg_date) {
        this.mfg_date = mfg_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
    
    
    
    
}
