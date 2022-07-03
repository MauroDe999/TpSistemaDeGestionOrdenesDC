package tp.link.ordenes.deCompra.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tp.link.ordenes.deCompra.Model.*;
import tp.link.ordenes.deCompra.Repos.*;

@RepositoryRestController
public class VendedorControllerComplement {
	
	@Autowired
	RepoVendedor repoVen;
	@Autowired
	RepoOrdenDeCompra repoODC;
	
	@RequestMapping(method = RequestMethod.POST,value="/vendedores/{nombreVen}/{idOrden}/gestionarOrden")
	public @ResponseBody String gestionarOrden(@PathVariable("idOrden") Integer nombreOrden, @PathVariable("nombreVen")
	String nombreVen) throws Exception {
		
		Vendedor vendedor = repoVen.findByNombre(nombreVen);
		if(vendedor == null) {
			return "vendedor no encontrado";
		}
		
		return "se ha gestionado la orden correctamente"; 
	}
	
	
}
