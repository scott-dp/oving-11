package org.example;


/**
 * Eiendom.java
 * Klasse for å representere en eiendom
 * felt bruksnavn og eiernavn kan endres fordi en bolig kan bytte eier og bruksnavn bestemmes av eier og kan dermed forandres
 */
public class Eiendom {
  private final int kommuneNr;//101-5054
  private final String kommuneNavn;
  private final int gardsNummer;
  private final int bruksNummer;
  private String bruksnavn;
  private final double areal;
  private String eiernavn;

  public Eiendom(int kommuneNr, String kommuneNavn, int gardsNummer, int bruksNummer, double areal, String eiernavn, String bruksnavn){
    if (kommuneNr<101 || kommuneNr>5054){
      throw  new IllegalArgumentException("Kommune nummer utenfor rekkevidde (fra og med 101 til og med 5054)");
    }
    else if (gardsNummer<1 || bruksNummer<1){
      throw new IllegalArgumentException("Gårdsnummer eller bruksnummer utenfor rekkevidde (må være positivt helttall");
    }
    else if(areal<=0){
      throw new IllegalArgumentException("Areal for lavt");
    }
    else {
      this.kommuneNr = kommuneNr;
      this.kommuneNavn = kommuneNavn;
      this.gardsNummer = gardsNummer;
      this.bruksNummer = bruksNummer;
      this.areal = areal;
      this.eiernavn = eiernavn;
      this.bruksnavn = bruksnavn;
    }
  }

  //konstruktør uten bruksnavn
  public Eiendom(int kommuneNr, String kommuneNavn, int gardsNummer, int bruksNummer, double areal, String eiernavn){
    if (kommuneNr<101 || kommuneNr>5054){
      throw  new IllegalArgumentException("Kommune nummer utenfor rekkevidde (fra og med 101 til og med 5054)");
    }
    else if (gardsNummer<1 || bruksNummer<1){
      throw new IllegalArgumentException("Gårdsnummer eller bruksnummer utenfor rekkevidde (må være positivt helttall");
    }
    else if(areal<=0){
      throw new IllegalArgumentException("Areal for lavt");
    }
    else {
      this.kommuneNr = kommuneNr;
      this.kommuneNavn = kommuneNavn;
      this.gardsNummer = gardsNummer;
      this.bruksNummer = bruksNummer;
      this.areal = areal;
      this.eiernavn = eiernavn;
    }
  }

  public int getKommuneNr(){
    return kommuneNr;
  }

  public String getKommuneNavn(){
    return kommuneNavn;
  }

  public int getGardsNummer(){
    return gardsNummer;
  }

  public int getBruksNummer(){
    return bruksNummer;
  }

  public String getBruksnavn(){
    return bruksnavn;
  }

  public double getAreal(){
    return areal;
  }

  public String getEiernavn(){
    return eiernavn;
  }

  //bruksnavn kan endres
  public void setBruksnavn(String bruksnavn){
    this.bruksnavn = bruksnavn;
  }

  //eiernavn kan endres
  public void setEiernavn(String eiernavn){
    this.eiernavn = eiernavn;
  }

  public String getID(){
    return kommuneNr + "-" + gardsNummer + "/" + bruksNummer;
  }

  @Override
  public String toString(){
    return "Kommunenr: "+kommuneNr + " gårdsnr: "+gardsNummer+ " bruknr: "+bruksNummer+" eies av: "+eiernavn + " areal: "+areal;
  }

}
