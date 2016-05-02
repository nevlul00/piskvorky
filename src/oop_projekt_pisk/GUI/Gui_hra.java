/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_projekt_pisk.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import oop_projekt_pisk.Hra;
import oop_projekt_pisk.HraciPlocha;

/**
 *
 * @author Lucie
 */
public class Gui_hra extends JPanel {

    Hra logika;

   public Gui_hra(Hra logika) {
       this.logika = logika;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        vykresliNabidku();
        vykresliHraciPlochu();
    }

    private void vykresliHraciPlochu() {
        JPanel hraciPole = new HraciPlocha(logika);
        add(hraciPole);

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

}
