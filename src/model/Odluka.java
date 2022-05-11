/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Ahilis
 */
public class Odluka {
    
    //zapis u datoteci
//    odluka>
//            <odlukaId>o4</odlukaId>
//            <prethodneOdlukeId>o2</prethodneOdlukeId>
//            <sljedeceOdlukeId>m3,m4</sljedeceOdlukeId>
//            <tekstOdluke>Ulaz ili izlaz?</tekstOdluke>
//            <datoteke></datoteke>
//        </odluka>
    
    SOP sop;
    String strOdlukaId;
    ArrayList<String> alPrethodneOdlukeId = new ArrayList<>();
    ArrayList<String> alSljedeceOdlukeId = new ArrayList<>();
    String strTekstOdluke;
    ArrayList<String> alDatoteke = new ArrayList<>();

    public Odluka(String strOdlukaId, String strTekstOdluke, String strPrethodneOdlukeId, String strSljedeceOdlukeId, String strDatoteke) {
        this.strOdlukaId = strOdlukaId;
        this.strTekstOdluke = strTekstOdluke;
        this.alPrethodneOdlukeId = pretvoriStringUListu(strPrethodneOdlukeId);
        this.alSljedeceOdlukeId = pretvoriStringUListu(strSljedeceOdlukeId);
        this.alDatoteke = pretvoriStringUListu(strDatoteke);
        
    }

    public SOP getSop() {
        return sop;
    }

    public void setSop(SOP sop) {
        this.sop = sop;
    }

    public String getStrOdlukaId() {
        return strOdlukaId;
    }

    public void setStrOdlukaId(String strOdlukaId) {
        this.strOdlukaId = strOdlukaId;
    }

    public ArrayList<String> getAlPrethodneOdlukeId() {
        return alPrethodneOdlukeId;
    }

    public void setAlPrethodneOdlukeId(ArrayList<String> alPrethodneOdlukeId) {
        this.alPrethodneOdlukeId = alPrethodneOdlukeId;
    }

    public ArrayList<String> getAlSljedeceOdlukeId() {
        return alSljedeceOdlukeId;
    }

    public void setAlSljedeceOdlukeId(ArrayList<String> alSljedeceOdlukeId) {
        this.alSljedeceOdlukeId = alSljedeceOdlukeId;
    }

    public String getStrTekstOdluke() {
        return strTekstOdluke;
    }

    public void setStrTekstOdluke(String strTekstOdluke) {
        this.strTekstOdluke = strTekstOdluke;
    }

    public ArrayList<String> getAlDatoteke() {
        return alDatoteke;
    }

    public void setAlDatoteke(ArrayList<String> alDatoteke) {
        this.alDatoteke = alDatoteke;
    }
    
    /**
     * pretvaranje stringa u al
     * @param string
     * @return 
     */
    ArrayList<String> pretvoriStringUListu(String string){
        ArrayList<String> alListaStringova = new ArrayList<>();
        alListaStringova.addAll(Arrays.asList(string.split(",")));
    
        return alListaStringova;
    }
    
    

}
