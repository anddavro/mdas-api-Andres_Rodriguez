package edu.salleurl.context.pokemon.user.domain.interfaces;

import edu.salleurl.context.pokemon.user.domain.model.totalFavorites;

import java.util.Optional;

public interface FavoritesRespository {

    long countAllById_pokemon(String id_pokemon);

    public void save(totalFavorites favorites);

}

