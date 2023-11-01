package servicio;

import java.util.ArrayList;
import java.util.List;

import dominio.Pelicula;

public class ServicioPeliculaLista implements IServicioPeliculas {

	private final List<Pelicula> peliculas;
	
	public ServicioPeliculaLista() {
		this.peliculas = new ArrayList<>();
	}

	@Override
	public void listarPeliculas() {
		System.out.println("\n\t***** Listado de Peliculas*** \n");
		peliculas.forEach(System.out::println);
	}

	@Override
	public void agregarPelicula(Pelicula pelicula) {
		peliculas.add(pelicula);
		System.out.println("Se agreg� la pelicula " +pelicula.getNombre()+ " con �xito");
	}

	@Override
	public void buscarPelicula(String nombre) {
		boolean encontrada = false;
		
		for(Pelicula pelicula : peliculas) {
			if (pelicula.getNombre().equalsIgnoreCase(nombre)) {
				int indice = peliculas.indexOf(pelicula);
				System.out.println("\nBuscando pelicula...");
				System.out.println("La pelicula \"" +pelicula.getNombre()+ "\" se encuentra "
							+ "en el indice " +indice);
				encontrada = true;
			}
		}
			if(!encontrada) {
				System.out.println("No se encontr� la pelicula \"" +nombre+ "\"");
			}
				
	}

}
