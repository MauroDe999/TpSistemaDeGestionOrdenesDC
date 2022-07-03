package tp.link.ordenes.deCompra.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Cupon {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@Column
	protected Date fechaLimite;
	@OneToOne
	protected Producto productoCupon;
	@Column
	protected Integer numero;
	@Column
	protected double monto;
	
	public Date getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	public Producto getProductoCupon() {
		return productoCupon;
	}
	public void setProductoCupon(Producto productoCupon) {
		this.productoCupon = productoCupon;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Cupon() {
		super();
	}
	public Cupon(Date fechaLimite, Producto productoCupon, Integer numero, double monto) {
		super();
		this.fechaLimite = fechaLimite;
		this.productoCupon = productoCupon;
		this.numero = numero;
		this.monto = monto;
	}
}
