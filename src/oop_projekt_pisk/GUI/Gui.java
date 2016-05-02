/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_projekt_pisk.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import oop_projekt_pisk.Hra;

/**
 *
 * @author Lucie
 */
public class Gui {

    Hra logika;
    int velikostPolicka = 30;
    JFrame hlavniOkno;

    public Gui(Hra logika) {
        this.logika = logika;
    }

    public void vykresleni() {
        hlavniOkno = new JFrame("Piškvorky");
        //super("Piškvorky");
        
        Gui_nastaveni nastaveni = new Gui_nastaveni();
        hlavniOkno.add(nastaveni);
        
        nastaveni.setVisible(false);
        
        Gui_hra guiHra = new Gui_hra(logika);
        hlavniOkno.add(guiHra);
        
        hlavniOkno.pack();   // uspusobeni komponentum vevnitr
        
        //hlavniOkno.setSize(600, 700);
        // hlavniOkno.setPreferredSize(new Dimension(700, 700));
        
        hlavniOkno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // vypnuti app po zavreni okna)
        hlavniOkno.setResizable(false);  // nemuze zvetsovat/zmensovat pole
        hlavniOkno.setLocationRelativeTo(null); // da se do stredu obrazovky
        hlavniOkno.setVisible(true);
    }

        
}
