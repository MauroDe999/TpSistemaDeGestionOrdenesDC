package tp.link.ordenes.deCompra.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.link.ordenes.deCompra.Model.Producto;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@GetMapping()
	public Producto get() {
		
	}
}
