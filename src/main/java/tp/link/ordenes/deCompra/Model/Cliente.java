package tp.link.ordenes.deCompra.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.*;

@Entity
public class Cliente extends Usuario{
	@OneToOne
	protected CarritoDeCompra carrito = new CarritoDeCompra(new ArrayList<ProductoAComprar>(), 0, null);
	protected boolean esMiembro;
	protected Tarjeta tarjeta;
	protected Collection<Integer> numeroCupones;
	
	@Override
	public String rol() {
		return "Cliente";
	}
	public void pagar() throws Exception {
		Collection<Promocion> promosV = carrito.getVendedor().getPromos();
		double precioFinal =this.precioFinal(promosV, numeroCupones, tarjeta);
		tarjeta.verificarHabilitada();
		tarjeta.verificarCostoCompra(precioFinal);
		tarjeta.gastar(precioFinal);
		this.generarOrden();
		carrito.vaciar();
	}
	public void quitarDelCarrito(ProductoAComprar productoAC) throws Exception {
		carrito.quitar(productoAC);
	}
	public void agregarAlCarrito(int cantidad, Producto producto) throws Exception {
		this.verificarVacio(producto.getVendedor());
		producto.getVendedor().verificarCantAbsurda(cantidad);
		producto.getVendedor().verificarCantEnStock(cantidad, producto);
		carrito.agregar(new ProductoAComprar(producto, cantidad), producto.precioBase(cantidad));
	}
	
	public double precioFinal(Collection<Promocion> promos,Collection<Integer> numeroCupones, Tarjeta tarjeta) {
		Collection<Promocion> promosDisponibles = promos.stream().filter(x->x.aplicable(this, tarjeta, numeroCupones)).collect(Collectors.toList());
		double montoFinal = carrito.getPrecioTotal();
		for(Promocion promo:promosDisponibles) {
			montoFinal -= promo.montoDescontado(montoFinal);
		}
		return montoFinal;
	}
	public void generarOrden(){
		carrito.enviarOrden();
	}
	
	public void verificarVacio(Vendedor vendedor) throws Exception {
		if(carrito.getVendedor() == null) {
			carrito = new CarritoDeCompra(new ArrayList<ProductoAComprar>(), 0, vendedor);
		}
		else {
			if(carrito.getVendedor() == vendedor) {
				throw new Exception("NO se puede agregar productos de otro vendedor");
			}
		}
	}
	/*GettersAndSetters*/
	
	
	public Cliente() {
		super();
	}
	public Cliente(String mail, String password, int dni, CarritoDeCompra carrito, boolean esMiembro, Tarjeta tarjeta,
			Collection<Integer> numeroCupones) {
		super(mail, password, dni);
		this.carrito = carrito;
		this.esMiembro = esMiembro;
		this.tarjeta = tarjeta;
		this.numeroCupones = numeroCupones;
	}
	public CarritoDeCompra getCarrito() {
		return carrito;
	}
	public void setCarrito(CarritoDeCompra carrito) {
		this.carrito = carrito;
	}

	public boolean isEsMiembro() {
		return esMiembro;
	}

	public void setEsMiembro(boolean esMiembro) {
		this.esMiembro = esMiembro;
	}
}
