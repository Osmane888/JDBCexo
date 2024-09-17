package org.example.Repositories;

import org.example.entities.Jeux;

import java.util.List;

public interface JeuxRepository {
    List<Jeux> findAll();
    Jeux findById (int id);
    boolean addJeux(Jeux jeu);
    boolean updateJeux(int id);
    void deleteJeux(int id);
}
