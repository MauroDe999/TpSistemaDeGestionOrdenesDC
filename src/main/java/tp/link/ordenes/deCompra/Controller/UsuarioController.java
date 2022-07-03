package tp.link.ordenes.deCompra.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import tp.link.ordenes.deCompra.Model.Usuario;
import tp.link.ordenes.deCompra.Repos.RepoUsuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private RepoUsuario repoUsu;
	
	@GetMapping("")
	public Page<Usuario> all(Pageable page){
		return repoUsu.findAll(page);
	}
	@GetMapping("/{dni}")
	public Usuario get(@PathVariable("dni") int dniUsu){
		return repoUsu.findByDni(dniUsu);
	}
	
	
}
