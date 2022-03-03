package edu.salleurl.context.pokemon.information.infraestructure.adapters.input.rest.dto;

public class PokemonInformationResponse {

    private int  id;

    private String name;

    private int weight;

    private int height;

    private int totalFavorites;

    public int getTotalFavorites() {
        return totalFavorites;
    }

    public void setTotalFavorites(int totalFavorites) {
        this.totalFavorites = totalFavorites;
    }

    public PokemonInformationResponse() {
    }

    public PokemonInformationResponse(int id, String name, int weight, int height, int totalFavorites) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.totalFavorites = totalFavorites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
