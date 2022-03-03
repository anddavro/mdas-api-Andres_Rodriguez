package edu.salleurl.context.pokemon.information.domain.model.service;

import edu.salleurl.context.pokemon.information.domain.exception.NotFoundException;
import edu.salleurl.context.pokemon.information.domain.exception.RepositoryNotRespondingException;
import edu.salleurl.context.pokemon.information.domain.model.Id;
import edu.salleurl.context.pokemon.information.domain.model.Pokemon;
import edu.salleurl.context.pokemon.information.domain.model.ports.PokemonRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PokemonFinder {

    private final PokemonRepository repository;

    public PokemonFinder(PokemonRepository repository) {
        this.repository = repository;
    }

    public Pokemon find(String id) throws RepositoryNotRespondingException, NotFoundException {

        Optional<Pokemon> pokemonInformation = repository.getPokemonInformation(new Id(Integer.valueOf(id)));

        if(pokemonInformation.isPresent()){
            return pokemonInformation.get();
        }else{
            throw new NotFoundException("Id not found");
        }
    }
}
