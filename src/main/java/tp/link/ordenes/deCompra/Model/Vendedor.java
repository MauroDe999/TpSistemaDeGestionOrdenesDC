package tp.link.ordenes.deCompra.Model;

import java.util.Collection;

public class Vendedor {
	protected Collection<Producto> productos;
	protected Collection<Promocion> promos;
	protected Collection<OrdenDeCompra> ordenes;
	protected double ganancias;
	
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
	public void gestionarOrden(OrdenDeCompra orden) {
		ganancias += orden.getMonto();
		orden.getProductosAC().forEach(x->x.modificarStock());
	}
	/*Cambiar proveedor*/
	public void cambiarProveedor(Proveedor proveedor, Producto producto){
		producto.nuevoProv(proveedor);
	}
	/*Gestion de Productos*/
	public void agregarProducto(Producto nuevoProd) throws Exception {
		this.verificarExistenciaOK(nuevoProd);
		productos.add(nuevoProd);
	}
	public void quitarProducto(Producto prod) throws Exception {
		this.verificarExistenciaNoOK(prod);
		productos.remove(prod);
	}
	public void verificarExistenciaOK(Producto nuevoProd) throws Exception {
		if(productos.contains(nuevoProd)) {
			throw new Exception("Este producto YA existe");
		}
	}
	public void verificarExistenciaNoOK(Producto nuevoProd) throws Exception {
		if(!productos.contains(nuevoProd)) {
			throw new Exception("Este producto NO existe");
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
	
	
}
