package tp.link.ordenes.deCompra.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
@Entity
public class Producto {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	protected Integer id;
	@Column
	protected String nombre;
	@Column
	protected int stock;
	@Column
	protected String proveedor;
	@ManyToOne
	@JoinColumn
	protected Vendedor vendedor;
	@Column
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
