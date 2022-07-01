package tp.link.ordenes.deCompra.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class PromoCupon extends Promocion{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@OneToOne
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
