package com.pluralsight.itphblackjack;

import java.util.Scanner;

public class Spel {

    Scanner sc = new Scanner(System.in);
    Deck deck = new Deck();
    boolean gevraagd = false;
    boolean gepast = false;
    boolean nieuwspel = false;


    public void spelFaseEen(){
        boolean keuze = false;

       if(nieuwspel == false){              //zorgt voor welkom bij een nieuw spel
           System.out.println("Welkom bij BlackJack, wilt u het geschudde deck kaarten zien? J/N?");
       }
            else if (nieuwspel == true ){
            System.out.println("U speelt het spel nu opnieuw!");    //Welkom bij replay
           System.out.println("Wilt u wederom het geschudde deck kaarten zien? J / N");
            System.out.println("-----------------------");
            System.out.println();
        }
        while (!keuze) {
            String schudden = sc.nextLine();

            schudden = schudden.toUpperCase();
            deck.schudDeck();
            if (schudden.equals("J")) {

                deck.bekijkDeck();
                System.out.println();
                System.out.println("----------------------------------------");
                keuze = true;
            } else if (schudden.equals("N")) {
                System.out.println("Oké, dan niet!");
                System.out.println("--------------------------------------");
                keuze = true;
            } else {
                System.out.println("U heeft geen gepaste keuze gemaakt!");
                System.out.println("Wilt u het geschudde deck kaarten zien? J/N?");
            }
        }


        deck.neemKaart();


    }

    public void spelFaseTwee(){
        //while loop die zorgt voor de toetsen pkq
        while (!gevraagd && !gepast) {
            System.out.println("Wat wilt u nu doen: ");
            System.out.println("Toets p voor pas, toets k voor een nieuwe kaart, toets q om het spel te beïndigen.");

            String volgendeMove = sc.nextLine();
            volgendeMove = volgendeMove.toLowerCase();

            if (volgendeMove.equals("p")) {
                gepast = true;
            } else if (volgendeMove.equals("k")) {
                deck.neemKaart();
                gevraagd = true;                    //deze kan eventueel weggehaald worden om meer dan 1 kaart te nemen.
            } else if (volgendeMove.equals("q")) {
                System.out.println("Oké, jammer het spel sluit nu af!");
                System.exit(0);
            } else {
                System.out.println("Uw invoer is niet correct, probeer het opnieuw!");
            }


        }

    }

    public void volledigSpel(){
        boolean eindeSpel = false;
        while (!eindeSpel){
            spelFaseEen();
            spelFaseTwee();
          //  while ()
            System.out.println();
            System.out.println("-----------------------");
            System.out.println("Wilt u het spel nogmaals spelen? J / N");
            String replay = sc.nextLine();
            replay = replay.toUpperCase();
            if (replay.equals("J")){

                deck.spelReset();
                eindeSpel = false;
                nieuwspel = true;
                gevraagd = false;
                System.out.println("Het deck is nu weer");
                System.out.println(deck.deck.size());

            }
            else if (replay.equals("N")) {
                System.out.println("Oké, jammer het spel sluit nu af!");
                eindeSpel = true;
               // System.exit(0);

            }
            else {
                System.out.println("Uw invoer is niet correct, probeer het opnieuw!");
            }



        }
    }



}