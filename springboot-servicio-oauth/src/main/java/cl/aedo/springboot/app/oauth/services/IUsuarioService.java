/**
 * 
 */
package cl.aedo.springboot.app.oauth.services;

import cl.aedo.springboot.app.commons.usuarios.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);
	
	public Usuario update(Usuario usuario, Long id);
	

}