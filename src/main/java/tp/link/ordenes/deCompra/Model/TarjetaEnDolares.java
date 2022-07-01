package tp.link.ordenes.deCompra.Model;

import javax.persistence.*;

@Entity
public class TarjetaEnDolares extends Tarjeta{
	@Column
	protected double conversionAPesos;
	
	@Override
	public void gastar(double precioFinal) {
		saldo -= (precioFinal / conversionAPesos);
	}
	@Override
	public void verificarCostoCompra(double precioFinal) throws Exception{
		if(saldo < (precioFinal / conversionAPesos)) {
			throw new Exception("No alcanza dinero para la compra");
		}
	}

	public TarjetaEnDolares(String nombre, double saldo, boolean habilitada, double conversionAPesos) {
		super(nombre, saldo, habilitada);
		this.conversionAPesos = conversionAPesos;
	}
}
