package tp.link.ordenes.deCompra.Model;

import java.util.Collection;

public class Administrador extends Tipo{
	protected Collection<Promocion> promociones;
	protected Collection<Vendedor> vendedores;
	
	public void agregarPromos(Promocion nuevaPromo) {
		promociones.add(nuevaPromo);
	}
	public void quitarPromo(Promocion promo) throws Exception {
		this.verificarExistencia(promo);
	}
	public void verificarExistencia(Promocion promo) throws Exception{
		if(!promociones.contains(promo)){
			throw new Exception("Esta promo no existe, por favor ingrese una promo existente");
		}
	}
	public void enviarPromos(){
		vendedores.forEach(x->x.nuevasPromos(promociones));
	}
}
