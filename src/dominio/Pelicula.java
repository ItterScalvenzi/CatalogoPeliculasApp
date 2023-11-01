package dominio;

import java.util.Objects;

public class Pelicula {
	
	private String nombre;
	private String anio;
	private String descripcion;
	
	public Pelicula() {}

	public Pelicula(String nombre, String anio, String descripcion) {
		this.nombre = nombre;
		this.anio = anio;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	

	@Override
	public String toString() {
		return "Pelicula [ \n\t Nombre= " + nombre + ",\n\t Año= " + anio + ",\n\t Descripcion= " + descripcion + "]";
	}

	public static void main(String[] args) {
		var pelicula1 = new Pelicula("Batman", "1990", "Batman se enfrenta a el Joker");
		System.out.println(pelicula1);
	}
}
