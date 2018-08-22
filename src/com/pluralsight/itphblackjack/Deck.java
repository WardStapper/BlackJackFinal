package com.pluralsight.itphblackjack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {
    String[] type = {"Harten", "Ruiten", "Schoppen", "Klaveren"};
    String[] kaart = {"Aas", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Boer", "Koningin", "Koning"};
    ArrayList<Kaart> deck = new ArrayList<>();

    public Deck() {

        for (String t : type) {
            for (String k : kaart) {


                Kaart nieuw = new Kaart(t, k);
                deck.add(nieuw);
            }
        }
        System.out.println(deck.size());

    }

    public void schudDeck(){

        Collections.shuffle(deck);
        System.out.println();

    }
    public void openDeck(){
        for (int a = 0; a < deck.size(); a++) {
            System.out.println(deck.get(a).type + " " + deck.get(a).kaart);

        }
    }


}


