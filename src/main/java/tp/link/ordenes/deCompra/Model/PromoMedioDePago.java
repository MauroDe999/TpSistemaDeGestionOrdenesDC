package tp.link.ordenes.deCompra.Model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PromoMedioDePago extends Promocion {
	@Column
	protected String nombreTarjeta;
	@Column
	protected double porcentajeDescontable;

	@Override
	public boolean aplicable(Cliente cliente, Tarjeta tarjeta, Collection<Integer> numeroPromos) {
		return tarjeta.getNombre().equals(nombreTarjeta);
	}

	@Override
	public double montoDescontado(double montoTotal) {
		return montoTotal * porcentajeDescontable;
	}

	public PromoMedioDePago(String nombre, String nombreTarjeta, double porcentajeDescontable) {
		super(nombre);
		this.nombreTarjeta = nombreTarjeta;
		this.porcentajeDescontable = porcentajeDescontable;
	}

	
	
}
