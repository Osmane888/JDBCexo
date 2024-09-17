package org.example.Repositories.Impls;

import org.example.Repositories.JeuxRepository;
import org.example.entities.Jeux;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class JeuxRepositoryImpl implements JeuxRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/book";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private Jeux mapJeux(ResultSet rs) throws SQLException {
        return new Jeux(
                rs.getInt("id"),
                rs.getString("titre"),
                rs.getString("genre"),
                rs.getBoolean("multijoueur"),
                rs.getDouble("prix"),
                rs.getDate("date_sortie").toLocalDate()
        );
    }

    public List<Jeux> findAll() {
        try {
            Connection con = openConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Jeux");
            List<Jeux> jeux = new ArrayList<>();

            while (rs.next()) {
                jeux.add(mapJeux(rs));
            }

            con.close();
            for (Jeux j : jeux) {
                System.out.println(j);
            }
            return jeux;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Jeux findById(int id) {
        try {
            Connection con = openConnection();
            PreparedStatement stmt = con.prepareStatement("select * " + "from Jeux " + "where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                throw new NoSuchElementException("Le jeu à l'id " + " n'a pas été trouvé");
            }

            Jeux jeu = mapJeux(rs);
            con.close();
            return jeu;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public boolean addJeux(Jeux jeu) {
        try {
            Connection con = openConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "insert into jeux(" +
                            "titre, " +
                            "genre, " +
                            "multjoueur, " +
                            "prix, " +
                            "date_sortie, )" +
                            "VALUES(?,?,?,?,?)"
            );
            stmt.setString(1, jeu.getTitre());
            stmt.setString(2, jeu.getGenre());
            stmt.setBoolean(3,jeu.isMultijoueur());
            stmt.setDouble(4,jeu.getPrix());
            stmt.setDate(5,Date.valueOf(jeu.getDate()));

            stmt.executeUpdate();

            return true;

        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }


    }
}
