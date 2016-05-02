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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import oop_projekt_pisk.Hra;
import oop_projekt_pisk.Hrac;
import oop_projekt_pisk.Znaky;

/**
 *
 * @author Lucie
 */
public class Gui_hra extends JPanel {

    int velikostPolicka = 30;
    Hra logika;
    JButton[][] pole;
    //naplnit pole tlacitkama

    private int prvni;
    private int druhe;

    public Gui_hra(Hra logika) {
        this.logika = logika;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        vykresliNabidku();
        vykresliHraciPlochu();
    }

    private void vykresliHraciPlochu() {
        pole = new JButton[logika.getVelikostHraciPlochy()][logika.getVelikostHraciPlochy()];
        int velikost = logika.getVelikostHraciPlochy();
        JPanel hraciPole = new JPanel();
        hraciPole.setLayout(new GridLayout(velikost, velikost)); // pro tlacitka
        //hraciPole.setMaximumSize(new Dimension(500,500));
        add(hraciPole);
        Dimension rozmery = new Dimension(logika.getVelikostHraciPlochy() * velikostPolicka, logika.getVelikostHraciPlochy() * velikostPolicka);
        hraciPole.setPreferredSize(rozmery);

        Border ohraniceni = BorderFactory.createLineBorder(Color.black);
        Hrac[][] hraciPlocha = logika.getHraciPlocha();
        for (int x = 0; x < velikost; x++) {
            for (int y = 0; y < hraciPlocha[x].length; y++) {
                JButton tl = new JButton();
                //tl.setSize(velikostPolicka, velikostPolicka);
                tl.setBorder(ohraniceni);
                tl.setBackground(Color.white);
                hraciPole.add(tl);
                pole[x][y] = tl;       // najdu konkretni policko
                prvni = x;
                druhe = y;
                tl.addMouseListener(new KliknutiNaTlacitko());
            }
        }
    }

    private void vykresliNabidku() {
        // doplnit + udelat metody - panel nastroju a gridLayout
        JPanel nabidka = new JPanel();
        nabidka.setLayout(new BorderLayout());
        nabidka.setPreferredSize(new Dimension(350, 100));
        nabidka.setBackground(Color.white);
        add(nabidka);

        JPanel levaNabidka = new JPanel();
        // levaNabidka.setPreferredSize(new Dimension(350, 100));
        levaNabidka.setBackground(Color.blue);
        levaNabidka.setLayout(new BoxLayout(levaNabidka, BoxLayout.X_AXIS));
        nabidka.add(levaNabidka, BorderLayout.WEST);

        // JPanel pravanab = new JPanel();
        JPanel pravaNabidka = new JPanel();
        // pravaNabidka.setPreferredSize(new Dimension(350, 100));
        pravaNabidka.setBackground(Color.red);
        JLabel novaHra = new JLabel("Nová Hra");
        pravaNabidka.add(novaHra);
        //pravaNabidka.setBorder(BorderFactory.createEmptyBorder(0, 120, 0, 0));
        JLabel konecHry = new JLabel("Konec Hry");
        // konecHry.setBorder(BorderFactory.createLineBorder(Color.black));
        pravaNabidka.add(konecHry);
        pravaNabidka.setLayout(new BoxLayout(pravaNabidka, BoxLayout.X_AXIS));

        // okraje! na layout
        nabidka.add(pravaNabidka, BorderLayout.EAST);

    }

    private void vykresliZnak(Znaky znak, JButton tl) {
        switch (znak) {
            case kolecko:
                tl.setText("O");
                break;
            case krizek:
                tl.setText("X");
                break;
        }
        tl.setEnabled(false);
        System.out.println("");
    }

    class KliknutiNaTlacitko extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            vykresliZnak(logika.getJeNaRade().getZnak(), tl);
            logika.udelejTah(prvni, druhe);
            System.out.println(e.getX() + " " + e.getY()); // souřadnice x, y tlačítka
            // tl.removeNotify();
            // tl.removeActionListener((ActionListener) e);
        }
    }

}
