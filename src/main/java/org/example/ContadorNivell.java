package org.example;

import java.util.Timer;
import java.util.TimerTask;

public class ContadorNivell {
    private int nivell = 0;
    private static final int SEGONS_PER_NIVELL = 20000;
    private int oldNivell = 0;
    public int getNivell() {
        return nivell;
    }
    public int getOldNivell() {
        return oldNivell;
    }

    public void setOldNivell(int oldNivell) {
        this.oldNivell = oldNivell;
    }

    /**
     * Contador per augmentar el nivell cada SEGONS_PER_NIVELL mil·lisegons
     */
    public void startTimerNivell() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                setOldNivell(nivell);
                incrementNivell();
            }
        };
        //S'executa per cada mil·lisegon
        timer.scheduleAtFixedRate(task, 0, SEGONS_PER_NIVELL);
    }

    private void incrementNivell() {
        nivell += 1;
    }
}
