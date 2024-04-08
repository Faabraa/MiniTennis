package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * Fem una clase amb els imports de la clase JPanel
 */
public class Game extends JPanel {
    /**
     * Metode paint per pintar a la finestra
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void paint(Graphics g){
        //Declarem la variable de Graphics2D
        Graphics2D grafic=(Graphics2D)g ;
        //Posem el color negre
        grafic.setColor(Color.BLACK);
        //Declarem la bola
        grafic.fillRect(0,0,10,10);


    }
}
