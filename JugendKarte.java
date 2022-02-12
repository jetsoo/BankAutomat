package com.company;

public class JugendKarte extends Konto{


    public JugendKarte(Long id, Integer money, Owner owner, Integer password) {
        super(id, money, owner, password, 0, 400,Typ.Jugendkarte);
    }



}
