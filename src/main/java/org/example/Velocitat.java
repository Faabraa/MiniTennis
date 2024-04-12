package org.example;

public class Velocitat {
    private final double SPEED_INCREMENT = 0.1;
    public double speed = 1;
    Preguntes preguntes = new Preguntes();


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

    /**
     * Calcula la velocitat inicial de la pilota segons el nivell
     * @return
     */
    public void VelocitatInicial()    {
        setSpeed(speed + (preguntes.getNivellInicial() * SPEED_INCREMENT));
    }
}
