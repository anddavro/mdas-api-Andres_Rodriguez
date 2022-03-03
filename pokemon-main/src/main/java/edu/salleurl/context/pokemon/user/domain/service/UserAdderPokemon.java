package edu.salleurl.context.pokemon.user.domain.service;

import edu.salleurl.context.pokemon.user.domain.exceptions.PokemonFavoriteExistsException;
import edu.salleurl.context.pokemon.user.domain.interfaces.UserRespository;
import edu.salleurl.context.pokemon.user.domain.model.User;
import edu.salleurl.context.pokemon.user.infraestructure.adapter.output.database.repositories.MqPublisherInterface;
import org.springframework.stereotype.Service;

@Service
public class UserAdderPokemon {

    private final UserRespository repository;
    private final MqPublisherInterface publish;

    public UserAdderPokemon(UserRespository repository, MqPublisherInterface publish) {
        this.repository = repository;
        this.publish = publish;

    }

    public User add(User user, String pokemon) throws PokemonFavoriteExistsException, InterruptedException {
        user.addFavorite(pokemon);
        repository.save(user);
        publish.run(pokemon);
        return user;
    }
}
