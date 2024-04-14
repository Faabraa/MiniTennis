package org.example;

import javax.swing.*;
import java.awt.*;

public class Obstacle extends JPanel {
    private int X = 350;
    private int HEIGHTSPAWN1 = 175;
    private final int WIDTH = 40;
    private final int HEIGHT = 40;
    private double speed = 1;
    private Game game;

    /**
     * Constructor
     * @param game
     */
    public Obstacle(Game game) {
        this.game = game;
    }

    /**
     * Moviment de l'obstacle
     */
    public void move() {
        if (X + WIDTH >= game.getWidth()) {
            X -= 1;
            speed = -speed;
        } else if (X <= 0) {
            X += 1;
            speed = -speed;
        } else {
            X += speed;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(X, HEIGHTSPAWN1, WIDTH, HEIGHT);
    }

    /**
     * Llegeix la col·lisió
     */
    public void checkCollisionWithBall() {
        if (game.bola.getBounds().intersects(getBounds())) {
            game.bola.ya = -game.bola.ya;
        }
    }

    /**
     * Dibuixa
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(X, HEIGHTSPAWN1, WIDTH, HEIGHT);
        g2d.dispose();
    }
}
