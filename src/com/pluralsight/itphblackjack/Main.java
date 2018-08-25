package com.pluralsight.itphblackjack;

import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
           Deck deck = new Deck();
           boolean gevraagd = false;
           boolean gepast = false;
           boolean keuze = false;

    System.out.println("Welkom bij BlackJack, wilt u het geschudde deck kaarten zien? J/N?");
//hile loop die vraagt of de speler het geschudde deck wil zien.
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
            keuze = true;
        } else {
            System.out.println("U heeft geen gepaste keuze gemaakt!");
            System.out.println("Wilt u het geschudde deck kaarten zien? J/N?");
        }
    }


    deck.neemKaart();

    //while loop die zorgt voor de toetsen pkq
    while (!gevraagd && !gepast) {
        System.out.println("Wat wilt u nu doen: ");
        System.out.println("Toets p voor pas. ");
        System.out.println("Toets k voor kaart. ");
        System.out.println("Toets q om het spel te beïndigen");

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
            System.out.println("Uw invoer is niet correct, probeer het openieuw!");
        }


    }
        System.out.println("Het spel is ten einde gekomen!");
  }


}
























       /*     //Schudden
            for (int i = 0; i < n; i++) {
                int r = i + (int) (Math.random() * (n-i));
                String random = deck[r];
                deck[r] = deck[i];
                deck[i] = random;
            }

            // print shuffled deck
            for (int i = 0; i < n; i++) {
                System.out.println(deck[i]);
            }
        }

    }
    }




        class Deck{

        void kaartInDeck() {
            ArrayList arrayList = new ArrayList();
        }

        void kaartAanmaak(){
            String kaartNaam;
            String kaartType;
            String

        }
    }
    }
*/
