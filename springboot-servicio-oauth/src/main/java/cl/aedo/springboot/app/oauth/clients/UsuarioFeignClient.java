package cl.aedo.springboot.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cl.aedo.springboot.app.commons.usuarios.models.entity.Usuario;


/* Para realizar y personalizar el login y asi poder
 * enviar el nombre de usarios al 
 * microsericios de usarios al servicio que deseamos autenticar */

@FeignClient(name="servicio-usuarios")
public interface UsuarioFeignClient {

	@GetMapping("/usuarios/search/buscar-username")
	public Usuario findByUsername(@RequestParam String username);
	
	@PutMapping("/usuarios/{id}")
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id);

}