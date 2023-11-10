package API.API_UA.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import API.API_UA.daos.Acceso;
import API.API_UA.repositorios.AccesoRepositorio;



@Service
public class AccesoImpl implements AccesoServicio {

	@Autowired
	private AccesoRepositorio accesoRepositorio;
	
	@Override
	public List<Acceso> getAllUser() {
		return accesoRepositorio.findAll();
	}

	@Override
	public Acceso getAccesoById(Long accesoId) {
		Optional<Acceso>accesoOpt=accesoRepositorio.findById(accesoId);
		if(accesoOpt.isPresent())
			return accesoOpt.get();
		else
			throw new RuntimeException("Acceso no encontrado");
	}

	@Override
	public void saveAcceso(Acceso acceso) {
		Acceso accesoDetalle= accesoRepositorio.save(acceso);
		System.out.println("Acceso guardado en la base de datos con el id: "+accesoDetalle.getId_acceso());
		
	}

	@Override
	public void updateAcceso(Acceso acceso, Long accesoId) {
		Optional<Acceso>accesoDetalleOpt = accesoRepositorio.findById(accesoId);
		if(accesoDetalleOpt.isPresent()) {
			Acceso accesoDetalle= accesoDetalleOpt.get();
			//Codigo
			if(acceso.getCodigo_acceso()!=null || acceso.getCodigo_acceso().isEmpty())
				accesoDetalle.setCodigo_acceso(acceso.getCodigo_acceso());
			//Descripcion
			if(acceso.getDescripcion_acceso()!=null || acceso.getDescripcion_acceso().isEmpty())
				accesoDetalle.setDescripcion_acceso(acceso.getDescripcion_acceso());
			
		}else {
			throw new RuntimeException("Acceso no encontrado");
		}
		
	}

	@Override
	public void deleteAccesoById(Long accesoId) {

		Optional<Acceso> accesoOpt=accesoRepositorio.findById(accesoId);
		
		if(accesoOpt.isPresent())
			accesoRepositorio.deleteById(accesoId);
		else
			throw new RuntimeException("Acceso no encontrado");
	}
		
}

	 

