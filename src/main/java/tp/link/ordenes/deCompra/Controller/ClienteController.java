package tp.link.ordenes.deCompra.Controller;
import org.springframework.web.bind.annotation.*;

import tp.link.ordenes.deCompra.Model.*;
import tp.link.ordenes.deCompra.Repos.RepoCliente;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.validation.BindingResult;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private RepoCliente repoCli;
 	/*Se visualiza la lista de clientes*/
	@GetMapping("")
	public Page<Cliente> all(Pageable page){
		return repoCli.findAll(page);
	}
	/*Se busca a un cliente especifico*/
	@GetMapping("/{mail}")
	public Cliente get(@PathVariable("mail") String mailCliente) {
		return repoCli.findByMail(mailCliente);
	}
	/*Se da de alta aun cliente*/
	@PostMapping("")
	public String alta(@RequestBody @Valid Cliente cliente, BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			repoCli.save(cliente);
			return "Se ha logeado como cliente";
		} else {
			bindingResult.getFieldErrors().stream().forEach(x -> {
				System.out.print(  x.getField());
				x.getDefaultMessage();
			});
			return "Ha habido un error durante el proceso de login";
		}
	}
}
