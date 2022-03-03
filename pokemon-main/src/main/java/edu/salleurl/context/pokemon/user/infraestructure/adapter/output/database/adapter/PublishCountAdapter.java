package edu.salleurl.context.pokemon.user.infraestructure.adapter.output.database.adapter;

import edu.salleurl.context.pokemon.user.domain.interfaces.FavoritesRespository;
import edu.salleurl.context.pokemon.user.domain.model.totalFavorites;
import edu.salleurl.context.pokemon.user.infraestructure.adapter.output.database.entities.totalFavoritesEntity;
import edu.salleurl.context.pokemon.user.infraestructure.adapter.output.database.repositories.FavoritesRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class PublishCountAdapter implements FavoritesRespository {

    private final FavoritesRepository repository;

    public PublishCountAdapter(FavoritesRepository repository) {
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

    @Override
    public void save(totalFavorites favorites) {
            List<Integer> id = Collections.singletonList(favorites.getTotalFavorites());
            System.out.println("ID recibido Consumer:..." + id.stream().count());
            String val = String.valueOf(favorites.getTotalFavorites());
            totalFavoritesEntity FavoritePokemonEntity = new totalFavoritesEntity(null,val,0L);
            repository.save(FavoritePokemonEntity);
    }
}
