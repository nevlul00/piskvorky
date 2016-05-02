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
        hrac1 = new Hrac(jmeno, Znaky.krizek); // hrac jedna bude mit automaticky koelcko
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
        hrac2 = new Hrac(jmeno, Znaky.kolecko);
        return hrac2;
    }

    public void setPrvniHraje(Hrac hrac) {
        jeNaRade = hrac;
    }

    public void udelejTah(int x, int y) {
       /* if (hraciPlocha[x][y] != null) {
            throw new Exception("Tady už nesmíš hrát");
        }*/
        hraciPlocha[x][y] = jeNaRade;
        if (jeNaRade == hrac1) {
            jeNaRade = hrac2;
        } else {
            jeNaRade = hrac1;
        }
    }
    
   /* public void pocetZnaku(){
        int [][] pole = null;
        for (int i = 0; i < hraciPlocha.length -5; i++) {
            for (int j = 0; j < hraciPlocha.length -5; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                    pole [i+k][j+l] = "O";
                }
            } for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        pole [j+l][i+k] = "O";
                    }
        }
        
    }*/
    
    
    /*
    prohledavani pole - vuci konci hry 
    pole 5*5, ktere bude prohledavat radky, sloupce, potom pokud bude v jednom z hornich rohu znak
    bude prohledavat i pohled sikmo
    */
}
