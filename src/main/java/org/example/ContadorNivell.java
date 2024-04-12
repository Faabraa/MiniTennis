package org.example;

import java.util.Timer;
import java.util.TimerTask;

public class ContadorNivell {
    public Velocitat velocitat = new Velocitat();
    private int nivell = 0;
    private static final int SEGONS_PER_NIVELL = 20000;
    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    /**
     * Contador per augmentar el nivell cada SEGONS_PER_NIVELL mil·lisegons
     */
    public void startTimerNivell() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                incrementNivell();
                if (nivell > 1) {
                    velocitat.incrementarVelocitat();

                }
            }
        };
        //S'executa per cada mil·lisegon
        timer.scheduleAtFixedRate(task, 0, SEGONS_PER_NIVELL);
    }

    private void incrementNivell() {
        nivell += 1;
    }
}
