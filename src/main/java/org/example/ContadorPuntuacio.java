package org.example;

import java.util.Timer;
import java.util.TimerTask;

public class ContadorPuntuacio {
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void startTimer() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                score += 1;
            }
        };
        //S'executa per cada mil·lisegon
        timer.scheduleAtFixedRate(task, 0, 1);
    }
}
