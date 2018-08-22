package com.pluralsight.itphblackjack;

public class Kaart {

    String type;
    String kaart;
    int waarde;

    public Kaart(String t, String k){

        type = t;
        kaart = k;


    }

    void kaartWaarde() {
        if(kaart.length() <= 2){
            waarde = Integer.parseInt(kaart);
        }
        else if (kaart.equals("Aas"))
        { waarde = 11; }
        else
        {waarde = 10;}

    }
}
