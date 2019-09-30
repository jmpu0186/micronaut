package listenerrabbit.config;

import javax.inject.Inject;

import io.micronaut.configuration.rabbitmq.annotation.Queue;
import io.micronaut.configuration.rabbitmq.annotation.RabbitListener;
import listenerrabbit.model.EventoGateway;
import listenerrabbit.model.Persona;
import listenerrabbit.services.EventoService;
import listenerrabbit.services.JsonService;

@RabbitListener
public class EventoListener {
	@Inject
	JsonService jsonService;
	@Inject
	EventoService eventoService;
	
	@Queue("evento2")
	public void toUpperCase(String mensaje) {
		try {
			EventoGateway evento = jsonService.readValue(mensaje, EventoGateway.class);
			eventoService.insertarEvento(evento);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("DESDE LA COLA "+mensaje);
	}
}
