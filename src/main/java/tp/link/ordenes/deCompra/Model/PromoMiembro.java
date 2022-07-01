package tp.link.ordenes.deCompra.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PromoMiembro extends Promocion{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@Column
	protected double porcentajeDescontable;
	
	@Override
	public boolean aplicable(Cliente cliente, Tarjeta tarjeta) {
		return cliente.isEsMiembro();
	}

	@Override
	public double montoDescontado(double montoTotal) {
		return montoTotal * porcentajeDescontable;
	}

}
