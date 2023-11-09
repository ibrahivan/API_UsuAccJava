package API.API_UA.servicios;

import java.util.List;

import API.API_UA.daos.Usuario;

public interface UsuarioServicio {

	 List<Usuario>getAllUser();
	 Usuario getUserById(Long usuarId);
	 void saveUsuario(Usuario usuario);
	 void updateUsuario(Usuario usuario, Long usuarioId);
	 void deleteUsuarioById(Long usuarioId);

}
