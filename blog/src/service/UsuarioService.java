package service;

import model.Usuario;

public interface UsuarioService {
	public void agregarUsuario(Usuario u);
	public Usuario autenticar(String nombreUsuario, String clave);
}
