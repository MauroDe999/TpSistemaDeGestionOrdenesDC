package tp.link.ordenes.deCompra.Model;

public interface Promocion {
	public boolean aplicable(Cliente cliente, MedioDePago medio);
	public double montoDescontado(double montoTotal);
}
