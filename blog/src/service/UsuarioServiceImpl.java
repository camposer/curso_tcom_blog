package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dao.UsuarioDao;
import exception.BlogException;
import model.Usuario;

@Component
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public void agregarUsuario(Usuario u) {
		Usuario uBD = usuarioDao.obtenerPorNombreUsuario(u.getNombreUsuario());
		
		if (uBD != null)
			throw new BlogException("Ya existe un usuario con ese nombre de usuario");
		
		usuarioDao.agregar(u);
	}

	@Override
	public Usuario autenticar(String nombreUsuario, String clave) {
		Usuario u = usuarioDao.obtenerPorNombreUsuario(nombreUsuario);
		
		if (u == null || !u.getClave().equals(clave)) 
			return null;
		else
			return u;
	}

}
