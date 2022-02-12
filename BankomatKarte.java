package com.company;


public class BankomatKarte extends Konto{


    public BankomatKarte(Long id, Integer money, Owner owner, Integer password) {
        super(id, money, owner, password, -2000, 2000,Typ.Bankomatkarte);
    }

}
