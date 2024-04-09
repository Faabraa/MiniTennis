package org.example;
import java.awt.*;
import javax.swing.JPanel;
/**
 * Fem una clase amb els imports de la clase JPanel
 */
public class Game extends JPanel {
    Bola bola=new Bola(this);
    private void move(){
        bola.move();
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //Declarem la variable de Graphics2D
        Graphics2D g2d = (Graphics2D) g;
        //Posem el color negre
        g2d.setColor(Color.BLACK);
        //Declarem la bola
        bola.paint(g2d);
    }


    /**
     * Mètode base de dades
     */
    public void baseDeDades()   {

    }
}
