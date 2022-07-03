package tp.link.ordenes.deCompra.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import tp.link.ordenes.deCompra.Model.Promocion;
import tp.link.ordenes.deCompra.Repos.RepoPromo;

@RestController
@RequestMapping("/promociones")
public class PromoController {
	
	@Autowired
	RepoPromo repoPromo;
	
	/*Muesta la lista de promociones*/
	@GetMapping("")
	public Page<Promocion> all(Pageable page){
		return repoPromo.findAll(page);
	}
	
	/*Muestra una promo en especifico*/
	@GetMapping("{nombre}")
	public Promocion get(@PathVariable("nombre")String nombrePromo) {
		return repoPromo.findByNombre(nombrePromo);
	}
	
	/*Carga una promocion*/
	@PostMapping("")
	public String post(@RequestBody @Valid Promocion promo, BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			repoPromo.save(promo);
			return "Se ha creado la promocion";
		} else {
			bindingResult.getFieldErrors().stream().forEach(x -> {
				System.out.print(  x.getField());
				x.getDefaultMessage();
			});
			return "Ha habido un error durante la creacion de la promocion";
		}
	}
}
