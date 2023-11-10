package API.API_UA.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import API.API_UA.daos.Acceso;
import API.API_UA.servicios.AccesoServicio;

@RestController
@RequestMapping("/acceso")
public class AccesoControlador {

	@Autowired
	private AccesoServicio accesoServicio;
	
	@GetMapping 
	public List<Acceso> getAllAccesos(){
		List<Acceso>acceso=accesoServicio.getAllUser();
		System.out.println("Accesos: "+acceso);
		return acceso;
		}
	
	@GetMapping("/{accesoId}")
	public Acceso getAccesoById(@PathVariable Long accesoId) {
		Acceso acceso = accesoServicio.getAccesoById(accesoId);
		System.out.println("Usuario id: " +accesoId+ " --- usuario: " +acceso);
		return acceso;
	}
	
	@PostMapping
	public String saveAcceso(@RequestBody Acceso acceso) {
		accesoServicio.saveAcceso(acceso);
		return "Acceso guardado correctamente";
	}
	
	@PutMapping("/{accesoId}")
	public String updateAcceso(@RequestBody Acceso acceso, @PathVariable Long accesoId) {
		accesoServicio.updateAcceso(acceso, accesoId);
		return "Acceso actualizado correctamente";
	}
	
	@DeleteMapping("/{accesoId}")
	public String deleteAccesoById(@PathVariable Long accesoId) {
		accesoServicio.deleteAccesoById(accesoId);
		return "Acceso eleminado correctamente";
	}
}
