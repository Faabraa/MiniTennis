package org.example;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Clase del menu principal
 */
public class Preguntes extends JFrame {

    public static final int NIVELL_MAXIM = 99;
    //Atributs de la clase com els botons i l'idioma
    JButton catalaButton = new JButton("Català");
    JButton castellaButton = new JButton("Castellano");
    Container container;
    private static String idioma = "Català";
    private static String nomUsuari="";
    private static int nivellInicial=0;
    private static boolean menuAcabat=false;
    private int WIDTH_MENU = 300;
    private int HEIGHT_MENU = 300;

    /**
     * Comprova si ja ha acabat la fase del menu
     * i es pot començar a jugar
     * @return
     */
    public static boolean isMenuAcabat() {
        return menuAcabat;
    }

    /**
     * Getters i setters
     * @return
     */
    public int getNivellInicial() {
        return nivellInicial;
    }

    /**
     * Constructor que fa els botons de idioma
     */
    public Preguntes() {
        super("Idioma");
        container = getContentPane();
        setLayout(new FlowLayout());
        add(catalaButton);
        add(castellaButton);
        catalaButton.addActionListener(new CatalanListener());
        castellaButton.addActionListener(new CastellanoListener());

        setSize(WIDTH_MENU, HEIGHT_MENU);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Listener del boto de catala que fa trucades als altres menus com el de nom d'usuari i el de nivell inicial
     */
    class CatalanListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            idioma = "Catala";
            //menu de mostrar l'idioma
            mostrarMissatgeIdioma(idioma);
            //tancar finestra
            dispose();
            //pregunta el nom d'usuari segons l'idioma
            preguntarNomUsuari(idioma);
            dispose();
            //pregunta el nivell inicial sense limit
            preguntarNivellInicial(idioma);
            dispose();
            //ensenya les normes del joc
            reglesJoc(idioma);
            dispose();

        }
    }

    /**
     * listener del boto castella
     */
    class CastellanoListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            idioma = "Castellano";

            //mostra l'idioma seleccionat segons l'idioma
            mostrarMissatgeIdioma(idioma);
            //Tanca la finestra
            dispose();
            //Pregunta el nom d'usuari
            preguntarNomUsuari(idioma);
            dispose();
            //Pregunta el nivell inicial
            preguntarNivellInicial(idioma);
            dispose();
            //Mostra les regles del joc
            reglesJoc(idioma);
            dispose();


        }
    }

    /**
     * Mostra l'idioma actual
     * @param idioma
     */
    private void mostrarMissatgeIdioma(String idioma) {
        if(idioma.equals("Castellano")){
            JOptionPane.showMessageDialog(this, "El juego estara en " + idioma, "Idioma", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "El joc estarà en " + idioma, "Idioma", JOptionPane.PLAIN_MESSAGE);
        }


    }

    /**
     * Pegunta el nom d'usuari a l'usuari
     * @param idioma
     */
    private void preguntarNomUsuari(String idioma) {
        if (idioma.equals("Catala")) {
            nomUsuari = JOptionPane.showInputDialog(this, "Introdueix el teu nom d'usuari:", "Nom d'usuari", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(this, "Benvingut, " + nomUsuari , "Nom Usuari", JOptionPane.INFORMATION_MESSAGE);
        } else {
            nomUsuari = JOptionPane.showInputDialog(this, "Introduce tu nombre de usuario:", "Nombre de usuario", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(this, "Bienvenido, " + nomUsuari , "Nombre Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static String getIdioma() {
        return idioma;
    }

    public static String getNomUsuari() {
        return nomUsuari;
    }

    /**
     * Pregunta el nivell inicial
     * @param idioma
     */
    private void preguntarNivellInicial(String idioma) {
        boolean condicio=false;
        while(!condicio) {

            try {

                if (idioma.equals("Catala")) {
                    String input = JOptionPane.showInputDialog("Introdueix el nivell inicial(El nivell final es 99):");

                    nivellInicial = Integer.parseInt(input);
                    if(nivellInicial< NIVELL_MAXIM){
                        condicio=true;
                    }else{
                        JOptionPane.showMessageDialog(null,"Has de posar un nivell valid","Error",JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    String input = JOptionPane.showInputDialog("Introduce el nivel inicial(El nivel final es 99):");

                    nivellInicial = Integer.parseInt(input);
                    if(nivellInicial<NIVELL_MAXIM){
                        condicio=true;
                    }else{
                        JOptionPane.showMessageDialog(null,"Tienes que introducir una nivel valido","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Has d'ingresar un numero enter valid", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }



    }

    /**
     * Mostra les normes del joc
     * @param idioma
     */
    private void reglesJoc(String idioma){
        if (idioma.equals("Catala")) {
            JOptionPane.showMessageDialog(null,
                    "Les regles son les següents:\n" +
                            "1.Cada 20.000 de puntuacio es subira un nivell\n" +
                            "2.Cada nivell augmenta la velocitat de la pilota\n" +
                            "3.El joc s'acaba quan s'escapa la pilota per darrere d'una raqueta\n", "Normes", JOptionPane.INFORMATION_MESSAGE);
            menuAcabat=true;


        } else {
            JOptionPane.showMessageDialog(null,
                    "Las reglas son las siguientes:\n" +
                            "1. Cada 20.000 de puntuación se subirá un nivel\n" +
                            "2.Cada nivel aumenta la velocidad de la pelota\n" +
                            "3.El juego se termina cuando se escapa la pelota por detrás de una raqueta\n", "Normas", JOptionPane.INFORMATION_MESSAGE);
            menuAcabat=true;
        }
    }
}

