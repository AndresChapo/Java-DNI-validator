package ejercicio1;

import java.util.LinkedList;
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Archivo archivo = new Archivo();

		LinkedList<Persona> listadoPersonas = new LinkedList<Persona>();
		LinkedList<String> listado = new LinkedList<String>();
		Funciones fun = new Funciones();
		
		
		String opcion = "";
		while(opcion !=  "0"){
			 System.out.println("----------------------------");	
			 System.out.println("1. Cargar archivo Personas.txt (filtrando repetidos y DNI invalidos)");
			 System.out.println("2. Mostrar listadoPersonas");
			 System.out.println("3. Ordenar alfabeticamente por apellido el listadoPersonas");
			 System.out.println("4. Guardar listadoPersonas en Resultado.txt");
			 System.out.println("----------------------------");	
			 System.out.println("Ingrese la opcion: ");	
		     opcion = in.nextLine();
			 System.out.println();
			 switch (opcion) {
				case "1":
					archivo.setRuta("Personas.txt"); //prueba.txt
					if(archivo.existe())
					{
						System.out.println("Archivo encontrado!");
					}
					else
					{
						System.out.println("No existe archivo, entonces se crea uno nuevo.");
						archivo.creaArchivo();
					}

					archivo.cargaArchivoEnListado(listado);
					fun.cargarListadoEnPersonas(listado, listadoPersonas);
					System.out.println("Cargado y validado con exito!.");
					System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR.");
					in.nextLine();
					break;
				case "2":
					System.out.println("---MOSTRANDO CONTENIDO DEL OBJETO listadoPersonas---");
					for(Persona per:listadoPersonas) {
						System.out.println(per.getNombre() +" "+ per.getApellido()+" "+ per.getDni());
					}
					System.out.println("---------");
					System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR.");
					in.nextLine();
					break;
				case "3":
					fun.ordenaAlfabeticamente(listadoPersonas);
					System.out.println("Se organizo alfabeticamente!");
					//ESCRITURA:
//					archivo.escribe_lineas("\nUniversidad Tecnologica Nacional");
				default:
					System.out.println("Datos invalidos!");
					break;
			 }
		}
		


	}

}
