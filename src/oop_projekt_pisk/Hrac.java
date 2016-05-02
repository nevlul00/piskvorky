/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_projekt_pisk;

import java.awt.Color;

/**
 *
 * @author Lucie
 */
public class Hrac {     //třída, která přiřadí hráči jméno a daný barva(X/O)

    private String jmeno;
    private int skore;
    private Color barva;

    public Hrac(String jmenoVstup, Color znakVstup) {    //Konstruktor, který vytvoří hráče s daným jménem a znakem
        jmeno = jmenoVstup;
        barva = znakVstup;
        skore = 0;
    }

    public Color getBarva() {
        return barva;
    }
}
