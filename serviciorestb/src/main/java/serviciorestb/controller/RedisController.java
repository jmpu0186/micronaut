package serviciorestb.controller;

import java.io.IOException;

import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import serviciorestb.model.Persona;

@Controller("/")
public class RedisController {
	@Inject StatefulRedisConnection<String, String> connection;
	@Get("/testredis")
	public String prueba() throws InterruptedException
	{	
		RedisCommands<String, String> commands = connection.sync();
		System.out.println("================== PRUEBA CON UN DATO =================");
		commands.set("dni","43425181");
		System.out.println("SETEAMOS QUE EL VALOR CADUCA EN 1 SEGUNDO");
		commands.expire("dni", 1);
		System.out.println("RECUPERAMOS DATO ANTES DEL SEGUNDO "+commands.get("dni"));
		Thread.sleep(2000);
		System.out.println("RECUPERAMOS DATO DESPUES DE 2 SEGUNDOS "+commands.get("dni"));
		System.out.println("NO DEVLUELVE NULL "+commands.get("dni"));
		System.out.println("=======================================================");
		System.out.println("================== PRUEBA CON UN OBJECT =================");
		Persona persona = new Persona();
		persona.setNombres("Juan Manuel");
		persona.setApellidos("Pena Uribe");
		persona.setDni(12345678);
		persona.setEdad(33);
		persona.setEmail("jmpu0186@gmail.com");
		ObjectMapper mapper = new ObjectMapper();
		String json="";
		try {
			json = mapper.writeValueAsString(persona);
			System.out.println("OBJECT TO JSON "+json);
			commands.set("json", json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonRpta = commands.get("json");
		Persona p=null;
		try {
			/**
			 * Convertimos el JSON a Object para asi setear el valor de Redis a nuestro objeto
			 */
			p = mapper.readValue(jsonRpta, Persona.class);
			System.out.println("OBJECT RECUPERADO DESDE REDIS "+p.getNombres());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("=======================================================");
		return p.getNombres();
	}
}
