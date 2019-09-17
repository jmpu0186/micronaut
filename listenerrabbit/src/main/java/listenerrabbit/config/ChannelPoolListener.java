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
		  channel.exchangeDeclare("expersonas", BuiltinExchangeType.DIRECT, true); 
	        channel.queueDeclare("persona", true, false, false, null); 
	        channel.queueBind("persona", "expersonas", "persona"); 
		
	} 
	
}