package presentacion;

import java.util.Scanner;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculaLista;

public class CatalogoPeliculasApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		var salir = false;
		
		IServicioPeliculas servicioPeliculas = new ServicioPeliculaLista();
		
		while(!salir) {
			try {
				mostrarMenu();
				salir = ejecutarOpciones(sc, servicioPeliculas);
			} catch(Exception e) {
				System.out.println("Ocurrió un error: " +e.getMessage());
			}
		}
		
//		Pelicula pelicula1 = new Pelicula("Batman Inicia",
//				"1999",
//				"Bruce Wayne descubre sus habilidades para combatir el mal");
//		Pelicula pelicula2 = new Pelicula("Superman regresa",
//				"2001",
//				"Luego de su viaje a Cripton, Superman regresa a la tierra para salvarla"
//				+ "de Lex Luthor");
//		Pelicula pelicula3 = new Pelicula("Spiderman, por los cielos",
//				"2005",
//				"Peter Parker es picado por una araña en un experimento,"
//				+ "y comienza a desarrollar poderes increibles");
//		
//		
//		servicioPeliculas.agregarPelicula(pelicula1);
//		servicioPeliculas.agregarPelicula(pelicula2);
//		servicioPeliculas.agregarPelicula(pelicula3);
//		
//		servicioPeliculas.listarPeliculas();
//		
//		servicioPeliculas.buscarPelicula(pelicula3);
//		servicioPeliculas.buscarPelicula(new Pelicula("Iron Man", "2008", "Tony Stark "
//				+ "desarrolla un traje futurista para salvar el planeta de los Aliens"));
//		
	}

	private static void mostrarMenu() {
		System.out.println();
		System.out.println("***Catalogo de Peliculas***");
		System.out.println("""
				1. Agregar pelicula 
				2. Listar peliculas
				3. Buscar pelicula
				4. Salir
				""");
		
	}
	
	private static boolean ejecutarOpciones(Scanner sc, IServicioPeliculas servicioPeliculas) {
		var salir = false;
		System.out.println("Ingrese una opción: ");
		var opcion = Integer.parseInt(sc.nextLine());
		switch(opcion) {
			case 1 ->{
				System.out.println("Ingrese el nombre de la pelicula: ");
				var nombre = sc.nextLine();
				System.out.println("Ingrese el año de la pelicula: ");
				var anio = sc.nextLine();
				System.out.println("Ingrese una breve descripción de la pelicula: ");
				var descripcion = sc.nextLine();
				Pelicula pelicula = new Pelicula(nombre, anio, descripcion);
				servicioPeliculas.agregarPelicula(pelicula);
				break;
			}
			case 2 ->{
				servicioPeliculas.listarPeliculas();
			}
			case 3 ->{
				System.out.println("Ingrese el nombre de la pelicula: ");
				var buscar = sc.nextLine();
				servicioPeliculas.buscarPelicula(buscar);
				break;
			}
			case 4 ->{
				System.out.println("Hasta pronto...");
				salir = true;
				break;
			}
			default -> System.out.println("Ingrese una opción valida");
		}
		return salir;
	}

}
