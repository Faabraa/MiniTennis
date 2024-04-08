package org.example;

import javax.swing.JFrame;


public class Finestra {
    /**
     * Constructor que crea un objecte finestra
     */
    public Finestra(){
        //Declaracio de la finestra amb el nom
        JFrame jf=new JFrame("Retro Mini Tenis");
        //Longitud y amplada
        jf.setSize(500,500);
        //Si es pot veure o no(Si no es posa no es pot veure la finestra)
        jf.setVisible(true);
        //El que fa la finestra al tancar-la
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
