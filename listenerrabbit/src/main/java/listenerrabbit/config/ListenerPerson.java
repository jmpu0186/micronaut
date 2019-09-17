package listenerrabbit.config;

import io.micronaut.configuration.rabbitmq.annotation.Queue;
import io.micronaut.configuration.rabbitmq.annotation.RabbitListener;
import listenerrabbit.model.Persona;

@RabbitListener
public class ListenerPerson {

	@Queue("persona")
	public void toUpperCase(Persona persona) {
		System.out.println("NOMBRES DESDE LA COLA "+persona.getNombres());
	}
}
