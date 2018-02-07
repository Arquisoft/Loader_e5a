package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nombre;
	private int[] localizacion; //igual es buena idea crear una clase
	private String email;
	private String identificador; //Es unico y es el nombre de usuario
	private String password;
	private int tipo;

	/**
	 * Constructor vacio
	 */
	Usuario() {
	}
	
	/**
	 * Constructor
	 * @param nombre
	 * @param localizacion
	 * @param email
	 * @param identificador
	 * @param tipo
	 */
	public Usuario(String nombre, int[] localizacion, String email, String identificador, int tipo) {
		setNombre(nombre);
		setLocalizacion(localizacion);
		setEmail(email);
		setIdentificador(identificador);
		setTipo(tipo);
		generarPassword();
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getLocalizacion() {
		return localizacion;
	}

	private void setLocalizacion(int[] localizacion) {
		this.localizacion = localizacion;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public String getIdentificador() {
		return identificador;
	}

	private void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	public int getTipo() {
		return tipo;
	}

	private void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id =" + id + ", nombre=" + nombre + ", localizacion=" + localizacion + ", email=" + email
				+ ", identificador=" + identificador + ", tipo=" + tipo + "]";
	}

	private void generarPassword() {
		StringBuffer pass = new StringBuffer();
		int low = 65;
		int top = 90;
		for (int i = 0; i < 9; i++) {
			int numAleatorio = (int) Math.floor(Math.random() * (top - low) + low);
			pass.append((char) numAleatorio);
		}
		for (int i = 0; i < 3; i++) {
			int numAleatorio = (int) Math.floor(Math.random() * (9 - 0) + 0);
			pass.append(numAleatorio);
		}
		setPassword(pass.toString());
	}
}

