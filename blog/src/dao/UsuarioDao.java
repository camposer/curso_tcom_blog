package dao;

import model.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Integer> {
	public Usuario obtenerPorNombreUsuario(String usuario);
}
