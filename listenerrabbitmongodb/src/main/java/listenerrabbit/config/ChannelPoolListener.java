package listenerrabbit.config;

import java.io.IOException;

import javax.inject.Singleton;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import io.micronaut.configuration.rabbitmq.connect.ChannelInitializer;

@Singleton
public class ChannelPoolListener extends ChannelInitializer{

	@Override
	public void initialize(Channel channel) throws IOException {
		    channel.exchangeDeclare("exEvento2", BuiltinExchangeType.TOPIC, true); 
	        channel.queueDeclare("evento2", true, false, false, null); 
	        channel.queueBind("evento2", "exEvento2", "evento2"); 
	        
	        channel.exchangeDeclare("exBitacora", BuiltinExchangeType.TOPIC, true); 
	        channel.queueDeclare("bitacora", true, false, false, null); 
	        channel.queueBind("bitacora", "exBitacora", "bitacora"); 
		
	} 
	
}