package tp.link.ordenes.deCompra.Model;

public class Usuario {
	protected Tipo tipo;
	protected String nombre;
	protected String apellido;
	protected String direccion;
	
	public void agregarAlCarrito(int cantidad, Producto producto) throws Exception {
		this.verificarTipo("cliente");
	}
	
	public void verificarTipo(String tipoEspecifico) throws Exception{
		if(tipo.getTipo() != tipoEspecifico) {
			throw new Exception("Accion permitida para este tipo");
		}
	}
}
