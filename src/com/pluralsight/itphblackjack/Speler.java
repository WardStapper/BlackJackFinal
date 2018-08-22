package com.pluralsight.itphblackjack;

public class Speler {


    public Speler(){


    }

    public  void hand(){

        String[] handKaart

    }

    public int getScore(){
        int score = 0;
        for( kaart in hand){
            switch(kaart){
                case "Aas": score += 1;
                break;
                case "Twee": score +=2;
                break;
                case "Drie": score +=3;
                break;
                case "Vier": score +=4;
                break;
                case "Vijf": score +=5;

            }
        }

    }

}
