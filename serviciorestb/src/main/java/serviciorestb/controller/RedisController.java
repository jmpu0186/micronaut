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
	@Inject StatefulRedisConnection<String, Persona> connectionObject;
	@Get("/testredis")
	public String prueba() throws InterruptedException
	{	
		RedisCommands<String, String> commands = connection.sync();
		commands.set("dni","43425181");
		commands.expire("dni", 2);
		System.out.println(commands.get("dni"));
		Thread.sleep(2000);
		System.out.println(commands.get("dni"));
		
		
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
			System.out.println("JSON "+json);
			commands.set("json", json);
			commands.expire("json",5);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonRpta = commands.get("json");
		try {
			Persona p = mapper.readValue(jsonRpta, Persona.class);
			System.out.println("RECUPERADO DESDE REDIS "+p.getNombres());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redis";
	}
}
