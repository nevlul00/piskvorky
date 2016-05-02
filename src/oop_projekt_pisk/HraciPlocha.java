/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_projekt_pisk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author Lucie
 */
public class HraciPlocha extends JPanel {

    private Hra logika;
    private int velikostPolicka = 25;

    public HraciPlocha(Hra logika) {
        this.logika = logika;
        Dimension rozmery = new Dimension(logika.getVelikostHraciPlochy() * velikostPolicka, logika.getVelikostHraciPlochy() * velikostPolicka);
        setPreferredSize(rozmery);
        addMouseListener(new PosluchacTahu());

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < logika.getVelikostHraciPlochy(); x++) {
            for (int y = 0; y < logika.getVelikostHraciPlochy(); y++) {
                Hrac pole = logika.getPole(x, y);
                if (pole != null) {
                    g.setColor(pole.getBarva());
                    g.fillOval(x * velikostPolicka+2, y * velikostPolicka+2, velikostPolicka-4, velikostPolicka-4);
                }
                g.setColor(Color.black);
                g.drawRect(x * velikostPolicka, y * velikostPolicka, velikostPolicka, velikostPolicka);
            }
        }

    }

    public class PosluchacTahu extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX() / velikostPolicka;
            int y = e.getY() / velikostPolicka;
            logika.udelejTah(x, y);
            repaint(); /// prekresleni cele hraci plochy
        }
    }

}
