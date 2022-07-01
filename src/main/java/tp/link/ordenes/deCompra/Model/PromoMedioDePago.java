package tp.link.ordenes.deCompra.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PromoMedioDePago extends Promocion {
	@Column
	protected String nombreTarjeta;
	@Column
	protected double porcentajeDescontable;

	@Override
	public boolean aplicable(Cliente cliente, Tarjeta tarjeta) {
		return tarjeta.getNombre().equals(nombreTarjeta);
	}

	@Override
	public double montoDescontado(double montoTotal) {
		return montoTotal * porcentajeDescontable;
	}
	
}
