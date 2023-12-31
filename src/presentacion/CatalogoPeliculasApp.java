package presentacion;

import java.util.Scanner;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivo;

public class CatalogoPeliculasApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		var salir = false;
		
		//IServicioPeliculas servicioPeliculas = new ServicioPeliculaLista();
		IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();
		
		while(!salir) {
			try {
				mostrarMenu();
				salir = ejecutarOpciones(sc, servicioPeliculas);
			} catch(Exception e) {
				System.out.println("Ocurri� un error: " +e.getMessage());
			}
		}
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
		System.out.println("Ingrese una opci�n: ");
		var opcion = Integer.parseInt(sc.nextLine());
		switch(opcion) {
			case 1 ->{
				System.out.println("Ingrese el nombre de la pelicula: ");
				var nombre = sc.nextLine();
				System.out.println("Ingrese el a�o de la pelicula: ");
				var anio = sc.nextLine();
				System.out.println("Ingrese una breve descripci�n de la pelicula: ");
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
			default -> System.out.println("Ingrese una opci�n valida");
		}
		return salir;
	}
}
