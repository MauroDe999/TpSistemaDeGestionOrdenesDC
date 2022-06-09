package tp.link.ordenes.deCompra.Model;

import java.util.Collection;

public class OrdenDeCompra {
	protected double monto;
	protected Collection<ProductoAComprar> productosAC;
	
	
	public OrdenDeCompra(double monto, Collection<ProductoAComprar> productosAC) {
		super();
		this.monto = monto;
		this.productosAC = productosAC;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Collection<ProductoAComprar> getProductosAC() {
		return productosAC;
	}
	public void setProductosAC(Collection<ProductoAComprar> productosAC) {
		this.productosAC = productosAC;
	}
	
	
	
}
