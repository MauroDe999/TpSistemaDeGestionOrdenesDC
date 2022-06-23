package tp.link.ordenes.deCompra.Model;

public class Promocion {
	public boolean aplicable(Cliente cliente, Tarjeta tarjeta) {
		return false;
	};
	public double montoDescontado(double montoTotal) {
		return 0;
	};
}
