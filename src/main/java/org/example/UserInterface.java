package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class UserInterface {
  Scanner sc = new Scanner(System.in);
  EiendomsRegister register = new EiendomsRegister();
  private final int ADD_PROPERTY = 1;
  private final int LIST_ALL_PROPERTIES = 2;
  private final int FIND_PROPERTY = 3;
  private final int CALCULATE_AVERAGE_AREA = 4;
  private final int EXIT = 9;
  private int showMenu()
  {
    int menuChoice = 0;
    System.out.println("\n***** Property Register Application v0.1 *****\n");
    System.out.println("1. Add property");
    System.out.println("2. List all properties");
    System.out.println("3. Search property");
    System.out.println("4. Calculate average area");
    System.out.println("9. Quit");
    System.out.println("\nPlease enter a number between 1 and 9.\n");
    if (sc.hasNextInt()) {
      menuChoice = sc.nextInt();
    } else {
      System.out.println("You must enter a number, not text");
    }
    return menuChoice;
  }

  public Eiendom inputNyEiendom() {
    System.out.println("Skriv inn kommune nummer mellom 101 og 5054");
    sc.nextLine();
    String kommuneNr = sc.nextLine();
    int kommuneNrInt = verifyInt(kommuneNr);

    if (kommuneNrInt == -1) {
      System.out.println("Cannot convert kommunenr to int");
      return null;
    }

    System.out.println("Skriv inn kommune navn");
    String kommuneNavn = sc.nextLine();

    System.out.println("Skriv inn gårdsnummer");
    String gardsNr = sc.nextLine();

    int gardsNrInt = verifyInt(gardsNr);

    if (gardsNrInt == -1) {
      System.out.println("Cannot convert gårdsnr to int");
      return null;
    }

    System.out.println("Skriv inn bruksnummer");
    String bruksNr = sc.nextLine();

    int bruksNrInt = verifyInt(bruksNr);

    if (bruksNrInt == -1) {
      System.out.println("Cannot convert bruksnr to int");
      return null;
    }

    System.out.println("Skriv inn areal");
    String areal = sc.nextLine();
    double arealDouble;
    if (canConvertToDouble(areal)) {
      arealDouble = Double.parseDouble(areal);
    } else {
      return null;
    }

    System.out.println("Skriv inn eier navn");
    String eierNavn = sc.nextLine();

    System.out.println("Vil du også legge inn bruksnavn? (\"skriv y for ja\"");

    Eiendom nyEiendom;

    if (sc.nextLine().equals("y")) {

      System.out.println("Skriv inn bruksnavn");
      String bruksNavn = sc.nextLine();

      try {
        nyEiendom = new Eiendom(kommuneNrInt, kommuneNavn, gardsNrInt, bruksNrInt, arealDouble, eierNavn, bruksNavn);
      } catch (Exception e) {
        System.out.println("verdiene lagt inn ikke innenfor grense");
        return null;
      }
    }
    else {
      try {
        nyEiendom = new Eiendom(kommuneNrInt, kommuneNavn, gardsNrInt, bruksNrInt, arealDouble, eierNavn);

      } catch (Exception e) {
        System.out.println("verdiene lagt inn ikke innenfor grense");
        return null;
      }

    }
    return nyEiendom;
  }

  public Eiendom finnEiendomEtterId(){//burde vært i register
    System.out.println("SKriv inn kommunbeNumer");
    sc.nextLine();
    String kommuneNr=sc.nextLine();

    int KommuneNrINt=verifyInt(kommuneNr);

    if (KommuneNrINt==-1){
      System.out.println("Kan ikke konvertere til int");
      return null;
    }

    System.out.println("Skriv inn gårds nummer");
    String gardsNr=sc.nextLine();
    int gardsNrInt = verifyInt(gardsNr);

    if (gardsNrInt==-1){
      System.out.println("kan ikke konertere til int");
      return null;
    }

    System.out.println("Skriv inn bruks nummer");
    String bruksNr=sc.nextLine();
    int bruksNrInt = verifyInt(bruksNr);

    if (bruksNrInt==-1){
      System.out.println("kan ikke konertere til int");
      return null;
    }

    try{
      Eiendom funneteiendom = register.finnEiendom(KommuneNrINt,gardsNrInt,bruksNrInt);
      return funneteiendom;
    }catch(Exception e){
      System.out.println("Input stemme ikke med retningslinjer");
      return null;
    }

  }


  public void start() {
    boolean finished = false;
// The while-loop will run as long as the user has not selected
// to quit the application
    while (!finished) {
      int menuChoice = this.showMenu();
      switch (menuChoice) {
        case ADD_PROPERTY:
          Eiendom nyEiendom = inputNyEiendom();
          if (nyEiendom!=null){
            register.leggTilEiendom(nyEiendom);
          }else{
            System.out.println("kunne ikke legge til eiendom");
          }
          break;

        case LIST_ALL_PROPERTIES:
          System.out.println(register.toString());
          break;

        case FIND_PROPERTY:
          Eiendom eiendomFunnet = finnEiendomEtterId();

          if(eiendomFunnet!=null){
            System.out.println(eiendomFunnet);
          }
          break;

        case CALCULATE_AVERAGE_AREA:
          System.out.println(register.regnUtGjennomsnittAreal());
          break;
        case EXIT:
          System.out.println("Thank you for using the Properties app!\n");
          finished = true;
          break;
        default:
          System.out.println("Unrecognized menu selected..");
          break;
      }
    }
  }

  public int verifyInt(String var){
    int varInt;
    try{
      varInt=Integer.parseInt(var);
    }catch(Exception e){
      return -1;
    }
    return varInt;
  }

  public boolean canConvertToDouble(String var){
    try{
      double varDbl = Double.parseDouble(var);
    }catch(Exception e){
      return false;
    }
    return true;
  }

}