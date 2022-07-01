package tp.link.ordenes.deCompra.Model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrdenDeCompra {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	protected Integer id;
	@Column
	protected double monto;
	@OneToMany
	@Column
	protected Collection<ProductoAComprar> productosAC;
	
	
	public OrdenDeCompra(double monto, Collection<ProductoAComprar> productosAC) {
		super();
		this.monto = monto;
		this.productosAC = productosAC;
	}
	public OrdenDeCompra() {
		super();
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
