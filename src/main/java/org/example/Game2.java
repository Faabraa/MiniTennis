package org.example;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Fem una clase amb els imports de la clase JPanel
 */
public class Game2 extends JPanel {

    int x = 0;
    int y = 0;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //Declarem la variable de Graphics2D
        Graphics2D g2d = (Graphics2D) g;
        //Posem el color negre
        g2d.setColor(Color.BLACK);
        //Declarem la bola
        g2d.fillRect(x, y, 30, 30);
    }

    /**
     * Mou la pilota infinitament
     */
    private void moveBall()  {
        x = x + 1;
        y = y + 1;
    }

    /**
     * Mètode main
     * @param args
     * @throws InterruptedException Excepció pel while
     */
    public static void main(String[] args) throws InterruptedException {
        Game2 game = new Game2();
        Finestra finestra = new Finestra(game);
        while (true)    {
            game.moveBall();
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
