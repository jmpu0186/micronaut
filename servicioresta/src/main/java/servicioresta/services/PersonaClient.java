package servicioresta.services;

import javax.inject.Singleton;

import io.micronaut.configuration.rabbitmq.annotation.Binding;
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient;
import servicioresta.model.Persona;

@Singleton
@RabbitClient("expersonas")
public interface PersonaClient {
	@Binding("persona") 
    void updateAnalytics(Persona persona); 
}
