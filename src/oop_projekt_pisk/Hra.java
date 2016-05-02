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
public class Hra { // logika

    private Hrac[][] hraciPlocha;
    private int vyherniPocet;
    private Hrac hrac1;
    private Hrac hrac2;
    private Hrac jeNaRade;

    public Hra(int velikostHraciPlochy, int vyherniPocet) { // pocet znaku potrebnych 
        hraciPlocha = new Hrac[velikostHraciPlochy][velikostHraciPlochy];
        this.vyherniPocet = vyherniPocet; // this vola ze tridy

    }

    public Hrac getJeNaRade() {
        return jeNaRade;
    }

    /**
     * Vraci velikost hraci plochy.
     *
     * @return pocet sloupcu a radku - pocet policek
     */
    public int getVelikostHraciPlochy() {
        return hraciPlocha.length;
    }

    /**
     *
     * @return Rozmisteni hracu na plose
     */
    public Hrac[][] getHraciPlocha() {
        return hraciPlocha;
    }

    /**
     * Nastaveni jmena hrace1 a prideleni kolecka.
     *
     * @param jmeno
     * @return
     */
    public Hrac setHrac1(String jmeno) {
        hrac1 = new Hrac(jmeno, Color.blue); // hrac jedna bude mit automaticky koelcko
        return hrac1;
    }

    /**
     * Nastaveni jmena hrace2 a prideleni krizku. Hrac dva bude mit automaticky
     * krizek
     *
     * @param jmeno
     * @return
     */
    public Hrac setHrac2(String jmeno) {
        hrac2 = new Hrac(jmeno, Color.red);
        return hrac2;
    }

    public void setPrvniHraje(Hrac hrac) {
        jeNaRade = hrac;
    }

    public void udelejTah(int x, int y) {
        hraciPlocha[x][y] = jeNaRade;
        pocetZnaku();
        if (jeNaRade == hrac1) {
            jeNaRade = hrac2;
        } else {
            jeNaRade = hrac1;
        }
    }

    public Hrac getPole(int x, int y) {
        return hraciPlocha[x][y];
    }

    public void pocetZnaku() {
        for (int y = 0; y < hraciPlocha.length; y++) { // radky
            for (int x = 0; x < hraciPlocha.length; x++) {      // sloupecky
                if (hraciPlocha[x][y] != jeNaRade) {          // kontroluje jen mista, kde hralo kolecko
                    continue;
                }
                if (kontrolaSikmoVpravoDolu(x, y)
                        || kontrolaSikmoVlevoDolu(x, y)
                        || kontrolaDolu(x, y)
                        || kontrolaVPravo(x, y)) {
                    System.out.println("Vyhral jsi!" + jeNaRade.getJmeno());
                }

            }

        }

        /*
    prohledavani pole - vuci konci hry 
    pole 5*5, ktere bude prohledavat radky, sloupce, potom pokud bude v jednom z hornich rohu znak
    bude prohledavat i pohled sikmo
         */
    }

    public boolean kontrolaSikmoVpravoDolu(int x, int y) {
        int pocetZaSebou = 0;
        if (x > hraciPlocha.length - vyherniPocet) {
            return false;
        }
        for (int i = 0; i <= 5; i++) {
            if (hraciPlocha[x + i][y + i] == jeNaRade) {
                pocetZaSebou++;
                if (pocetZaSebou == vyherniPocet) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean kontrolaSikmoVlevoDolu(int x, int y) {
        int pocetZaSebou = 0;
        if (x < vyherniPocet - 1) {
            return false;
        }
        for (int i = 0; i <= 5; i++) {
            if (hraciPlocha[x - i][y + i] == jeNaRade) { // pricitame k y, protže kontroluji smerem dolu !
                pocetZaSebou++;
                if (pocetZaSebou == vyherniPocet) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean kontrolaVPravo(int x, int y) {
        int pocetZaSebou = 0;
        if (x > hraciPlocha.length - vyherniPocet) {
            return false;
        }
        for (int i = 0; i <= 5; i++) {
            if (hraciPlocha[x + i][y] == jeNaRade) { // vyska se nemeni, 
                pocetZaSebou++;
                if (pocetZaSebou == vyherniPocet) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean kontrolaDolu(int x, int y) {
        int pocetZaSebou = 0;       // kontroluje mi to uz for nahore
        if (y > hraciPlocha.length - vyherniPocet) { // radky
            return false;
        }
        for (int i = 0; i <= 5; i++) {
            if (hraciPlocha[x][y + i] == jeNaRade) { // vyska se nemeni, 
                pocetZaSebou++;
                if (pocetZaSebou == vyherniPocet) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
