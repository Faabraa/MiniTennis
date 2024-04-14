package org.example;

import javax.swing.JFrame;


public class Finestra {
    private final int WIDTH_FINESTRA = 500;
    private final int HEIGHT_FINESTRA = 500;
    /**
     * Constructor que crea un objecte finestra
     */
    public Finestra(Game game){
        JFrame jf = new JFrame("Retro Mini Tenis");
        //Coge el lienzo con los objetos
        jf.add(game);
        //Longitud y amplada
        jf.setSize(WIDTH_FINESTRA,HEIGHT_FINESTRA);
        //Si es pot veure o no(Si no es posa no es pot veure la finestra)
        jf.setVisible(true);
        //El que fa la finestra al tancar-la
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
