package tp.link.ordenes.deCompra.Model;

import java.util.Collection;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;

public class CarritoDeCompra {
	@Transient
	protected Collection<ProductoAComprar> productosAC;
	protected double precioTotal;
	protected Vendedor vendedor;
	
	public void agregar(ProductoAComprar productoAC, double precioProducto) {
		productosAC.add(productoAC);
		precioTotal += precioProducto;
	}
	public void quitar(ProductoAComprar productoAC) throws Exception {
		this.verificarExistencia(productoAC);
		double precioBaseProd = productoAC.getProducto().precioBase(productoAC.getCantidad());
		precioTotal -= precioBaseProd;
		productosAC.remove(productoAC);
	}
	public void vaciar() {
		productosAC.clear();
		precioTotal = 0;
	}
	public void enviarOrden() {
		vendedor.agregarOrden(new OrdenDeCompra(precioTotal, productosAC));
	}
	
	public void verificarExistencia(ProductoAComprar productoAC) throws Exception {
		if(!productosAC.contains(productoAC)) {
			throw new Exception("Este producto no se encuentra dentro del carrito");
		}
	}
	
	/*GettersAndSetters*/
	public Collection<ProductoAComprar> getProductosAC() {
		return productosAC;
	}
	public void setProductosAC(Collection<ProductoAComprar> productosAC) {
		this.productosAC = productosAC;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	
}
