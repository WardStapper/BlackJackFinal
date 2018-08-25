package com.pluralsight.itphblackjack;
//Klasse Kaart
public class Kaart {

    String type;
    String kaart;
    int waarde;
    boolean Aas = false;
    //Kaartconstructor
//Aanmaak kaart waarde, veranderen van de 'stringwaarden' van mn object in een daadwerkelijke int 'waarde' zodat ik de score kan bijhouden.
    public Kaart(String t, String k){

        type = t;
        kaart = k;
        if(kaart.equals("Aas")){

            waarde = 11;
            Aas = true; //Zorgt ervoor dat ik weet dat er een aas in de hand is (zodat ik die later kan wisselen voor een 1)
        }

        else if(kaart.equals("Boer") || kaart.equals("Koningin") || kaart.equals("Koning")){
            waarde = 10;
        }
        else{
            waarde = Integer.parseInt(kaart);
        }

    }

 }

