package cl.aedo.springboot.app.oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.aedo.springboot.app.oauth.clients.UsuarioFeignClient;
import cl.aedo.springboot.app.commons.usuarios.models.entity.Usuario;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService

{
	private Logger log = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioFeignClient client;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = client.findByUsername(username);	
		if (usuario == null) {
			log.error("Error en logín, usuario "+username+" no existe ");
			throw new UsernameNotFoundException("Error en logín, usuario "+username+" no existe ");
		}				
		
		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				//Convertimos el flujo o stream desde el tipo rol al tipo GrantedAuthority
				//pero continua siendo un stream.
				  .map(role -> new SimpleGrantedAuthority(role.getNombre()))
				//Para mostrar el nombre del rol del usuario autenticado para eso
				//usamos expresion lambda.
				  .peek(authority -> log.info("Role: " + authority.getAuthority()))
				//Como aún sigue siendo un Stream hay que volver a convertir a
				//un tipo list usando collect.
				  .collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	 }

	@Override
	public Usuario findByUsername(String username) {
		return client.findByUsername(username);
	}
	
	@Override
	public Usuario update(Usuario usuario, Long id) {
		return client.update(usuario, id);
	}
	
}
	
/*

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	try {
	
		Usuario usuario = client.findByUsername(username);

		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> log.info("Role: " + authority.getAuthority())).collect(Collectors.toList());

		log.info("Usuario autenticado: " + username);

		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
				authorities);
		} catch (FeignException e) {
			String error = "Error en el login, no existe el usuario '" + username + "' en el sistema";
			log.error(error);
			throw new UsernameNotFoundException(error);
	 }
    }
*/