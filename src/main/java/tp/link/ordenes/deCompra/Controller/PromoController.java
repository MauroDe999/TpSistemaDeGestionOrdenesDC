package tp.link.ordenes.deCompra.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
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
public class PromoController {
	@Autowired
	private RepoPromos repoProm;
	
	@GetMapping("")
	public Page<Promocion> all(Pageable page){
		return repoProm.findAll(page);
	}
	@GetMapping("/{dni}")
	public Promocion get(@PathVariable("dni") int dniUsu){
		return repoProm.findByDni(dniUsu);
	}
	@PostMapping("")
	public void post(Promocion promo){
		repoProm.save(promo);
	}
	@DeleteMapping("")
	public void delete(Promocion promo) {
		repoProm.delete(promo);
	}
	
}
