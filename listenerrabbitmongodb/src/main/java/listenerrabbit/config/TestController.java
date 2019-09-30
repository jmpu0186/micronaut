package listenerrabbit.config;

import java.util.Date;

import javax.inject.Inject;

import org.bson.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;
import listenerrabbit.model.GatewayDto;
import listenerrabbit.model.LogServicios;
import listenerrabbit.services.LogService;


@Controller
public class TestController {

	@Inject
	LogService logService;
	
	@Get("/testmongo")
	public Single<LogServicios> testmongo()
	{
		LogServicios log = new LogServicios();
		log.setCollection("juancho");
		log.setAplicacion("aplicacion");
		log.setCanal("canal");
		log.setFecha(new Date());
		log.setId("122222");
		log.setIp("ip");
		log.setTipoOperacion("FINAN");
		GatewayDto detalle = new GatewayDto();
		detalle.setDatos("datos");
		Document b = new Document();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonDatos = mapper.writeValueAsString(detalle);
			Document c = b.parse(jsonDatos);
			log.setDatos(c);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Single<LogServicios> rpta = logService.guardarLog(log);
		
		System.out.println(rpta);
		return rpta;
	}
}
