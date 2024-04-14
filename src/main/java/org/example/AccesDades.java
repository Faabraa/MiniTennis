package org.example;
import java.sql.*;

/**
 * Dades que es registren a la Base de Dades
 * @author Grup 3
 */
    public class AccesDades {
        Connection con;
        Statement st;
        ResultSet rs;

    /**
     * Mètode per obrir la connexió amb la BSD
     */
    public void obrirConnexio() {
            try {
            String userName= "usuari12";
            String password= "1234";
            String url="jdbc:mysql://172.19.1.20:3306/retro_tenis";
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Connexió a la BDD");
        } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

        //Per tancar la connexió un cop acabades les consultes
        public void cerrarConexion() {
            try {
                con.close();
                System.out.println("Connexió tancada");
            }
            catch (SQLException e) {
                System.out.println("Error en tancar connexió");
            }
        }
        //Mètode per consultar les dades de la BSD
        public void ConsultarDadesDeTaula() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM dades");
            while (rs.next()) {
                String nom_usuari = rs.getString(2);
                int puntuacio = rs.getInt(3);
                Date fecha = rs.getDate(4);
                String idioma = rs.getString(5);

                System.out.println("Nom d'usuari: " + nom_usuari +
                                   ", Puntuació: " + puntuacio + ", Data: " + fecha + ", Idioma: " + idioma);
            }
        } catch (SQLException e) {
            System.out.println("Error en obtenir dades de la taula: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException e) {
                System.out.println("Error en tancar el statement o el resultat: " + e.getMessage());
            }
        }
    }
    //Mètode per inserir dades a la BSD
    public void insertarDades(String nom_usuari, int puntuacio, Date fecha, String idioma){
        try {
            String query = "INSERT into dades (nom_usuari, puntuacio, data, idioma) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nom_usuari);
            preparedStatement.setInt(2, puntuacio);
            preparedStatement.setDate(3, new Date(fecha.getTime()));
            preparedStatement.setString(4, idioma);
            preparedStatement.executeUpdate();
            
            System.out.println("Dades insertades correctament. ");
        } catch (SQLException e) {
            System.out.println("Error en inserir dades a la taula: " + e.getMessage());
        }
    }
}