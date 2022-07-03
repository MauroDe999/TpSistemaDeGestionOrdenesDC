package tp.link.ordenes.deCompra.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tp.link.ordenes.deCompra.Model.OrdenDeCompra;
import tp.link.ordenes.deCompra.Repos.RepoOrdenDeCompra;

@RestController
@RequestMapping("/ordenes")
public class OrdenDeCompraController {
	
	@Autowired
	RepoOrdenDeCompra repoODC;
	
	@GetMapping("")
	public Page<OrdenDeCompra> all(Pageable page){
		return repoODC.findAll(page);
	}
	
}
