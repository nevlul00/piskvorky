/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_projekt_pisk;

import javax.swing.JButton;

/**
 *
 * @author Lucie
 */
public class HraciPlocha { // jedno tlacitko, plocha cela

    JButton pole;

    private int[][] plocha;
    private int velikost;

    /**
     * 
     * @param velikost 
     */
    public HraciPlocha(int velikost) {
        this.velikost = velikost;
        plocha = new int[velikost][velikost];
        //pole = new JButton();

    }

}
