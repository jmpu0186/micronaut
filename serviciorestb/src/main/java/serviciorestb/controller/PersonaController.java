package serviciorestb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.exceptions.HttpClientException;
import serviciorestb.model.Persona;

@Controller("/")
public class PersonaController {
	@Inject
	ClienteRest clienteRest;
	
	@Get("/clienterest")
	public List<Persona> listarPersonas()
	{
		List<Persona> lista = new ArrayList();
		try {
			lista = clienteRest.listarPersonas("cabecera prueba");
			
		}catch(HttpClientException e)
		{
			e.getMessage();
		}
		return lista;
	}
}
