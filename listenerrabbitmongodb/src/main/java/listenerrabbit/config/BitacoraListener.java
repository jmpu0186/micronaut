package listenerrabbit.config;

import javax.inject.Inject;

import io.micronaut.configuration.rabbitmq.annotation.Queue;
import io.micronaut.configuration.rabbitmq.annotation.RabbitListener;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import listenerrabbit.model.LogServicios;
import listenerrabbit.services.JsonService;
import listenerrabbit.services.LogService;

@RabbitListener
public class BitacoraListener {
	@Inject
	JsonService jsonService;
	
	@Inject
	LogService logService;
	
	@Queue("bitacora")
	public void toUpperCase(String mensaje) {
		System.out.println("DESDE LA COLA "+mensaje);
		LogServicios logs = null;
		try {
			 logs = jsonService.readValue(mensaje, LogServicios.class);
			 Single<LogServicios> rpta = logService.guardarLog(logs);
			 rpta.subscribe();
			 System.out.println(rpta);
			 
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
}
