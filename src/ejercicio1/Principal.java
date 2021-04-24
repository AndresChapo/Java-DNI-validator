package ejercicio1;

import java.util.LinkedList;


public class Principal {

	public static void main(String[] args) {

		Archivo archivo = new Archivo();
		archivo.setRuta("Personas.txt"); //prueba.txt
		LinkedList<Persona> listadoPersonas = new LinkedList<Persona>();
		LinkedList<String> listado = new LinkedList<String>();
		Funciones fun = new Funciones();
		
		if(archivo.existe())
		{
			System.out.println("Archivo encontrado");
		}
		else
		{
			System.out.println("No existe archivo entonces lo creo");
			archivo.creaArchivo();
		}
		

		//LECTURA:
		System.out.println("A CONTINUACIÓN LEE DE A LINEAS: ");
//		archivo.lee_lineas();
		archivo.cargaArchivoEnListado(listado);
		fun.cargarListadoEnPersonas(listado, listadoPersonas);
		
		System.out.println("---MOSTRANDO CONTENIDO DEL OBJETO listadoPersonas---");
		for(Persona per:listadoPersonas) {
			System.out.println(per.getNombre() +" "+ per.getApellido()+" "+ per.getDni());
		}
		System.out.println("---------");
		//ESCRITURA:
//		archivo.escribe_lineas("\nUniversidad Tecnologica Nacional");
	}

}
