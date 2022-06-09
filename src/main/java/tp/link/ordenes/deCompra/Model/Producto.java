package tp.link.ordenes.deCompra.Model;

public class Producto {
	protected String nombre;
	protected int stock;
	protected Proveedor proveedor;
	protected Vendedor vendedor;
	protected double precio;
	/*                 */
	
	public double precioBase(int cantidad, Producto producto) {
		return precio * cantidad;
	}
	public void modificar(int cantidad){
		stock -= cantidad;
	}
	public void nuevoProv(Proveedor nuevoProveedor) {
		proveedor = nuevoProveedor;
	}
	
	
	
	/*GettersAndSetters*/
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
