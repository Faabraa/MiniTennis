package org.example;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 * Fem una clase amb els imports de la clase JPanel
 */
public class Game extends JPanel {
    Bola bola = new Bola(this);
    Racquet racquet = new Racquet(this);
    int speed = 1;
    Contador contador = new Contador();

    public Game() {
        contador.startTimer();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
            }
        });
        setFocusable(true);
    }
    private void move(){
        bola.move();
        racquet.move();
    }

    /**
     * Dibuixa
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //Declarem la variable de Graphics2D
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //Posem el color negre
        g2d.setColor(Color.BLACK);
        //Declarem la bola
        bola.paint(g2d);
        racquet.paint(g2d);
        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(contador.getScore()), 10, 30);
    }
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Your score was: " + contador.getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    /**
     * Mètode main
     * @param args
     * @throws InterruptedException Excepció pel while
     */
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Finestra finestra = new Finestra(game);
        while (true)    {
            game.move();
            //Crida al paint
            game.repaint();
            //Dona un descans als fils perque no agafin el mateix recurs a la vegada
            Thread.sleep(10);
        }
    }
    /**
     * Mètode base de dades
     */
    public void baseDeDades()   {

    }
}
