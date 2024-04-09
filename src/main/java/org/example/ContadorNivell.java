package org.example;

import java.util.Timer;
import java.util.TimerTask;

public class ContadorNivell {
    private int nivell = 0;
    public int getNivell() {
        return nivell;
    }

    public void startTimerNivell() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                nivell += 1;
            }
        };
        //S'executa per cada mil·lisegon
        timer.scheduleAtFixedRate(task, 0, 2000);
    }
}
