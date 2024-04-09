package org.example;

import java.awt.*;

public class Bola {
    private static final int DIAMETER = 30;
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private ContadorPuntuacio contadorPuntuacio;
    private ContadorNivell contadorNivell;
    private Game game;

    /**
     * Constructor default
     * @param game
     */
    public Bola(Game game){
        this.game=game;
    }

    /**
     * Mou la pilota infinitament
     */
    void move()  {
        boolean changeDirection = true;
        //Els if limiten les voreres del llenç
        if (x + xa < 0)
            xa = game.speed;
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        else if (y + ya < 0)
            ya = game.speed;
        else if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        else if (collision()){
            ya = -1;
            y = game.racquet.getTopY() - DIAMETER;
            game.speed++;
        } else changeDirection = false;
        x = x + xa;
        y = y + ya;
        game.speed = this.game.contadorNivell.getNivell();
    }
    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }
    /**
     * Dibuixa
     * @param g
     */
    public void paint(Graphics2D g) {
        //Declarem la bola
        g.fillRect(x, y, DIAMETER,DIAMETER);
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
