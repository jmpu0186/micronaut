package listenerrabbit.services;

import io.reactivex.Single;
import listenerrabbit.model.LogServicios;

public interface LogService {

	public Single<LogServicios> guardarLog(LogServicios bitacora);
}
