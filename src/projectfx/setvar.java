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
public class setvar {
    Date date;
    String images;

    public setvar(Date date, String images) {
        this.date = date;
        this.images = images;
    }

    setvar(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Date getDate() {
        return date;
    }

    public String getImages() {
        return images;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setImages(String images) {
        this.images = images;
    }
    
    
    
    
}
