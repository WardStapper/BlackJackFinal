package com.pluralsight.itphblackjack;


    public class Main {
        public static void main(String[] args) {


            
          Spel spel = new Spel();
          System.out.println("Welkom bij BlackJack, wilt u het geschudde deck kaarten zien? J/N?");
          spel.spelFaseEen();
          spel.spelFaseTwee();



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
