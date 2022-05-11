/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ahilis
 */
public class Putanja {
    
    //zapis u datoteci
//        <putanja>
//            <putanjaOd>o1</putanjaOd>
//            <opis>Privat</opis>    
//            <putanjaDo>o2</putanjaDo>
//        </putanja>
    
    SOP sop;
    String strPutanjaOd;
    String strPutanjaOpis;
    String strPutanjaDo;

    public Putanja(SOP sop, String strPutanjaOd, String strPutanjaOpis, String strPutanjaDo) {
        this.sop = sop;
        this.strPutanjaOd = strPutanjaOd;
        this.strPutanjaOpis = strPutanjaOpis;
        this.strPutanjaDo = strPutanjaDo;
    }

    public SOP getSop() {
        return sop;
    }

    public void setSop(SOP sop) {
        this.sop = sop;
    }

    public String getStrPutanjaOd() {
        return strPutanjaOd;
    }

    public void setStrPutanjaOd(String strPutanjaOd) {
        this.strPutanjaOd = strPutanjaOd;
    }

    public String getStrPutanjaOpis() {
        return strPutanjaOpis;
    }

    public void setStrPutanjaOpis(String strPutanjaOpis) {
        this.strPutanjaOpis = strPutanjaOpis;
    }

    public String getStrPutanjaDo() {
        return strPutanjaDo;
    }

    public void setStrPutanjaDo(String strPutanjaDo) {
        this.strPutanjaDo = strPutanjaDo;
    }
}
