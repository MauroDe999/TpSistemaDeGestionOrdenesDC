package tp.link.ordenes.deCompra.Model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Promocion {
	
	protected String nombre;
	
	public boolean aplicable(Cliente cliente, Tarjeta tarjeta, Collection<Integer> numeroPromos) {
		return false;
	};
	public double montoDescontado(double montoTotal) {
		return 0;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Promocion(String nombre) {
		super();
		this.nombre = nombre;
	}
}
