package tp.link.ordenes.deCompra.Model;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Vendedor extends Usuario{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@OneToMany
	@Column
	protected Collection<Producto> productos;
	@OneToMany
	@Column
	protected Collection<Promocion> promos;
	@OneToMany
	@Column
	protected Collection<OrdenDeCompra> ordenes;
	@Column
	protected double ganancias;
	protected String nombre;
	
	@Override
	public String rol() {
		return "Vendedor";
	}
	public void verificarCantAbsurda(int cantidad) throws Exception {
		if(cantidad <= 0) {
			throw new Exception("Cantidad invalida, agregar una mayor a cero");
		}
	}
	public void verificarCantEnStock(int cantidad, Producto producto) throws Exception{
		if(producto.getStock()-cantidad <= 0) {
			throw new Exception("No se posee stock suficiente para satisfacer compra");
		}
	}
	/*Ordenes*/
	public void agregarOrden(OrdenDeCompra orden){
		ordenes.add(orden);
	}
	public void gestionarOrden(OrdenDeCompra orden) throws Exception {
		this.verificarExistOrdenOk(orden);
		ganancias += orden.getMonto();
		orden.getProductosAC().forEach(x->x.modificarStock());
		ordenes.remove(orden);
	}
	/*Cambiar proveedor*/
	public void cambiarProveedor(String proveedor, Producto producto){
		producto.nuevoProv(proveedor);
	}
	/*Gestion de Productos*/
	public void agregarProducto(Producto nuevoProd) throws Exception {
		this.verificarExistProdOK(nuevoProd);
		productos.add(nuevoProd);
	}
	public void quitarProducto(Producto prod) throws Exception {
		this.verificarExistProdNoOK(prod);
		productos.remove(prod);
	}
	public void verificarExistProdOK(Producto nuevoProd) throws Exception {
		if(productos.contains(nuevoProd)) {
			throw new Exception("Este producto YA existe");
		}
	}
	public void verificarExistProdNoOK(Producto nuevoProd) throws Exception {
		if(!productos.contains(nuevoProd)) {
			throw new Exception("Este producto NO existe");
		}
	}
	public void verificarExistOrdenOk(OrdenDeCompra orden) throws Exception{
		if(!ordenes.contains(orden)) {
			throw new Exception("Esta orden NO existe");
		}
	}
	
	/*Recibir promos de admin*/
	public void nuevasPromos(Collection<Promocion> nuevasPromos) {
		promos = nuevasPromos;
	}
	
	/*        */
	public Collection<Producto> getProductos() {
		return productos;
	}
	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}
	public Collection<Promocion> getPromos() {
		return promos;
	}
	public void setPromos(Collection<Promocion> promos) {
		this.promos = promos;
	}
	public Collection<OrdenDeCompra> getOrdenes() {
		return ordenes;
	}
	public void setOrdenes(Collection<OrdenDeCompra> ordenes) {
		this.ordenes = ordenes;
	}
	public Vendedor(String mail, String password, int dni, Collection<Producto> productos, Collection<Promocion> promos,
			Collection<OrdenDeCompra> ordenes, double ganancias, String nombre) {
		super(mail, password, dni);
		this.productos = productos;
		this.promos = promos;
		this.ordenes = ordenes;
		this.ganancias = ganancias;
		this.nombre = nombre;
	}
	
}
