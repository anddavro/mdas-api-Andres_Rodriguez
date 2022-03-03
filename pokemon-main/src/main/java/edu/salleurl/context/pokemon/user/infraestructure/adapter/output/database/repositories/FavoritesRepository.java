package edu.salleurl.context.pokemon.user.infraestructure.adapter.output.database.repositories;

import edu.salleurl.context.pokemon.user.infraestructure.adapter.output.database.entities.totalFavoritesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends CrudRepository<totalFavoritesEntity,String> {
    @Query("select count(t) from EntityFavorites t where t.id_pokemon = :id")
     long countAllById_pokemon(@Param("id")String id);
}
