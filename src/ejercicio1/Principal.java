package ejercicio1;

public class Principal {

	public static void main(String[] args) {

		Archivo archivo = new Archivo();
		archivo.setRuta("Personas.txt"); //prueba.txt
		
		if(archivo.existe())
		{
			System.out.println("Archivo encontrado");
		}
		else
		{
			System.out.println("No existe archivo entonces lo creo");
			archivo.creaArchivo();
		}
		
		//ESCRITURA:

//		archivo.escribe_lineas("\nUniversidad Tecnologica Nacional");
	
		//LECTURA:

		
		System.out.println("A CONTINUACIÓN LEE DE A LINEAS: ");
		archivo.lee_lineas();
	}

}
