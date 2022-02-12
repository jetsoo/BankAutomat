package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // ideen?= option um zu sehen ob owner account schon besteht und das konto dem hinzufügen
    // pensionistenkarte childclass erstellen, difference to normal?
    // mehr unterschiede noch zwischen kartenTyp einbauen?



    public static void main(String[] args) {
        Random random = new Random();

        Owner alexOtto = new Owner("Alexander","Otto", LocalDate.of(1995,2,17), 238934L);
        Owner fredWarner = new Owner("Fred","Warner", LocalDate.of(1976,7,8), 389729L);
        Owner melissaWurzer = new Owner("Melissa","Wurzer",LocalDate.of(1986,9,28),894375L);
        Owner zachWilson = new Owner("Zach", "Wilson",LocalDate.of(1998,3,14),234731L);

        Konto alex = new BankomatKarte(18945L,6000,alexOtto,2894);
        Konto fred = new KreditKarte(234671L,35000,fredWarner,4893);
        Konto melissa = new JugendKarte(872341L,2000,melissaWurzer,8723);
        Konto zach = new KreditKarte(345920L,50000,zachWilson,6969);
        Konto zach2 = new BankomatKarte(598235L,10000,zachWilson,9878);

        ArrayList<Konto> kontoListe= new ArrayList<>();
        kontoListe.add(alex);
        kontoListe.add(fred);
        kontoListe.add(melissa);
        kontoListe.add(zach);
        kontoListe.add(zach2);

        Scanner scanner = new Scanner(System.in);
        int actionsCount = 0; // 5 aktionen erlaubt

        while(actionsCount < 5){
            System.out.println("Herzlich willkommen! Wählen Sie eine der folgenden Optionen:\n" +
                    "1 Einzahlung  2 Abhebung  3 Infos  4 Konto erstellen  5 Geld bewegen");
            int optionWahl = scanner.nextInt();


            switch (optionWahl){
                case 1: // EINZAHLUNG
                    System.out.println("Wählen Sie ein Konto zur Einzahlung");
                    for(int i = 0; i < kontoListe.size(); i++){
                        System.out.print(i + " " + kontoListe.get(i).getOwner().getFullName() + " " + kontoListe.get(i).getTyp() + "\t");
                    }
                    System.out.println("");
                    int kontoWahl = scanner.nextInt() ;

                    System.out.println("Betrag einzahlen");
                    int geldEingabe = scanner.nextInt();
                    kontoListe.get(kontoWahl).addMoney(geldEingabe);
                    System.out.println("Neuer Kontostand von " + kontoListe.get(kontoWahl).getOwner().getFullName() + " beträgt "
                    + kontoListe.get(kontoWahl).getMoney());
                    break;

                case 2: // ABHEBUNG
                    System.out.println("Wählen Sie ein Konto zur Abhebung");
                    for(int i = 0; i < kontoListe.size(); i++){
                        System.out.print(i + " " + kontoListe.get(i).getOwner().getFullName() + " " + kontoListe.get(i).getTyp() + "\t");
                    }
                    System.out.println("");
                    int kontoWahl2 = scanner.nextInt() ;
                    while(!kontoListe.get(kontoWahl2).getGesperrt()){
                        System.out.println("Password eingeben");
                        int passwordEingabe = scanner.nextInt();

                        if(passwordEingabe == kontoListe.get(kontoWahl2).getPassword()){
                            System.out.println("Betrag zur Abhebung eingeben");
                            int geldAusgabe = scanner.nextInt();

                            if(kontoListe.get(kontoWahl2).canRemove(geldAusgabe)){
                                kontoListe.get(kontoWahl2).removeMoney(geldAusgabe);
                                System.out.println("Neuer Kontostand von " + kontoListe.get(kontoWahl2).getOwner().getFullName() + " beträgt "
                                        + kontoListe.get(kontoWahl2).getMoney() + "€");
                                break;
                            }
                            else{
                                System.out.println("Betrag zu hoch! Versuchen Sie es erneut.");
                            }
                        }
                        else{
                            kontoListe.get(kontoWahl2).setPasswordVersuche(kontoListe.get(kontoWahl2).getPasswordVersuche() +1);
                            if(kontoListe.get(kontoWahl2).getPasswordVersuche() >= 3){
                                kontoListe.get(kontoWahl2).setGesperrt(true);
                                System.out.println("Karte gesperrt !");
                                break;
                            }
                            else {
                                System.out.println("Password falsch ! Sie haben noch " + (3 - kontoListe.get(kontoWahl2).getPasswordVersuche()) + " Versuche");
                            }
                        }

                    }
                    if(kontoListe.get(kontoWahl2).getGesperrt()){
                        System.out.println("Karte gesperrt, bitte wenden Sie sich an einen Schalter");
                    }
                    break;

                case 3: // INFOS
                    System.out.println("Wählen Sie ein Konto für Infos");
                    for(int i = 0; i < kontoListe.size(); i++){
                        System.out.print(i + " " + kontoListe.get(i).getOwner().getFullName() + " " + kontoListe.get(i).getTyp() + "\t");
                    }
                    System.out.println("");
                    int kontoWahl3 = scanner.nextInt() ;
                    System.out.println(kontoListe.get(kontoWahl3).toString());
                    break;

                case 4: // NEUES KONTO ERSTELLEN
                    scanner.nextLine();
                    System.out.println("Vorname eingeben");
                    Owner newOwner = new Owner();
                    newOwner.setVorName(scanner.nextLine());
                    System.out.println("Nachname eingeben");
                    newOwner.setNachName(scanner.nextLine());
                    System.out.println("Geburtstag eingeben in format YYYY MM DD");
                    newOwner.setGeburtstag(LocalDate.of(scanner.nextInt(), scanner.nextInt(),scanner.nextInt()));
                    newOwner.setKundenNr(random.nextLong(999999L));

                    System.out.println("Kontoart wählen: ");
                    System.out.println("1 Kreditkarte  2 Bankomatkarte  3 Jugendkarte");
                    int kontoartWahl = scanner.nextInt();
                    switch(kontoartWahl){
                        case 1:
                            System.out.println("Password erstellen im Format XXXX , nur Ziffern erlaubt");
                            int newPassword = scanner.nextInt();
                            Konto newKonto = new KreditKarte(235789L,0,newOwner,newPassword);
                            kontoListe.add(newKonto);
                            System.out.println("Konto mit Kreditkarte erstellt");
                            System.out.println(newKonto.toString());
                            break;

                        case 2:
                            System.out.println("Password erstellen im Format XXXX , nur Ziffern erlaubt");
                            int newPassword2 = scanner.nextInt();
                            Konto newKonto2 = new BankomatKarte(345982L,0,newOwner,newPassword2);
                            kontoListe.add(newKonto2);
                            System.out.println("Konto mit Bankomatkarte erstellt");
                            System.out.println(newKonto2.toString());
                            break;

                        case 3:
                            System.out.println("Password erstellen im Format XXXX , nur Ziffern erlaubt");
                            int newPassword3 = scanner.nextInt();
                            Konto newKonto3 = new JugendKarte(345982L,0,newOwner,newPassword3);
                            kontoListe.add(newKonto3);
                            System.out.println("Konto mit Jugendkarte erstellt");
                            System.out.println(newKonto3.toString());
                            break;
                    }
                case 5: // MOVE MONEY
                    System.out.println("Wählen Sie ein Konto zur Abhebung");
                    for(int i = 0; i < kontoListe.size(); i++){
                        System.out.print(i + " " + kontoListe.get(i).getOwner().getFullName() + " " + kontoListe.get(i).getTyp() + "\t");
                    }
                    System.out.println("");
                    int kontoAbhebung = scanner.nextInt();
                    while(!kontoListe.get(kontoAbhebung).getGesperrt()){
                        System.out.println("Password eingeben:");
                        int passwordEingabe = scanner.nextInt();

                        if(passwordEingabe == kontoListe.get(kontoAbhebung).getPassword()){
                            System.out.println("Betrag zur Abhebung eingeben");
                            int geldAbhebung = scanner.nextInt();

                            if(kontoListe.get(kontoAbhebung).canRemove(geldAbhebung)){
                                kontoListe.get(kontoAbhebung).removeMoney(geldAbhebung);
                                System.out.println("Neuer Kontostand von " + kontoListe.get(kontoAbhebung).getOwner().getFullName() + " beträgt "
                                        + kontoListe.get(kontoAbhebung).getMoney() + "€");

                                System.out.println("Wählen Sie ein Konto zur Einzahlung");
                                for(int i = 0; i < kontoListe.size(); i++){
                                    System.out.print(i + " " + kontoListe.get(i).getOwner().getFullName() + " " + kontoListe.get(i).getTyp() + "\t");
                                }
                                System.out.println("");
                                int kontoEinzahlung = scanner.nextInt();
                                kontoListe.get(kontoEinzahlung).addMoney(geldAbhebung);
                                System.out.println("Neuer Kontostand von " + kontoListe.get(kontoEinzahlung).getOwner().getVorName() + " beträgt "
                                + kontoListe.get(kontoEinzahlung).getMoney() + "€");
                                break;
                            }
                            else{
                                System.out.println("Betrag zu hoch, versuchen Sie es erneut");
                            }
                        }
                        else{
                            kontoListe.get(kontoAbhebung).setPasswordVersuche(kontoListe.get(kontoAbhebung).getPasswordVersuche() +1);
                            if(kontoListe.get(kontoAbhebung).getPasswordVersuche() >= 3){
                                kontoListe.get(kontoAbhebung).setGesperrt(true);
                                System.out.println("Karte gesperrt !");
                                break;
                            }
                            else {
                                System.out.println("Password falsch ! Sie haben noch " + (3 - kontoListe.get(kontoAbhebung).getPasswordVersuche()) + " Versuche");
                            }
                        }
                    }
                if(kontoListe.get(kontoAbhebung).getGesperrt()){
                    System.out.println("Karte gesperrt! Bitte wenden Sie sich an einen Schalter");
                }

            }

        actionsCount++;
            System.out.println("\n");
        }

















    }
}
