package tp.link.ordenes.deCompra.Model;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.*;

@Entity
public class Cliente extends Usuario{
	@OneToOne
	protected CarritoDeCompra carrito;
	@OneToMany
	protected Collection<Tarjeta> tarjetas;
	protected boolean esMiembro;
	@OneToMany
	protected Collection<Cupon> cupones;
	
	@Override
	public String rol() {
		return "Cliente";
	}
	public void pagar(Tarjeta tarjeta) throws Exception {
		double precioFinal =this.precioFinal(carrito.getVendedor().getPromos(), tarjeta);
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
		producto.getVendedor().verificarCantAbsurda(cantidad);
		producto.getVendedor().verificarCantEnStock(cantidad, producto);
		carrito.agregar(new ProductoAComprar(producto, cantidad), producto.precioBase(cantidad));
	}
	
	public double precioFinal(Collection<Promocion> promos, Tarjeta tarjeta) {
		Collection<Promocion> promosDisponibles = promos.stream().filter(x->x.aplicable(this, tarjeta)).collect(Collectors.toList());
		double montoFinal = carrito.getPrecioTotal();
		for(Promocion promo:promosDisponibles) {
			montoFinal -= promo.montoDescontado(montoFinal);
		}
		return montoFinal;
	}
	public void generarOrden(){
		carrito.enviarOrden();
	}
	
	/*GettersAndSetters*/
	
	public Cliente(String mail, String password, Integer id, int dni, CarritoDeCompra carrito, Collection<Tarjeta> tarjetas,
			boolean esMiembro, Collection<Cupon> cupones) {
		super(mail, password, id, dni);
		this.carrito = carrito;
		this.tarjetas = tarjetas;
		this.esMiembro = esMiembro;
		this.cupones = cupones;
	}
	public Cliente() {
		super();
	}
	public CarritoDeCompra getCarrito() {
		return carrito;
	}
	public void setCarrito(CarritoDeCompra carrito) {
		this.carrito = carrito;
	}

	public Collection<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(Collection<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public boolean isEsMiembro() {
		return esMiembro;
	}

	public void setEsMiembro(boolean esMiembro) {
		this.esMiembro = esMiembro;
	}

	public Collection<Cupon> getCupones() {
		return cupones;
	}

	public void setCupones(Collection<Cupon> cupones) {
		this.cupones = cupones;
	}
}
