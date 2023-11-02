package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import dominio.Pelicula;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

	private final String NOMBRE_ARCHIVO = "catalogoPeliculas.txt";
	
	public ServicioPeliculasArchivo() {
		var archivo = new File(NOMBRE_ARCHIVO);
		try {
			//Si ya existe el archivo no se vuelve a crear
			if(archivo.exists()) {
				System.out.println("El archivo ya existe");
			} else {
				//Si no existe se crea vacio
				var salida = new PrintWriter(new FileWriter(archivo));
				salida.close();
				System.out.println("Se ha creado el archivo");
			}
			
		} catch(Exception e) {
			System.out.println("Ocurrió un error al abrir el archivo: " +NOMBRE_ARCHIVO+ " - " + e.getMessage());
		}
	}
	
	@Override
	public void listarPeliculas() {
		//Volvemos a abrir el archivo
		var archivo = new File(NOMBRE_ARCHIVO);
		try {
			System.out.println("Listado de Peliculas");
			//Abrimos el archivo para lectura
			var entrada = new BufferedReader(new FileReader(archivo));
			
			String linea = entrada.readLine();
			//Como debemos leer la linea correspondiente al nombre, año, edad, creamos las variables con 
			//valor nulo y en cada ciclo le asignamos la linea correspondiente
			String nombre = null;
			String anio = null;
			String descripcion = null;
			 
			while(linea != null) {
				if(nombre == null) {
					nombre = linea;
				} else if(anio == null) {
					anio = linea;
					} else {
						descripcion = linea;
						Pelicula pelicula = new Pelicula(nombre, anio, descripcion);
						System.out.println(pelicula);
						nombre = null;
						anio = null;
						descripcion = null;
					}
				linea = entrada.readLine();
			}
			entrada.close();
		} catch (Exception e) {
			System.out.println("Ocurrío un error al leer el archivo: " +e.getMessage());
		}
		
	}

	@Override
	public void agregarPelicula(Pelicula pelicula) {
		boolean anexar = false;
		var archivo = new File(NOMBRE_ARCHIVO);
		try {
			//Revisar si existe el archivo
			anexar = archivo.exists();
			var salida = new PrintWriter(new FileWriter(archivo, anexar)); 
			//Agregamos la pelicula (toString)
			salida.println(pelicula);
			salida.close();
			System.out.println("Se agregó al archivo la pelicula : " +pelicula.getNombre());
			
		} catch (Exception e) {
			System.out.println("Ocurrió un error al escribir el archivo: "+ e.getMessage());
		}
		
	}

	@Override
	public void buscarPelicula(String nombreABuscar) {
		var archivo = new File(NOMBRE_ARCHIVO);
		try {
			//Abrimos el archivo linea a linea
			var entrada = new BufferedReader(new FileReader(archivo));
			String lineaTexto;
			lineaTexto = entrada.readLine();
			var encontrada = false;
			String nombre = null;
			String anio = null;
			String descripcion = null;
			//Como debemos leer la linea correspondiente al nombre, creamos las variables con 
			//valor nulo y en cada ciclo le asignamos la linea correspondiente.
			//De esa forma nos aseguramos que compara solamente con la linea del nombre
			while(lineaTexto != null) {
				if(nombre == null) {
					nombre = lineaTexto;
				} else if(anio == null) {
					anio = lineaTexto;
					} else {
						descripcion = lineaTexto;
						if(nombreABuscar.equalsIgnoreCase(nombre)) {
							encontrada = true;
							break;
						}
						
						nombre = null;
						anio = null;
						descripcion = null;
					}
				lineaTexto = entrada.readLine();
			}
			if(encontrada) {
				System.out.println("Pelicula encontrada!");
				System.out.println("Nombre: " +nombre);
				System.out.println("Año: " +anio);
				System.out.println("Descripcion: " +descripcion);
			} else {
				System.out.println("Lo siento, no se encuentra la pelicula "
						+nombreABuscar+ " en el archivo");
			}
			entrada.close();
			
		} catch(Exception e) {
			System.out.println("Ocurrió un error al buscar en el archivo: " +e.getMessage());
		}
		
	}

}
