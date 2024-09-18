package org.example;
import org.example.Repositories.Impls.JeuxRepositoryImpl;
import org.example.Repositories.JeuxRepository;
import org.example.entities.Jeux;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        JeuxRepository jeuxRepository = new JeuxRepositoryImpl();
        jeuxRepository.findAll();

        Jeux jeu = new Jeux("Assassin's Creed", "Action/Open-World",true,35.5,LocalDate.of(2020,10,28));
        jeuxRepository.updateJeux(6,jeu);

        jeuxRepository.findAll();
    }
}