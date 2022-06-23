package tp.link.ordenes.deCompra.Model;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
@Entity
public class Administrador extends Usuario{
	@Transient
	protected Collection<Promocion> promociones;
	@Transient
	protected Collection<Usuario> usuarios;
	
	@Override
	public String rol() {
		return "Admin";
	}
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
		Collection<Usuario> vendedores = usuarios.stream().filter(x->x.rol().equals("Vendedor")).collect(Collectors.toList());
		vendedores.forEach(x->x.nuevasPromos(promociones));
	}
	
	
	/*     GAS      */
	public Collection<Promocion> getPromociones() {
		return promociones;
	}
	public void setPromociones(Collection<Promocion> promociones) {
		this.promociones = promociones;
	}
	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setVendedores(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Administrador(String mail, String password, Integer id, int dni, Collection<Promocion> promociones,
			Collection<Usuario> usuarios) {
		super(mail, password, id, dni);
		this.promociones = promociones;
		this.usuarios = usuarios;
	}
}
