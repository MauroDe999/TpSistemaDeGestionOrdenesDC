package tp.link.ordenes.deCompra.Model;

import java.util.Date;

public class Cupon {
	protected Date fechaLimite;
	protected Producto productoCupon;
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
	
	
}
