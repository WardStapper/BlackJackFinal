package com.pluralsight.itphblackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    String[] type = {"Harten", "Ruiten", "Schoppen", "Klaveren"};
    String[] kaart = {"Aas", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Boer", "Koningin", "Koning"};
    ArrayList<Kaart> deck = new ArrayList<>();
    ArrayList<Kaart> hand = new ArrayList<>();
    //Deckconstructor, zodra het spel begint (waarbij het deck aangemaakt wordt in de main) zal deze worden aangeroepen. Vult mijn deckarraylist hierboven met kaarten.
    public Deck() {

        for (String t : type) {
            for (String k : kaart) {


                Kaart nieuw = new Kaart(t, k); //zorgt ervoor dat er in kaart mijn kaarten een waarde krijgen.
                deck.add(nieuw); //vult mijn deck met objecten type kaart
            }
        }
        System.out.println(deck.size()); //checkup om te zien of er daadwerkelijk 52 kaarten zijn in mn deck.

    }
    //Schudden van mijn deck, collections functie.
    public void schudDeck(){

        Collections.shuffle(deck);
        System.out.println();

    }
    public void bekijkDeck(){
        for (int a = 0; a < deck.size(); a++) {
            System.out.println(deck.get(a).type + " " + deck.get(a).kaart);

        }
    }

    //neemt de eerste kaart (2 kaarten met een lege hand) van de bovenkant van het deck
    //verwijderd de getrokken kaart uit het deck
    //voegt de getrokken kaart toe aan de hand
    public void neemKaart() {

        if(hand.size() < 2){
            System.out.println("U heeft de volgende kaarten getrokken: ");
            hand.add(deck.get(0));                                      //kaart toevoegen aan de hand
            System.out.println(deck.get(0).type + " " + deck.get(0).kaart); //uitprinten  eerste getrokken kaart deck
            deck.remove(0);                                     //verwijderen eerste kaart van het deck
            System.out.println(deck.get(0).type + " " + deck.get(0).kaart); //tonen tweede getrokken kaart deck

             }
             else {
            System.out.println("U heeft de volgende kaart getrokken: ");
            System.out.println(deck.get(0).type + " " + deck.get(0).kaart);
        }


        hand.add(deck.get(0));


        deck.remove(0);
        bekijkHand();
        handScore();



    }
    //Weergave van type en kaart van mijn objecten in de hand.
    public void bekijkHand(){

        System.out.println("U heeft dit in uw hand: ");


        for (int b = 0; b <hand.size(); b++){
                System.out.println(hand.get(b).type + " " + hand.get(b).kaart);
            }

        }

        //Weergave van de score van de kaarten in de hand.
       //Zorgt ervoor dat, zodra de score over de 21 gaat de aas score van 11 zal veranderen naar 1.
        //
        public int handScore(){
            int totaalscore =0;

            System.out.println("Uw totaalscore is momenteel: ");

        for (int i = 0; i <hand.size(); i++){               //loopt over de hand heen en zet de kaarten om in een score, telt deze bij elkaar op
          //  System.out.println(hand.get(i).waarde);
          totaalscore += hand.get(i).waarde;
          if (totaalscore >21){
              for (int h = 0; h<hand.size();h++){ //loopt over de hand heen, bekijkt of er een aas in de hand zit
                  if (hand.get(h).Aas == true){
                      hand.get(h).waarde = 1; //zet waarde van de aas om in 1
                      totaalscore -= 10; //zorgt ervoor dat er 10 van de score af gaat
                      hand.get(h).Aas = false;
                      System.out.println("Uw aas is veranderd naar een 1!"); //check
                      break;
                  }
              } //Bij geen aas in de hand en toch >21, spelverlies
              System.out.println(totaalscore + ", helaas, u heeft verloren!");
              System.exit(0);

          }
          else if(totaalscore ==21) { //spelwinst
              System.out.println("Gefeliciteerd, u heeft gewonnen!");
              System.exit(0);
          }



        }
        System.out.println(totaalscore);
                        return totaalscore;


        }


    }





