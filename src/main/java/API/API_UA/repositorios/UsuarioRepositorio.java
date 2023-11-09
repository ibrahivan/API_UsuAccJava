package API.API_UA.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import API.API_UA.daos.Usuario;

public interface UsuarioRepositorio extends JpaRepository <Usuario,Long>{

}
