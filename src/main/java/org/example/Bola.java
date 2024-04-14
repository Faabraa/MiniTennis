package org.example;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class Bola {
    private Sonido sonido=new Sonido();
    public final int DIAMETER = 30;
    double x = 495;
    double y = 0;
    public double xa = 1;
    public double ya = 1;
    private Game game;


    /**
     * Constructor default
     * @param game
     */
    public Bola(Game game){
        this.game=game;
    }

    /**
     * Mou la pilota fins que aquesta toqui el terra i
     * augmenta la velocitat cada cert temps
     */
    void move() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        boolean changeDirection = true;
        //Els if limiten les voreres del llenç
        if (x + xa < 0){
            xa = game.speed;
            sonido.cargarSonido("src/sounds/bola.wav");
            sonido.reproducir();
        }
        else if (x + xa > game.getWidth() - DIAMETER){
            xa = -game.speed;
            sonido.cargarSonido("src/sounds/bola.wav");
            sonido.reproducir();
        }
        else if (y + ya < 0){
            ya = game.speed;
            sonido.cargarSonido("src/sounds/bola.wav");
            sonido.reproducir();
        }
        //Toca el terra
        else if (y + ya > game.getHeight() - DIAMETER){
            sonido.cargarSonido("src/sounds/gameover.wav");
            sonido.reproducir();
            game.gameOver();
        }
        else if (collision()){
            ya = -1;
            y = game.racquet.getTopY() - DIAMETER;
            sonido.cargarSonido("src/sounds/raqueta.wav");
            sonido.reproducir();
        }else changeDirection = false;
        x = x + xa;
        y = y + ya;
        game.speed=this.game.contadorNivell.velocitat.getSpeed();

    }

    /**
     * Crea una colisió a la raqueta
     * @return
     */
    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }
    /**
     * Dibuixa la pilota i la posiciona
     * @param g
     */
    public void paint(Graphics2D g) {
        g.fillRect((int)x,(int) y, DIAMETER,DIAMETER);
    }

    /**
     * Retorna un objecte de tipus rectangle que indica la posició de la raqueta
     * @return Objecte
     */
    public Rectangle getBounds() {
        return new Rectangle((int) x,(int) y, DIAMETER, DIAMETER);
    }
}
