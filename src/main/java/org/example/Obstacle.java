package org.example;

import org.example.Bola;
import org.example.Game;

import java.awt.*;
import javax.swing.*;

public class Obstacle extends JPanel {
    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;
    private int x;
    private int y;
    private Game game;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, WIDTH, HEIGHT);
        g2d.dispose();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void checkCollisionWithBall(Bola bola) {
        Rectangle ballBounds = bola.getBounds();
        if (ballBounds.intersects(getBounds())) {
            double ballCenterX = ballBounds.getCenterX();
            double ballCenterY = ballBounds.getCenterY();

            double obstacleCenterX = x + WIDTH / 2.0;
            double obstacleCenterY = y + HEIGHT / 2.0;

            double dx = Math.abs(ballCenterX - obstacleCenterX);
            double dy = Math.abs(ballCenterY - obstacleCenterY);

            if (dx <= (WIDTH / 2.0 + bola.DIAMETER / 2.0) && dy <= (HEIGHT / 2.0 + bola.DIAMETER / 2.0)) {
                if (dx > dy) {
                    bola.xa = -bola.xa;
                } else {
                    bola.ya = -bola.ya;
                }
            }
        }
    }
}
