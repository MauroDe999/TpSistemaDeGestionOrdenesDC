package tp.link.ordenes.deCompra.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PromoCupon extends Promocion{
	@Column
	protected Cupon cuponPromo;
	
	@Override
	public boolean aplicable(Cliente cliente, Tarjeta tarjeta) {
		Date hoy = new Date();
		return cliente.getCupones().contains(cuponPromo) && hoy.before(cuponPromo.fechaLimite);
	}

	@Override
	public double montoDescontado(double montoTotal) {
		return cuponPromo.getMonto();
	}

}
