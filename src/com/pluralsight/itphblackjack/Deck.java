package com.pluralsight.itphblackjack;

import java.util.ArrayList;
import java.util.Collections;
//Deck klasse, 2 String arrays met daarin de kaart en het type kaart.
//Aanmaak 2 ArrayLists om spelDeck en handkaarten in onder te brengen

public class Deck {
    String[] type = {"Harten", "Ruiten", "Schoppen", "Klaveren"};
    String[] kaart = {"Aas", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Boer", "Koningin", "Koning"};
    ArrayList<Kaart> deck = new ArrayList<>();
    ArrayList<Kaart> hand = new ArrayList<>();
    int totaalscore =0;
    //Deckconstructor, zodra het spel begint (waarbij het spelDeck aangemaakt wordt in de main) zal deze worden aangeroepen. Vult mijn deckarraylist hierboven met kaarten.
    public Deck() {

        for (String t : type) {
            for (String k : kaart) {


                Kaart nieuw = new Kaart(t, k); //maakt objecten type kaart aan, met als kenmerken type en kaart van mijn arrays.
                deck.add(nieuw); //vult mijn spelDeck met objecten type kaart
            }
        }
        System.out.println("Er zitten momenteel " + deck.size() + " kaarten in het spelDeck!"); //checkup om te zien of er daadwerkelijk 52 kaarten zijn in mn spelDeck.

    }
    //Schudden van mijn spelDeck, collections functie.
    public void schudDeck(){

        Collections.shuffle(deck);
        System.out.println();

    }

    //loopt door het spelDeck heen en print uit welke kaart op welke positie zit.
    public void bekijkDeck(){
        for (int a = 0; a < deck.size(); a++) {
            System.out.println(deck.get(a).type + " " + deck.get(a).kaart);

        }
    }

    //neemt de eerste kaart (2 kaarten met een lege hand) van de bovenkant van het spelDeck
    //verwijderd de getrokken kaart uit het spelDeck
    //voegt de getrokken kaart toe aan de hand
    public void neemKaart() {

        if(hand.size() < 2){
            System.out.println("U heeft de volgende kaarten getrokken: ");
            for(int p = 0; p < 2; p++){
                hand.add(deck.get(0));                                      //kaart toevoegen aan de hand
                System.out.println(deck.get(0).type + " " + deck.get(0).kaart); //uitprinten  eerste en tweede getrokken kaart uit spelDeck.
                deck.remove(0);                                     //verwijderen eerste kaart van het spelDeck
            }

             }
             else {
            System.out.println("U heeft de volgende kaart getrokken: ");
            System.out.println(deck.get(0).type + " " + deck.get(0).kaart);
            hand.add(deck.get(0));
            deck.remove(0);
        }



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
        public int handScore() {

            int totaalscore = 0;


            for (int i = 0; i < hand.size(); i++) {               //loopt over de hand heen en zet de kaarten om in een score, telt deze bij elkaar op
                //  System.out.println(hand.get(i).waarde);

                totaalscore += hand.get(i).waarde;
                if (totaalscore > 21) {
                    for (int h = 0; h < hand.size(); h++) { //loopt over de hand heen, bekijkt of er een aas in de hand zit
                        if (hand.get(h).Aas == true) {
                            hand.get(h).waarde = 1; //zet waarde van de aas om in 1
                            totaalscore -= 10; //zorgt ervoor dat er 10 van de score af gaat
                            hand.get(h).Aas = false;
                            System.out.println("Uw aas is veranderd naar een 1!"); //check
                            break;
                        } else if (totaalscore > 21) {          //Bij geen aas in de hand en toch >21, spelverlies
                            System.out.println(totaalscore + ", helaas, u heeft verloren!");
                            spelReset();        //reset het spel alvast voor een eventueel volgende ronde


                        }

                    }

                } else if (totaalscore == 21) { //spelwinst
                    System.out.println("Gefeliciteerd, u heeft gewonnen met " + totaalscore + " punten!");  //Weergave score met winst
                    spelReset();

                }


            }
            if (totaalscore != 21 && totaalscore < 21) {
                System.out.println("U heeft een totaalscore van: " + totaalscore); //weergave totaalscore}

            }
            return totaalscore;
        }

    public void spelReset() {                        //terugstoppen van de kaarten in het spelDeck, conceptueel

        int handSize = hand.size();             //zet de handsize vóór reset vast, zodat ik deze kan gebruiken voor het resetten van mijn spelDeck (anders krimpt de handsize mee tijdens de forloop -> 51 kaarten ipv 52)

        for (int r = 0; r < handSize; r++) {

            deck.add(hand.get(0));
            hand.remove(0);


        }
        totaalscore = 0;


    }

    }








