package tp.link.ordenes.deCompra.Model;

import java.util.Collection;

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
	public boolean aplicable(Cliente cliente, Tarjeta tarjeta, Collection<Integer> numeroPromos) {
		return cliente.isEsMiembro();
	}

	@Override
	public double montoDescontado(double montoTotal) {
		return montoTotal * porcentajeDescontable;
	}

	public PromoMiembro(String nombre, double porcentajeDescontable) {
		super(nombre);
		this.porcentajeDescontable = porcentajeDescontable;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPorcentajeDescontable() {
		return porcentajeDescontable;
	}

	public void setPorcentajeDescontable(double porcentajeDescontable) {
		this.porcentajeDescontable = porcentajeDescontable;
	}
	
}
