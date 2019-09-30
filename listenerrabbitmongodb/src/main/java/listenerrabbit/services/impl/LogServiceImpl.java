package listenerrabbit.services.impl;

import javax.inject.Singleton;

import org.reactivestreams.Publisher;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.Success;

import io.reactivex.Single;
import listenerrabbit.model.LogServicios;
import listenerrabbit.services.LogService;

@Singleton
public class LogServiceImpl implements LogService {

	private final MongoClient mongoClient;

    public LogServiceImpl(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }
    
	@Override
	public Single<LogServicios> guardarLog(LogServicios bitacora) {
		// TODO Auto-generated method stub
		String collection = "logServicios";
		if(bitacora.getCollection()!=null)
		{
			if(!bitacora.getCollection().equals(""))
			{
				collection = bitacora.getCollection();
			}
		}
		return Single
        .fromPublisher(getCollection(collection).insertOne(bitacora))
        .map(success -> bitacora);
	}
	
	private MongoCollection<LogServicios> getCollection(String collection) {
        return mongoClient
                .getDatabase("micronaut")
                .getCollection(collection, LogServicios.class);
    }
}
