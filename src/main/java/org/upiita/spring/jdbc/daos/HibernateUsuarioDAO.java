package org.upiita.spring.jdbc.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.upiita.spring.jdbc.entidades.Usuario;

@Component("usuarioDAO")
public class HibernateUsuarioDAO implements UsuarioDAO {

	
	// Esta es una clase de utileria de hibernate
	// Inyectamos una instancia
	@Autowired
	private SessionFactory sessionFactory;
	
	// Transacciones programaticas, existen la trans declarativa.
	public Usuario buscaUsuarioPorId(Integer usuarioId) {

		// Primero creamos una sessi�n de hibernate
		Session sesion = sessionFactory.openSession();
		
		// Una vez que tiene la sessi�n
		// Deben de abrir una transacci�n.
		sesion.beginTransaction();
		
		// Busca por id en la tabla mepeada por la clase usuario
		// El renglon cuyo i se igual a usuarioId
		// Si no encuentra nada , regresa null.
		Usuario usuario = (Usuario) sesion.get(Usuario.class, usuarioId);
		
		// Termina la transacci�n.
		sesion.getTransaction().commit();
		//sessionFactory.getCurrentSession().getTransaction().commit();
		
		// Cerramos la sessi�n de hibernate
		sesion.close();
		
		return usuario;
	}

	public void creaUsuario(Usuario usuario) {
		
		// Primero creamos una sessi�n de hibernate
		Session sesion = sessionFactory.openSession();
		
		// Una vez que tiene la sessi�n
		// Deben de abrir una transacci�n.
		sesion.beginTransaction();
		
		// Crea un nuevo registro en la tabla, cuyas columnas se llenan
		//  con las propiedades con la clase Instancia usuario.
		// Equivalente a un insert de sql
		sesion.save(usuario);
				
		// Termina la transacci�n.
		sesion.getTransaction().commit();
		//sessionFactory.getCurrentSession().getTransaction().commit();
		
		// Cerramos la sessi�n de hibernate
		sesion.close();
				
	}
	
	public Usuario buscaPorEmail(String email) {		

		// Primero creamos una sessi�n de hibernate
		Session sesion = sessionFactory.openSession();
		
		// Una vez que tiene la sessi�n
		// Deben de abrir una transacci�n.
		sesion.beginTransaction();
		
		Criteria criterio = sesion.createCriteria(Usuario.class);
		
		criterio.add(Restrictions.eq("email", email));
		
		// Si saben que va a regresar una sola entidad
		Usuario usuario = (Usuario) criterio.uniqueResult();
		
		// Termina la transacci�n.
		sesion.getTransaction().commit();
		//sessionFactory.getCurrentSession().getTransaction().commit();
		
		// Cerramos la sessi�n de hibernate
		sesion.close();
		
		return usuario;
	}
	
	public List<Usuario> obtenPorNombre(String nombre) {
		

		// Primero creamos una sessi�n de hibernate
		Session sesion = sessionFactory.openSession();
		
		// Una vez que tiene la sessi�n
		// Deben de abrir una transacci�n.
		sesion.beginTransaction();
		
		Criteria criterio = sesion.createCriteria(Usuario.class);
		
		//criterio.add(Restrictions.ilike("nombre", "%" + nombre + "%"));
		criterio.add(Restrictions.not(Restrictions.ilike("nombre", "%" + nombre + "%")));
		
		
		List<Usuario> usuarios = criterio.list();
		
		// Termina la transacci�n.
		sesion.getTransaction().commit();
		//sessionFactory.getCurrentSession().getTransaction().commit();
		
		// Cerramos la sessi�n de hibernate
		sesion.close();
		
		return usuarios;
		
	}//Fin obtenPorNombre

}
