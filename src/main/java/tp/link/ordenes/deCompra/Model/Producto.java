package tp.link.ordenes.deCompra.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
@Entity
public class Producto {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	protected String nombre;
	@Min(0)
	protected int stock;
	@OneToMany
	protected String proveedor;
	protected Vendedor vendedor;
	protected double precio;
	/*                 */
	
	public double precioBase(int cantidad) {
		return precio * cantidad;
	}
	public void modificar(int cantidad){
		stock -= cantidad;
	}
	public void nuevoProv(String nuevoProveedor) {
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
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
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
