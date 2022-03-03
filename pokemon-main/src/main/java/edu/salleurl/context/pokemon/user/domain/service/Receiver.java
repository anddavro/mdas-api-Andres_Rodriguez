package edu.salleurl.context.pokemon.user.domain.service;

import edu.salleurl.context.pokemon.user.domain.interfaces.FavoritesRespository;
import edu.salleurl.context.pokemon.user.domain.interfaces.UserRespository;
import edu.salleurl.context.pokemon.user.domain.model.totalFavorites;

public class Receiver {

    public static final String RECEIVE_METHOD_NAME = "receiveMessage";

    private final ListenerFavorites repository;

    public Receiver( ListenerFavorites repository) {

        this.repository = repository;
    }

    public void receiveMessage(String message) {
        totalFavorites favorites = new totalFavorites();
        if(message != null ){
            System.out.println("ID recibido:..."+ message);
            favorites.setTotalFavorites(Integer.parseInt(message));
            repository.create(message);
        }
    }
}
