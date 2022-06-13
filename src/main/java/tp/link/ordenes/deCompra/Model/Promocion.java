package tp.link.ordenes.deCompra.Model;

public class Promocion {
	public boolean aplicable(Cliente cliente, MedioDePago medio) {
		return false;
	};
	public double montoDescontado(double montoTotal) {
		return 0;
	};
}
