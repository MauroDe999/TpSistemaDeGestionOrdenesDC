package tp.link.ordenes.deCompra.Model;

import java.util.Date;

public class PromoCupon extends Promocion{
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
