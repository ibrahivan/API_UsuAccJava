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

import API.API_UA.daos.Usuario;
import API.API_UA.servicios.UsuarioServicio;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@GetMapping 
	public List<Usuario> getAllUsuarios(){
		List<Usuario>usuarios=usuarioServicio.getAllUser();
		System.out.println("Usuarios: "+usuarios.size());
		return usuarios;
		}
	
	@GetMapping("/{usuarioId}")
	public Usuario getUsuarioById(@PathVariable Long usuarioId) {
		Usuario usuario = usuarioServicio.getUserById(usuarioId);
		System.out.println("Usuario id: " +usuarioId+ " --- usuario: " +usuario);
		return usuario;
	}
	
	@PostMapping
	public String saveUsuario(@RequestBody Usuario usuario) {
		usuarioServicio.saveUsuario(usuario);
		return "Usuario guardado correctamente";
	}
	
	@PutMapping("/{usuarioId}")
	public String updateUsuario(@RequestBody Usuario usuario, @PathVariable Long usuarioId) {
		usuarioServicio.updateUsuario(usuario, usuarioId);
		return "Usuario actualizado correctamente";
	}
	
	@DeleteMapping("/{usuarioId}")
	public String deleteUsuarioById(@PathVariable Long usuarioId) {
		usuarioServicio.deleteUsuarioById(usuarioId);
		return "Usuario eleminado correctamente";
	}
}


