package org.example;

import java.util.ArrayList;
import java.util.List;

public class EiendomsRegister {
  private ArrayList<Eiendom> eiendommer = new ArrayList<Eiendom>();

  public void leggTilEiendom(Eiendom eiendom){
    eiendommer.add(eiendom);
  }

  public Eiendom finnEiendom(int kommuneNummer, int gardsNummer, int bruksNummer){
    if (kommuneNummer<101 || kommuneNummer>5054){
      throw  new IllegalArgumentException("Kommune nummer utenfor rekkevidde (fra og med 101 til og med 5054)");
    }
    else if (gardsNummer<1 || bruksNummer<1){
      throw new IllegalArgumentException("Gårdsnummer eller bruksnummer utenfor rekkevidde (må være positivt helttall");
    }
    else {
      String unikEiendomsNummer = kommuneNummer + "-" + gardsNummer + "/" + bruksNummer;
      for (Eiendom eiendom : eiendommer){
        if (eiendom.getID().equals(unikEiendomsNummer)){
          return eiendom;
        }
      }
      return null;
    }
  }

  public void slettEiendom(int kommuneNummer, int gardsNummer, int bruksNummer){
    for (Eiendom eiendom : eiendommer){
      if (finnEiendom(kommuneNummer, gardsNummer, bruksNummer).equals(eiendom)){
        eiendommer.remove(eiendom);
      }
    }
  }

  public int getAntallEiendommer(){
    return eiendommer.size();
  }

  public double regnUtGjennomsnittAreal(){
    double totalAreal=0;
    for (Eiendom eiendom : eiendommer){
      totalAreal+=eiendom.getAreal();
    }

    return totalAreal/ this.getAntallEiendommer();
  }

  public List<Eiendom> finnEiendommerMedGardsnr(int gardsNr){
    ArrayList<Eiendom> eiendommerMedGardsnr = new ArrayList<>();

    for (Eiendom eiendom : eiendommer){
      if (eiendom.getGardsNummer()==gardsNr){
        eiendommerMedGardsnr.add(eiendom);
      }
    }
    return eiendommerMedGardsnr;
  }

  public String toString() {
    StringBuilder eiendomsRegister = new StringBuilder();
    eiendomsRegister.append("Eiendomsregister:\n");
    for (Eiendom eiendom : eiendommer) {
      eiendomsRegister.append(eiendom.toString());
      eiendomsRegister.append("\n");
    }
    return String.valueOf(eiendomsRegister);
  }
}
