package tp.link.ordenes.deCompra.Controller;
import org.springframework.web.bind.annotation.*;

import tp.link.ordenes.deCompra.Model.*;
import tp.link.ordenes.deCompra.Repos.RepoVendedor;

import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.validation.BindingResult;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
	@Autowired
	private RepoVendedor repoVen;
	
	/*Muesta la lista de vendedores*/
	@GetMapping("")
	public Page<Vendedor> all(Pageable page){
		return repoVen.findAll(page);
	}
	
	/*Muesta a un vendedor en especifico*/
	@GetMapping("/{nombre}")
	public Vendedor get(@PathVariable("nombre") String nombreVendedor) {
		return repoVen.findByNombre(nombreVendedor);
	}
	
	/*Da de alta a un vendedor*/
	@PostMapping("")
	public String alta(@RequestBody @Valid String mail, String password, String dni, String nombre,
		BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			repoVen.save(new Vendedor(mail, password, dni, new ArrayList<Producto>(), new ArrayList<Promocion>(),
			new ArrayList<OrdenDeCompra>(), 0 ,	nombre));
			return "Se ha logeado como vendedor";
		} else {
			bindingResult.getFieldErrors().stream().forEach(x -> {
				System.out.print(  x.getField());
				x.getDefaultMessage();
			});
			return "Ha habido un error durante el proceso de login";
		}
	}
	
}
