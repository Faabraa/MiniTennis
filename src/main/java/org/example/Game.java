package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.util.Date;

/**
 * Fem una clase amb els imports de la clase JPanel
 * @author Grup 3
 */
public class Game extends JPanel {

    public static final int FONTSIZE = 30;
    Bola bola = new Bola(this);
    Racquet racquet = new Racquet(this);
    ContadorPuntuacio contadorPuntuacio = new ContadorPuntuacio();
    static ContadorNivell contadorNivell = new ContadorNivell();
    Obstacle obstacle = new Obstacle(this);
    public static double speed = contadorNivell.velocitat.speed;
    /**
     * El joc
     */
    public Game() {
        contadorPuntuacio.startTimer();
        contadorNivell.startTimerNivell();
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

    /**
     * Moviment de la pilota i raqueta
     */
    private void move() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        bola.move();
        racquet.move();
        obstacle.move();
        obstacle.checkCollisionWithBall();
    }

    /**
     * Dibuixa els marcadors
     *
     * @param g the <code>Graphics</code> context in which to paint
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
        obstacle.paintComponent(g2d);
        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, FONTSIZE));
        //Dibuixa a la finestra
        g2d.drawString(String.valueOf(contadorPuntuacio.getScore()), 10, 30);
        g2d.drawString(String.valueOf(contadorNivell.getNivell()), 350, 30);
    }

    /**
     * Missatge al morir
     */
    public void gameOver() {
        try {
            JOptionPane.showMessageDialog(this, "Your score was: " + contadorPuntuacio.getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
            String usuari = Preguntes.getNomUsuari();
            String idioma = Preguntes.getIdioma();
            long miliseconds = System.currentTimeMillis();
            Date fecha = new Date(miliseconds);
            AccesDades accesDades = new AccesDades();
            accesDades.obrirConnexio();
            accesDades.insertarDades(usuari, contadorPuntuacio.getScore(), (java.sql.Date) fecha, idioma);
            // Para l'execució de codi al tancar la finestra
            System.exit(ABORT);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Mètode main
     *
     * @param args
     * @throws InterruptedException Excepció pel while
     */
    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        Preguntes preguntes = new Preguntes();
        Sonido sonido=new Sonido();
        while (!Preguntes.isMenuAcabat()) {
            Thread.sleep(10);
        }
        //Actualitza el nivell a la pantalla
        contadorNivell.setNivell(preguntes.getNivellInicial());
        //Posa la velocitat corresponent segons el nivell
        contadorNivell.velocitat.VelocitatInicial();
        speed=contadorNivell.velocitat.speed;
        Game game = new Game();
        Finestra finestra = new Finestra(game);
        sonido.cargarSonido("src/sounds/MusicaFondo.wav");
        sonido.reproducir();
        while (true) {
            if(sonido.clip.getFramePosition()==sonido.clip.getFrameLength()){
                sonido.reproducir();
            }
            game.move();

            //Crida al paint
            game.repaint();
            //Dona un descans als fils perque no agafin el mateix recurs a la vegada
            Thread.sleep(10);
        }
    }
}
