package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculaLista;

public class CatalogoPeliculasApp {

	public static void main(String[] args) {
		Pelicula pelicula1 = new Pelicula("Batman Inicia",
				"1999",
				"Bruce Wayne descubre sus habilidades para combatir el mal");
		Pelicula pelicula2 = new Pelicula("Superman regresa",
				"2001",
				"Luego de su viaje a Cripton, Superman regresa a la tierra para salvarla"
				+ "de Lex Luthor");
		Pelicula pelicula3 = new Pelicula("Spiderman, por los cielos",
				"2005",
				"Peter Parker es picado por una araña en un experimento,"
				+ "y comienza a desarrollar poderes increibles");
		
		IServicioPeliculas servicioPeliculas = new ServicioPeliculaLista();
		servicioPeliculas.agregarPelicula(pelicula1);
		servicioPeliculas.agregarPelicula(pelicula2);
		servicioPeliculas.agregarPelicula(pelicula3);
		
		servicioPeliculas.listarPeliculas();
		
		servicioPeliculas.buscarPelicula(pelicula3);
		servicioPeliculas.buscarPelicula(new Pelicula("Iron Man", "2008", "Tony Stark "
				+ "desarrolla un traje futurista para salvar el planeta de los Aliens"));
		
	}
}
