package tp.link.ordenes.deCompra.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import tp.link.ordenes.deCompra.Model.*;
import tp.link.ordenes.deCompra.Repos.*;

@RestController
@RequestMapping("/cupones")
public class CuponController {
	
	@Autowired
	RepoCupon repoCupon;
	
	@GetMapping("")
	public Page<Cupon> all(Pageable page){
		return repoCupon.findAll(page);
	}
	
	@GetMapping("/{nombre}")
	public Cupon get(@PathVariable("nombre") String nombre) {
		return repoCupon.findByNombre(nombre);
	}
	
	@PostMapping("")
	public String alta(@RequestBody @Valid Cupon cupon, BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			repoCupon.save(cupon);
			return "Se ha cargado el cupon";
		} else {
			bindingResult.getFieldErrors().stream().forEach(x -> {
				System.out.print(  x.getField());
				x.getDefaultMessage();
			});
			return "Ha habido un error durante la carga del cupon";
		}
	}
	
}
