package edu.salleurl.context.pokemon.information.domain.model.service;

import edu.salleurl.context.pokemon.information.domain.interfaces.RespositoryTotalFavorites;


public class TotalFavoriteFinder {
    private final RespositoryTotalFavorites repository;

    public TotalFavoriteFinder(RespositoryTotalFavorites repository) {
        this.repository = repository;
    }

    public long finder(String message) {
        return   repository.countAllById_pokemon(message);

    }
}
