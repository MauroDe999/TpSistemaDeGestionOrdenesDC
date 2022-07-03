package tp.link.ordenes.deCompra.Model;

import javax.persistence.*;

@Entity
public class TarjetaEnDolares extends Tarjeta{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
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

	public TarjetaEnDolares(String nombre, int numero, double saldo, boolean habilitada, double conversionAPesos) {
		super(nombre, numero, saldo, habilitada);
		this.conversionAPesos = conversionAPesos;
	}
}
