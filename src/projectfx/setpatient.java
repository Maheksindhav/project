/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfx;

/**
 *
 * @author mahek
 */
public class setpatient {
    int pid;
    String pnm,mobileno,gender;
    int age;
    String city;
    int pincode;
    String doctonm;

    public setpatient(int pid, String pnm, String mobileno, String gender, int age, String city, int pincode, String doctonm) {
        this.pid = pid;
        this.pnm = pnm;
        this.mobileno = mobileno;
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.pincode = pincode;
        this.doctonm = doctonm;
    }

    public int getPid() {
        return pid;
    }

    public String getPnm() {
        return pnm;
    }

    public String getMobileno() {
        return mobileno;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public int getPincode() {
        return pincode;
    }

    public String getDoctonm() {
        return doctonm;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setPnm(String pnm) {
        this.pnm = pnm;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public void setDoctonm(String doctonm) {
        this.doctonm = doctonm;
    }
    
    
    
    
}
