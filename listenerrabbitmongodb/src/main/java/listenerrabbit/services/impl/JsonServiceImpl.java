package listenerrabbit.services.impl;



import java.io.IOException;

import javax.inject.Singleton;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import listenerrabbit.services.JsonService;





@Singleton
public class JsonServiceImpl implements JsonService {
	private final ObjectMapper objectMapper;
	
	public JsonServiceImpl(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	
	public <T> T readValue(String content, Class<T> valueType) {
		try {
			return objectMapper.readValue(content, valueType);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	
	public String writeValueAsString(Object value) {
		try {
			return objectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}
