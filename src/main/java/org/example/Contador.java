package org.example;

import java.util.Timer;
import java.util.TimerTask;

public class Contador {
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void startTimer() {
        Timer timer = new Timer(); // Crear una instancia de Timer
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                score += 1;
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1); // Programar la tarea para que se ejecute cada 1 milisegundo
    }
}
