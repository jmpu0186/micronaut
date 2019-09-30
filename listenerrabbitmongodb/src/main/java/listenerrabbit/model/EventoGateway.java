package listenerrabbit.model;


public class EventoGateway {

	private String index;
	private String subTipo;
	private String codError;
	private String desError;
	private String programa;
	private String levelError;
	private String canal;
	private String ip;
	private String tipoOperacion;
	private String aplicacion;
	private GatewayDto detalle;
	
	public GatewayDto getDetalle() {
		return detalle;
	}
	public void setDetalle(GatewayDto detalle) {
		this.detalle = detalle;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getSubTipo() {
		return subTipo;
	}
	public void setSubTipo(String subTipo) {
		this.subTipo = subTipo;
	}
	public String getCodError() {
		return codError;
	}
	public void setCodError(String codError) {
		this.codError = codError;
	}
	public String getDesError() {
		return desError;
	}
	public void setDesError(String desError) {
		this.desError = desError;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public String getLevelError() {
		return levelError;
	}
	public void setLevelError(String levelError) {
		this.levelError = levelError;
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
	
	
}
