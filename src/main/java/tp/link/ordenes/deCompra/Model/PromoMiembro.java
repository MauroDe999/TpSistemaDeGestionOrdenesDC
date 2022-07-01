package tp.link.ordenes.deCompra.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PromoMiembro extends Promocion{
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
