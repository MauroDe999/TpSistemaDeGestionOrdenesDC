package tp.link.ordenes.deCompra.Model;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
public class Tarjeta {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@Column
	protected String nombre;
	@Column
	protected double saldo;
	@Column
	protected boolean habilitada;
	
	public void gastar(double precioFinal) {
		saldo -= precioFinal;
	}
	public void verificarHabilitada() throws Exception {
		if(!habilitada) {
			throw new Exception("Medio de pago inhabilitado");
		}
	}
	public void verificarCostoCompra(double precioFinal) throws Exception{
		if(saldo < precioFinal) {
			throw new Exception("No alcanza dinero para la compra");
		}
	}
	/*     GAS     */
	public Tarjeta(String nombre, double saldo, boolean habilitada) {
		super();
		this.nombre = nombre;
		this.saldo = saldo;
		this.habilitada = habilitada;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public boolean isHabilitada() {
		return habilitada;
	}
	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}
	
	
}
