package org.example;

import java.awt.*;

public class Bola {
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private final Game game;

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
        //Els if limiten les voreres del llenç
        if (x + xa < 0)
            xa = 1;
        if (x + xa > game.getWidth() - 30)
            xa = -1;
        if (y + ya < 0)
            ya = 1;
        if (y + ya > game.getHeight() - 30)
            ya = -1;
        x += xa;
        y += ya;
    }
    public void paint(Graphics2D g) {
        //Declarem la bola
        g.fillRect(x, y, 30, 30);
    }
}
