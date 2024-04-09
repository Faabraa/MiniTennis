package org.example;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Classe per llegir el teclat de l'usuari
 */
public class KeyboardExample extends JPanel {
    /**
     * Constructor,
     */
    public KeyboardExample() {
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        //Permet llegir el teclat de l'usuari
        setFocusable(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Tennis");
        KeyboardExample keyboardExample = new KeyboardExample();
        frame.add(keyboardExample);
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Mostra la tecla presionada
     */
    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            System.out.println("keyPressed="+KeyEvent.getKeyText(ke.getKeyCode()));
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            System.out.println("keyReleased="+KeyEvent.getKeyText(ke.getKeyCode()));
        }
    }
}
