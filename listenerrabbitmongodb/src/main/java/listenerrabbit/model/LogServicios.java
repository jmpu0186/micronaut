package listenerrabbit.model;

import java.util.Date;

import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@BsonDiscriminator
public class LogServicios {

	private String collection;
	
	@BsonProperty(value = "id")
	private String id;
	@BsonProperty(value = "canal")
	private String canal;
	@BsonProperty(value = "ip")
	private String ip;
	@BsonProperty(value = "tipoOperacion")
	private String tipoOperacion;
	@BsonProperty(value = "aplicacion")
	private String aplicacion;
	@BsonProperty(value = "fecha")
	private Date fecha;
	@BsonProperty(value = "datos")
	private Document datos;
	
	
	
	
	public Document getDatos() {
		return datos;
	}
	public void setDatos(Document datos) {
		this.datos = datos;
	}
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public String getAplicacion() {
		return aplicacion;
	}
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
