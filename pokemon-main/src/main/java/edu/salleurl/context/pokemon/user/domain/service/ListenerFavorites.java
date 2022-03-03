package edu.salleurl.context.pokemon.user.domain.service;

import edu.salleurl.context.pokemon.user.domain.interfaces.FavoritesRespository;
import edu.salleurl.context.pokemon.user.domain.model.totalFavorites;
import org.springframework.stereotype.Service;

@Service
public class ListenerFavorites {
    private final FavoritesRespository repository;

    public ListenerFavorites(FavoritesRespository repository) {
        this.repository = repository;
    }

    public totalFavorites create(String message) {
        totalFavorites favorites = new totalFavorites();
        favorites.setTotalFavorites(Integer.parseInt(message));
        if(message != null ){
            System.out.println("ID recibido:..."+ favorites.getTotalFavorites());
            repository.save(favorites);
        }
        return favorites;
    }
}
