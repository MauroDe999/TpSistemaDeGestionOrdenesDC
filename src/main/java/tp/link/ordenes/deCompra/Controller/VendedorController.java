package tp.link.ordenes.deCompra.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import tp.link.ordenes.deCompra.Model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
	@Autowired
	private RepoVendedor repoVen;
	
	@GetMapping("")
	public Page<Vendedor> all(Pageable page){
		return repoVen.findAll(page);
	}
	
}
