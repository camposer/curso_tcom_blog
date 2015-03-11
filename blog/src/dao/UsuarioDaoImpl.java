package dao;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import model.Usuario;

@Component
public class UsuarioDaoImpl 
	extends GenericDaoImpl<Usuario, Integer>
	implements UsuarioDao {

	@Override
	public Usuario obtenerPorNombreUsuario(String usuario) {
		String jql = "from Usuario u where u.nombreUsuario = :nombreUsuario";
		Query q = entityManager.createQuery(jql);
		q.setParameter("nombreUsuario", usuario);
		
		return (Usuario)q.getSingleResult();
	}

}
