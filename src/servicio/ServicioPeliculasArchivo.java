package servicio;

import java.io.File;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarPelicula(String nombre) {
		// TODO Auto-generated method stub
		
	}

}
