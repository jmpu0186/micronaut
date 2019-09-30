package listenerrabbit.services.impl;



import java.util.Date;
import javax.inject.Singleton;

import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
/*
import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
*/

import com.mongodb.reactivestreams.client.MongoClient;

import io.micronaut.context.annotation.Value;
import listenerrabbit.model.EventoGateway;
import listenerrabbit.services.EventoService;

//import pe.com.bn.ms.api.util.Constante;
//import pe.com.bn.ms.api.util.Funciones;


@Singleton
public class EventoServiceImpl implements EventoService {
	
	
	
	@Value("${elk.ip}")
	String ip;
	
	@Value("${elk.puerto}")
	String puerto;
	
	@Value("${elk.protocolo}")
	String protocolo;
	
	public void insertarEvento(EventoGateway evento) {


			String index = evento.getIndex();
			if(index==null)
				index="msdefault";
			String subTipo = "eventos";
			System.out.println("index>>>>>:"+index);
			String rpta = "";
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost(ip, Integer.parseInt(puerto), protocolo)));
			try {
				XContentBuilder builder = XContentFactory.jsonBuilder();
				builder.startObject();
				{
					builder.field("COD_ERROR", evento.getCodError());
					builder.field("DES_ERROR", evento.getDesError());
					builder.field("PROGRAMA", evento.getPrograma());
					builder.field("LEVEL", evento.getLevelError());
					builder.field("CANAL", evento.getCanal());
					builder.field("IP", evento.getIp());
					builder.field("TIPO_OPE", evento.getTipoOperacion());
					builder.field("APLICACION", evento.getAplicacion());
					// builder.field("DETALLE", evento.getDetalle().toString());
					builder.timeField("date", new Date());
				}
				builder.endObject();
				IndexRequest request = new IndexRequest(index, subTipo).source(builder);
				try {
					client.index(request, RequestOptions.DEFAULT);
					

				} catch (ElasticsearchException e) {
					
					e.printStackTrace();
				

				}
				client.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			
			}
	
	}
	
	

	
}
