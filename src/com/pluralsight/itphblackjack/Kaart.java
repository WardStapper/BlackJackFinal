package com.pluralsight.itphblackjack;

import java.util.ArrayList;

public class Kaart {

    String[] type = {"Harten", "Ruiten","Schoppen", "Klaveren"};String[] kaart = {"Aas", "2", "3", "4", "5", "6", "7", "8", "9", "10",
               "Boer", "Koningin", "Koning"};

    int totaal = type.length * kaart.length; //52 kaarten

    String[] deck= new String[totaal]; //aanmaak array kaarten

        public Kaart() {

                for (int i = 0; i < kaart.length; i++) {
                    for (int j = 0; j < type.length; j++) {
                        deck[type.length * i + j] = type[j]+ " " + kaart[i]  ; //4 geswithced naar type.length.
                        System.out.println(type[j] + " " + kaart [i]);
                        System.out.println("----------------------------");

                        //   1. een deck moet definieren
                        //   2. een 'stack' moet maken waar je kaarten (in een willekeurige volgorde) aan toevoegt.
                        //   3. kaarten van die stack kunnen 'poppen' als je ze aan een persoon geeft, en kunnen 'pushen' als ze in het deck gestoipt worden (met schudden bijvoorbeeld)

                }
            }
        }
        public void kaartenSchudden() {

            for (int i = 0; i < totaal; i++) {
                int r = i + (int) (Math.random() * (totaal - i));
                String random = deck[r];
                deck[r] = deck[i];
                deck[i] = random;
                System.out.println(deck[i]);
                System.out.println("---------GESCHUD----------");
            }
        }
}
