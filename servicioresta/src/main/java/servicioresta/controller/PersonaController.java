package servicioresta.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import servicioresta.model.Persona;

@Controller("/v1/mspersonas")
public class PersonaController {

	@Get("/ejemplorest")
	public Persona ejemploRest()
	{
		Persona persona = new Persona();
		persona.setNombres("Juan Manuel");
		persona.setApellidos("Pena Uribe");
		persona.setDni(12345678);
		persona.setEdad(33);
		persona.setEmail("jmpu0186@gmail.com");
		return persona;
		
	}
}
