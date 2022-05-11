/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Ahilis
 */
public class SOP {
    
    static ArrayList<SOP> alListaSvihSOP = new ArrayList<>();
    
    String strNaziv;
    String strNazivPDFDatotekeSOPa;
    String strNazivMape;
    ArrayList<Odluka> alListaSvihOdluka = new ArrayList<>();
    ArrayList<Putanja> alListaSvihPutanja = new ArrayList<>();

    public static ArrayList<SOP> getAlListaSvihSOP() {
        return alListaSvihSOP;
    }

    public static void setAlListaSvihSOP(ArrayList<SOP> alListaSvihSOP) {
        SOP.alListaSvihSOP = alListaSvihSOP;
    }

    public String getStrNaziv() {
        return strNaziv;
    }

    public void setStrNaziv(String strNaziv) {
        this.strNaziv = strNaziv;
    }

    public ArrayList<Odluka> getAlListaSvihOdluka() {
        return alListaSvihOdluka;
    }

    public void setAlListaSvihOdluka(ArrayList<Odluka> alListaSvihOdluka) {
        this.alListaSvihOdluka = alListaSvihOdluka;
    }

    public ArrayList<Putanja> getAlListaSvihPutanja() {
        return alListaSvihPutanja;
    }

    public void setAlListaSvihPutanja(ArrayList<Putanja> alListaSvihPutanja) {
        this.alListaSvihPutanja = alListaSvihPutanja;
    }

    public String getStrNazivPDFDatotekeSOPa() {
        return strNazivPDFDatotekeSOPa;
    }

    public void setStrNazivPDFDatotekeSOPa(String strNazivPDFDatotekeSOPa) {
        this.strNazivPDFDatotekeSOPa = strNazivPDFDatotekeSOPa;
    }

    public String getStrNazivMape() {
        return strNazivMape;
    }

    public void setStrNazivMape(String strNazivMape) {
        this.strNazivMape = strNazivMape;
    }
    
    /**
     * @param strOdlukaId
     * @return 
     */
    public ArrayList<Putanja> dajAlListaSljedecihPutanjaZaOdluku(String strOdlukaId){
        ArrayList<Putanja> listaSljedecihPutanja = new ArrayList<>();
        
        for (Putanja putanja : getAlListaSvihPutanja()) {
            if (putanja.getStrPutanjaOd().equals(strOdlukaId)) {
                listaSljedecihPutanja.add(putanja);
            }
        }
        return listaSljedecihPutanja;
    }
    
    /**
     * 
     * @param strOdlukaId
     * @return 
     */
    public ArrayList<Putanja> dajAlListaPrethodnihPutanjaZaOdluku(String strOdlukaId){
        ArrayList<Putanja> listaPrethodnihPutanja = new ArrayList<>();
        
        for (Putanja putanja : getAlListaSvihPutanja()) {
            if (putanja.getStrPutanjaOd().equals(strOdlukaId)) {
                listaPrethodnihPutanja.add(putanja);
            }
        }
        return listaPrethodnihPutanja;
    
    }
    
    /**
     * Vraca odluku po ID-u
     * @param id
     * @return 
     */
    public Odluka dajOdlukuPoID(String id){
        for (Odluka odluka : getAlListaSvihOdluka()) {
            if (odluka.getStrOdlukaId().equals(id)) {
                return odluka;
            }       
        }
        return null;
    }
}
