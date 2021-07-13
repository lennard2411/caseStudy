package com.example.casestudy.controller;

public class BetriebsstelleNotFoundException extends RuntimeException{

    BetriebsstelleNotFoundException(String string){
        super("Betriebsstelle " + string + " konnte nicht gefunden werden.");
    }
}
