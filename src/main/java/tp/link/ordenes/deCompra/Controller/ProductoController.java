package tp.link.ordenes.deCompra.Controller;
import org.springframework.web.bind.annotation.*;

import tp.link.ordenes.deCompra.Model.*;
import tp.link.ordenes.deCompra.Repos.RepoProducto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.validation.BindingResult;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private RepoProducto repoProd;
	
	@GetMapping("")
	public Page<Producto> all(Pageable page){
		return repoProd.findAll(page);
	}
	
	@GetMapping("/{nombre}")
	public Producto get(@PathVariable("nombre") String nombreProducto) {
		return repoProd.findByNombre(nombreProducto);
	}
	
	@PostMapping("")
	public String post(@RequestBody @Valid Producto producto, BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			repoProd.save(producto);
			return "Se cargado el producto";
		} else {
			bindingResult.getFieldErrors().stream().forEach(x -> {
				System.out.print(  x.getField());
				x.getDefaultMessage();
			});
			return "Ha habido un error durante el proceso de login";
		}
	}
}
