package tp.link.ordenes.deCompra.Model;

public class PromoMiembro extends Promocion{
	protected double porcentajeDescontable;
	
	@Override
	public boolean aplicable(Cliente cliente, MedioDePago medio) {
		return cliente.isEsMiembro();
	}

	@Override
	public double montoDescontado(double montoTotal) {
		return montoTotal * porcentajeDescontable;
	}

}
