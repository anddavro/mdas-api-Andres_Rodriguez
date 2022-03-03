package edu.salleurl.context.pokemon.information.infraestructure.adapter.output.restApis.entities;

import javax.persistence.*;

@Entity
@Table(name = "totalFavorites")
public class EntityFavorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long Id;

    @Column(name = "id_pokemon")
    private String id_pokemon;

    @Column(name = "total_favorites")
    private Long total_favorites;

    public EntityFavorites() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getId_pokemon() {
        return id_pokemon;
    }

    public void setId_pokemon(String id_pokemon) {
        this.id_pokemon = id_pokemon;
    }

    public Long getTotal_favorites() {
        return total_favorites;
    }

    public void setTotal_favorites(Long total_favorites) {
        this.total_favorites = total_favorites;
    }

    public EntityFavorites(Long id, String id_pokemon, Long total_favorites) {
        this.Id = id;
        this.id_pokemon = id_pokemon;
        this.total_favorites = total_favorites;
    }

    @Override
    public String toString() {
        return "totalFavoritesEntity{" +
                "id=" + Id +
                ", id_pokemon='" + id_pokemon + '\'' +
                ", total_favorites=" + total_favorites +
                '}';
    }
}
