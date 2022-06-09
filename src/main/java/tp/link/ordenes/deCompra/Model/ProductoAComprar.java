package tp.link.ordenes.deCompra.Model;

public class ProductoAComprar {
	protected Producto producto;
	protected int cantidad;
	
	
	public void modificarStock() {
		producto.modificar(cantidad);
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public ProductoAComprar(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	
}
