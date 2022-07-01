package tp.link.ordenes.deCompra.Model;

import javax.persistence.*;
@Entity
public class ProductoAComprar {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@OneToOne
	protected Producto producto;
	@Column
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProductoAComprar() {
		super();
	}
	public ProductoAComprar(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
}
