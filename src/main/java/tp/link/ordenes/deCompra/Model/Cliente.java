package tp.link.ordenes.deCompra.Model;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class Cliente {
	protected String nombre;
	protected CarritoDeCompra carrito;
	protected Collection<Tarjeta> tarjetas;
	protected boolean esMiembro;
	protected Dinero efectivo;
	protected Collection<Cupon> cupones;
	protected Date hoy = new Date();
	
	public void pagar(MedioDePago medio) throws Exception {
		double precioFinal =this.precioFinal(carrito.getVendedor().getPromos(), medio);
		this.verificarCostoCompra(medio, precioFinal);
		medio.gastar(precioFinal);
		this.generarOrden();
	}
	
	public void agregarAlCarrito(int cantidad, Producto producto) throws Exception {
		producto.getVendedor().verificarCantAbsurda(cantidad);
		producto.getVendedor().verificarCantEnStock(cantidad, producto);
		carrito.agregar(new ProductoAComprar(producto, cantidad), producto.precioBase(cantidad, producto));
	}
	
	public double precioFinal(Collection<Promocion> promos, MedioDePago medio) {
		Collection<Promocion> promosDisponibles = promos.stream().filter(x->x.aplicable(this, medio)).collect(Collectors.toList());
		double montoFinal = carrito.getPrecioTotal();
		for(Promocion promo:promosDisponibles) {
			montoFinal -= promo.montoDescontado(montoFinal);
		}
		return montoFinal;
	}
	
	public void verificarCostoCompra(MedioDePago medio, double precioFinal) throws Exception{
		if(medio.getSaldo() < precioFinal) {
			throw new Exception("No alcanza dinero para la compra");
		}
	}
	
	public void generarOrden(){
		carrito.enviarOrden();
	}
	
	/*GettersAndSetters*/
	
	public Cliente(String nombre, CarritoDeCompra carrito, Collection<Tarjeta> tarjetas, boolean esMiembro,
			Dinero efectivo, Collection<Cupon> cupones, Date hoy) {
		super();
		this.nombre = nombre;
		this.carrito = carrito;
		this.tarjetas = tarjetas;
		this.esMiembro = esMiembro;
		this.efectivo = efectivo;
		this.cupones = cupones;
		this.hoy = hoy;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Dinero getEfectivo() {
		return efectivo;
	}

	public void setEfectivo(Dinero efectivo) {
		this.efectivo = efectivo;
	}

	public Collection<Cupon> getCupones() {
		return cupones;
	}

	public void setCupones(Collection<Cupon> cupones) {
		this.cupones = cupones;
	}

	public Date getHoy() {
		return hoy;
	}

	public void setHoy(Date hoy) {
		this.hoy = hoy;
	}
	
	
}
