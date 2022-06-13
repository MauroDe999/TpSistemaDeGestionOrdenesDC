package tp.link.ordenes.deCompra.Model;

public class PromoMedioDePago extends Promocion {
	protected String nombreMedioDP;
	protected double porcentajeDescontable;

	@Override
	public boolean aplicable(Cliente cliente, MedioDePago medio) {
		return medio.getNombre().equals(nombreMedioDP);
	}

	@Override
	public double montoDescontado(double montoTotal) {
		return montoTotal * porcentajeDescontable;
	}
	
}
