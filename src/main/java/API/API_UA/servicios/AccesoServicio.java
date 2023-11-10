package API.API_UA.servicios;

import java.util.List;

import API.API_UA.daos.Acceso;

public interface AccesoServicio {

	 List<Acceso>getAllUser();
	 Acceso getAccesoById(Long accesoId);
	 void saveAcceso(Acceso acceso);
	 void updateAcceso(Acceso acceso, Long accesoId);
	 void deleteAccesoById(Long accesoId);
}
