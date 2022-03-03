package edu.salleurl.context.pokemon.information.infraestructure.adapter.output.restApis.adapter;

import edu.salleurl.context.pokemon.information.domain.interfaces.RespositoryTotalFavorites;
import edu.salleurl.context.pokemon.information.infraestructure.adapter.output.restApis.repositories.RepositoryFavorites;
import org.springframework.stereotype.Repository;

@Repository
public class TotalFavoriteAdapter implements RespositoryTotalFavorites {

    private final RepositoryFavorites repository;

    public TotalFavoriteAdapter(RepositoryFavorites repository) {
        this.repository = repository;
    }

    @Override
    public long countAllById_pokemon(String id_pokemon) {
        if (!id_pokemon.isEmpty()) {
            return repository.countAllById_pokemon(id_pokemon);
        }else {
            return 0L;
        }
    }
}
