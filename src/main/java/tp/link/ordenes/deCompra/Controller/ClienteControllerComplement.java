package tp.link.ordenes.deCompra.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tp.link.ordenes.deCompra.Model.Cliente;
import tp.link.ordenes.deCompra.Model.Producto;
import tp.link.ordenes.deCompra.Repos.RepoCliente;
import tp.link.ordenes.deCompra.Repos.RepoProducto;

@RepositoryRestController
public class ClienteControllerComplement {
	
	@Autowired
	private RepoCliente repoCli;
	@Autowired
	private RepoProducto repoProd;
	
	/*El cliente paga por los productos que tiene en el carrito de compras*/
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/clientes/{mailCliente}/pagar")
	public @ResponseBody String pagar(@PathVariable("mailCliente") String mailCliente) throws Exception {
		
		Cliente cliente = repoCli.findByMail(mailCliente);
		if(cliente == null) {
			return "cliente no encontrado";
		}
		
		cliente.pagar();
		
		return "se ha realizado el pago correctamente"; 
	}
	/*Agrega producto al carrito de compras de un cliente*/
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/clientes/{mailCliente}/{nombreProd}/{cantidad}/agregarAlCarrito")
	public @ResponseBody String agregarAlCarrito(@PathVariable("mailCliente") String mailCliente,
		@PathVariable("nombreProd") String nombreProd, @PathVariable("cantidad") int cantidad) throws Exception{
		Producto productoElegido = repoProd.findByNombre(nombreProd);
		if(productoElegido == null) {
			return "producto no encontrado";
		}
		Cliente cliente = repoCli.findByMail(mailCliente);
		if(cliente == null) {
			return "cliente no encontrado";
		}
        cliente.agregarAlCarrito(cantidad, productoElegido);
		
		return "Se Agregó al carrito";
	}
}
