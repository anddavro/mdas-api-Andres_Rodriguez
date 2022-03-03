package edu.salleurl.context.pokemon.user.infraestructure.adapter.output.database.adapter;

import edu.salleurl.context.pokemon.user.infraestructure.adapter.output.database.repositories.MqPublisherInterface;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqPublisher implements MqPublisherInterface {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public MqPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void run(String msj) throws InterruptedException {
        rabbitTemplate.convertAndSend(SenderConfig.EXCHANGE_NAME, SenderConfig.ROUTING_KEY, msj);
    }

}
