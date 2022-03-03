package edu.salleurl.context.pokemon.information.application;

import edu.salleurl.context.pokemon.information.domain.exception.NotFoundException;
import edu.salleurl.context.pokemon.information.domain.exception.RepositoryNotRespondingException;
import edu.salleurl.context.pokemon.information.domain.interfaces.RespositoryTotalFavorites;
import edu.salleurl.context.pokemon.information.domain.model.Pokemon;
import edu.salleurl.context.pokemon.information.domain.model.service.PokemonFinder;
import org.springframework.stereotype.Service;

@Service
public class GetPokemonInformationUseCase {

    final private PokemonFinder finder;
    final private RespositoryTotalFavorites favoriteFinder;

    public GetPokemonInformationUseCase(PokemonFinder finder, RespositoryTotalFavorites favoriteFinder) {
        this.finder = finder;
        this.favoriteFinder = favoriteFinder;
    }

    public Pokemon execute(String pokemonId ) throws RepositoryNotRespondingException, NotFoundException {

        return finder.find(pokemonId);
    }

    public long executeFinder(String pokemonId ) {

        return favoriteFinder.countAllById_pokemon(pokemonId);
    }


}
