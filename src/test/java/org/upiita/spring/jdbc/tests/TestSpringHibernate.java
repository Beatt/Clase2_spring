package org.upiita.spring.jdbc.tests;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.upiita.spring.jdbc.daos.UsuarioDAO;
import org.upiita.spring.jdbc.entidades.Usuario;

public class TestSpringHibernate {

	public static void main(String[] args) {
		// Pruebas, sin lanzar nuestra página web, esto 
		// evitar estár provando en nuestro servidor.
		//creamos el contexto de Spring de pruebas
		ApplicationContext contexto = new ClassPathXmlApplicationContext("/contexto.xml");
		
		UsuarioDAO usuarioDAO = (UsuarioDAO) contexto.getBean("usuarioDAO");
		
		
		// Es una clase contenedora no de utiliria.
		Usuario usuarioNuevo = new Usuario();
		usuarioNuevo.setUsuarioId(3);
		usuarioNuevo.setPassword("bomba");
		usuarioNuevo.setNombre("Paco");
		usuarioNuevo.setEmail("paco@gmail.com");						
		
		// Aquí se guarda el usuario en la tabla.
		usuarioDAO.creaUsuario(usuarioNuevo);
					
		Usuario usuario = usuarioDAO.buscaUsuarioPorId(3);
		
		System.out.println(usuario);		
		
		usuario = usuarioDAO.buscaPorEmail("pedro@email.com");
		System.out.println(usuario);
		
		List<Usuario> usuarios = usuarioDAO.obtenPorNombre("a");
		System.out.println("Usuarios: " + usuarios);
	}

}
