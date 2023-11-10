package API.API_UA.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import API.API_UA.daos.Usuario;
import API.API_UA.repositorios.UsuarioRepositorio;

@Service
public class UsuarioImpl implements UsuarioServicio {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	/*
	 * Metodo de escoger todos los usuarios
	 */
	@Override
	public List<Usuario> getAllUser(){
		return usuarioRepositorio.findAll();
	}
	
	
	/*
	 * Metodo de escoger usuario por id
	 */
	@Override
	public Usuario getUserById(Long usuarId)
	{
		Optional<Usuario>usuarioOpt=usuarioRepositorio.findById(usuarId);
		if(usuarioOpt.isPresent())
			return usuarioOpt.get();
		else
			throw new RuntimeException("Usuario no encontrado");
	}
	
	/*
	 * Metodo para guardar un usuario
	 */
	@Override
	public void saveUsuario(Usuario usuario) {
		Usuario usuarioDetalle= usuarioRepositorio.save(usuario);
		System.out.println("Usuario guardado en la base de datos con el id: "+usuarioDetalle.getId_usuario());
	}
	
	/*
	 * Metodo para actualizar un usuario
	 */
	@Override
	public void updateUsuario(Usuario usuario, Long usuarioId) {
		Optional<Usuario>usuarioDetalleOpt = usuarioRepositorio.findById(usuarioId);
		if(usuarioDetalleOpt.isPresent()) {
			Usuario usuarioDetalle= usuarioDetalleOpt.get();
			//Nombre
			if(usuario.getNombre_usuario()!=null || usuario.getNombre_usuario().isEmpty())
				usuarioDetalle.setNombre_usuario(usuario.getNombre_usuario());
			//Apellidos
			if(usuario.getApellidos_usuario()!=null || usuario.getApellidos_usuario().isEmpty())
				usuarioDetalle.setApellidos_usuario(usuario.getApellidos_usuario());
			//DNI
			if(usuario.getDni_usuario()!=null || usuario.getDni_usuario().isEmpty())
				usuarioDetalle.setDni_usuario(usuario.getDni_usuario());
			//Telefono
			if(usuario.getTlf_usuario()!=null || usuario.getTlf_usuario().isEmpty())
				usuarioDetalle.setTlf_usuario(usuario.getTlf_usuario());
			//Email
			if(usuario.getEmail_usuario()!=null || usuario.getEmail_usuario().isEmpty())
				usuarioDetalle.setEmail_usuario(usuario.getEmail_usuario());
			//Clave
			if(usuario.getClave_usuario()!=null || usuario.getClave_usuario().isEmpty())
				usuarioDetalle.setClave_usuario(usuario.getClave_usuario());
			//Bloqueado
			if(usuario.getEstabloqueado_usuario()!=null )
				usuarioDetalle.setEstabloqueado_usuario(usuario.getEstabloqueado_usuario());
			//Fecha fin bloqueo
			if(usuario.getFch_fin_bloqueo_usuario()!=null )
				usuarioDetalle.setFch_fin_bloqueo_usuario(usuario.getFch_fin_bloqueo_usuario());			
			//Fecha alta
			if(usuario.getFch_alta__usuario()!=null)
				usuarioDetalle.setFch_alta__usuario(usuario.getFch_alta__usuario());
			//Fecha baja
			if(usuario.getFch_baja_usuario()!=null)
				usuarioDetalle.setFch_baja_usuario(usuario.getFch_baja_usuario());
			usuarioRepositorio.save(usuarioDetalle);
		}else {
			throw new RuntimeException("Usuario no encontrado");
		}
	}
	
	/*
	 * Metodo para borrar un usuario por el id
	 */
	@Override
	public void deleteUsuarioById(Long usuarioId) {
		Optional<Usuario> usuarioOpt=usuarioRepositorio.findById(usuarioId);
		
		if(usuarioOpt.isPresent())
			usuarioRepositorio.deleteById(usuarioId);
		else
			throw new RuntimeException("Usuario no encontrado");
	}
	
}
