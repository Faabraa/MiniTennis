package org.example;

public class Velocitat {
    private final double SPEED_INCREMENT = 0.1;
    public double speed = 1;

    /**
     * Getter
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Setter
     * @param speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Incrementa velocitat
     */
    public void incrementarVelocitat() {
        double velocitatIncrement = speed + SPEED_INCREMENT;
        setSpeed(velocitatIncrement);


    }
}
