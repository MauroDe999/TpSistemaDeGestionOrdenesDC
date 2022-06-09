package tp.link.ordenes.deCompra.Model;

public class PromoCupon implements Promocion{
	protected Cupon cuponPromo;
	
	@Override
	public boolean aplicable(Cliente cliente, MedioDePago medio) {
		return cliente.getCupones().contains(cuponPromo) && cliente.getHoy().before(cuponPromo.fechaLimite);
	}

	@Override
	public double montoDescontado(double montoTotal) {
		return cuponPromo.getMonto();
	}

}
