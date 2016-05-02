/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_projekt_pisk;

import oop_projekt_pisk.GUI.Gui;


/**
 *
 * @author Lucie
 */
public class OOP_projekt_pisk {

     
    public static void main(String[] args) {
        Hra piskvorky = new Hra(20,5);
        Hrac hrac1 = piskvorky.setHrac1("Lucka");
        piskvorky.setHrac2("Pavel");
        piskvorky.setPrvniHraje(hrac1);
        Gui hlavniOkno = new Gui(piskvorky);
        hlavniOkno.vykresleni();
        
    }
    
}
