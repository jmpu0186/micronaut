package listenerrabbit.services;

public interface JsonService {
	<T> T readValue(String content, Class<T> valueType);
	String writeValueAsString(Object value);
}
