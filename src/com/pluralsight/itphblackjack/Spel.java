package com.pluralsight.itphblackjack;

import java.util.Scanner;

public class Spel {

    Scanner sc = new Scanner(System.in);
    Deck spelDeck = new Deck();
    boolean spelerInput = false;
    boolean nieuwspel = false;

//Eerste fase van het spel waarbij de optie is om het geschudde kaartendeck te zien en de eerste twee kaarten getrokken worden
    public void spelFaseEen(){
        boolean keuze = false;

       if(nieuwspel == false){              //zorgt voor welkom bij een nieuw spel
           System.out.println("Welkom bij BlackJack, wilt u het geschudde spelDeck kaarten zien? J/N?");
       }
            else if (nieuwspel == true ){
            System.out.println("U speelt het spel nu opnieuw!");    //Welkom bij replay
           System.out.println("Wilt u wederom het geschudde spelDeck kaarten zien? J / N");
            System.out.println("-----------------------");
            System.out.println();
        }
        while (!keuze) {
            String schudden = sc.nextLine();

            schudden = schudden.toUpperCase();
            spelDeck.schudDeck();
            if (schudden.equals("J")) {

                spelDeck.bekijkDeck();
                System.out.println();
                System.out.println("----------------------------------------");
                keuze = true;
            } else if (schudden.equals("N")) {
                System.out.println("Oké, dan niet!");
                System.out.println("--------------------------------------");
                keuze = true;
            } else {
                System.out.println("U heeft geen gepaste keuze gemaakt!");
               }
        }


        spelDeck.neemKaart();


    }
//tweede fase van het spel waarbij de speler de mogelijkheid krijgt om nog een kaart te trekken, te stoppen of te passen
    public void spelFaseTwee(){
        //while loop die zorgt voor de toetsen pkq

        while (!spelerInput) {
            if (spelDeck.totaalscore < 21 || spelDeck.totaalscore !=21) { //alleen weergave van opties wanneer het spel niet gewonnen of beïndigd is. (spelerinput valt weg zodra er gewonnen of verloren is)
                System.out.println("Wat wilt u nu doen: ");
                System.out.println("Toets p voor pas, toets k voor een nieuwe kaart, toets q om het spel te beïndigen.");
            }

            String volgendeMove = sc.nextLine();
            volgendeMove = volgendeMove.toLowerCase();

            if (volgendeMove.equals("p")) {
                spelerInput = true;
            } else if (volgendeMove.equals("k")) {
                spelDeck.neemKaart();
                spelerInput = true;                    //deze kan eventueel weggehaald worden om meer dan 1 kaart te nemen.
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

            System.out.println();
            System.out.println("-----------------------");
            System.out.println("Wilt u het spel nogmaals spelen? J / N");
            String replay = sc.nextLine();
            replay = replay.toUpperCase();
            if (replay.equals("J")){

                spelDeck.spelReset();
                eindeSpel = false;
                nieuwspel = true;
                spelerInput = false;
                System.out.println("Het spelDeck heeft nu weer " + (spelDeck.deck.size()) + " kaarten!"); // check om te kijken of mijn spelDeck weer 52 kaarten heeft


            }
            else if (replay.equals("N")) {
                eindeSpel = true;   //zorgt ervoor dat ik uit de whileloop kan, waardoor het spel ten einde komt


            }
            else {
                System.out.println("Uw invoer is niet correct, probeer het opnieuw!");
            }



        }
        System.out.println("Het spel is ten einde gekomen!");
    }



}
