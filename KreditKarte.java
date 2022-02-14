package com.company;

import java.time.LocalDate;

public class KreditKarte extends Konto{
 


    public KreditKarte(Long id, Integer money, Owner owner, Integer password) {
        super(id, money, owner, password, -10000, 5000,Typ.Kreditkarte);
    }


}
