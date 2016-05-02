/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_projekt_pisk;

/**
 *
 * @author Lucie
 */
public class Hrac {     //třída, která přiřadí hráči jméno a daný znak(X/O)

    private String jmeno;
    private int skore;
    private Znaky znak;

    public Hrac(String jmenoVstup, Znaky znakVstup) {    //Konstruktor, který vytvoří hráče s daným jménem a znakem
        jmeno = jmenoVstup;
        znak = znakVstup;
        skore = 0;
    }

    public Znaky getZnak() {
        return znak;
    }
}
