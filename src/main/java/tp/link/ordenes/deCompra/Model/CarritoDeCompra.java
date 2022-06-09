package tp.link.ordenes.deCompra.Model;

import java.util.Collection;

public class CarritoDeCompra {
	protected Collection<ProductoAComprar> productosAC;
	protected double precioTotal;
	protected Vendedor vendedor;
	
	public void agregar(ProductoAComprar productoAC, double precioProducto) {
		productosAC.add(productoAC);
		precioTotal += precioProducto;
	}
	public void enviarOrden() {
		vendedor.agregarOrden(new OrdenDeCompra(precioTotal, productosAC));
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
