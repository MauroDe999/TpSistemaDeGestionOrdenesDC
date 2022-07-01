package tp.link.ordenes.deCompra.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Promocion {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	protected Integer id;
	
	public boolean aplicable(Cliente cliente, Tarjeta tarjeta) {
		return false;
	};
	public double montoDescontado(double montoTotal) {
		return 0;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	};
	
	
}
