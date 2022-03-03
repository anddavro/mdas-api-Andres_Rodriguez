package edu.salleurl.context.pokemon.user.infraestructure.adapter.output.database.repositories;

public interface MqPublisherInterface {
    void run(String msj) throws InterruptedException;
}
