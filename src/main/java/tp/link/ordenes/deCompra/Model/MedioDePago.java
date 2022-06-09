package tp.link.ordenes.deCompra.Model;

public class MedioDePago {
	protected String nombre;
	protected double saldo;
	
	public void gastar(double precioFinal) {
		saldo -= precioFinal;
		
	}
	
	/*GettersAndSetters*/
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
}
