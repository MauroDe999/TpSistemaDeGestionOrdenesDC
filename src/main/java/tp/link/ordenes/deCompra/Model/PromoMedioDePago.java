package tp.link.ordenes.deCompra.Model;

public class PromoMedioDePago extends Promocion {
	protected String nombreTarjeta;
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
