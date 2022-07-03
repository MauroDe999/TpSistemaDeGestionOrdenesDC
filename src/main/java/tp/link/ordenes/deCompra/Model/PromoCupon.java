package tp.link.ordenes.deCompra.Model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
public class PromoCupon extends Promocion{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@OneToOne
	protected Cupon cuponPromo;
	
	@Override
	public boolean aplicable(Cliente cliente, Tarjeta tarjeta, Collection<Integer> numeroPromos) {
		Date hoy = new Date();
		return numeroPromos.contains(cuponPromo.getNumero()) && hoy.before(cuponPromo.fechaLimite);
	}

	@Override
	public double montoDescontado(double montoTotal) {
		return cuponPromo.getMonto();
	}

	public PromoCupon(String nombre, Cupon cuponPromo) {
		super(nombre);
		this.cuponPromo = cuponPromo;
	}
	
}
