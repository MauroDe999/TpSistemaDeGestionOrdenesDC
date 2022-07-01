package tp.link.ordenes.deCompra.Model;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.*;

@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@NotBlank
	@Column
	protected String mail;
	@Column
	protected String password;
	@Column
	protected int dni;
	
	public void nuevasPromos(Collection<Promocion> promociones) {}
	
	public String rol() {
		return "";
	}
	
	/* GAT */
	
	public Usuario(String mail, String password, Integer id, int dni) {
		super();
		this.mail = mail;
		this.password = password;
		this.id = id;
		this.dni = dni;
	}
	protected Usuario() {
		super();
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
}
