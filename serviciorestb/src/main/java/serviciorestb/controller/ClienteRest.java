package serviciorestb.controller;

import java.util.List;

import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;
import serviciorestb.model.Persona;

@Client("http://localhost:8082")

public interface ClienteRest {

	@Post("/v1/mspersonas/listar")
	@CircuitBreaker(attempts="2",delay="100ms")
	public List<Persona> listarPersonas(@Header("cabecera") String cabecera);
}
