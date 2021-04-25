package ejercicio1;

import java.util.LinkedList;

public class Funciones {

	public Funciones() {

	}

	public void cargarListadoEnPersonas(LinkedList<String> listado, LinkedList<Persona> listadoPersonas) {
		String palabra = "";
		Persona nuevaPersona = new Persona();
		int count=0;
			
		for(String l:listado) {
//			System.out.println(l);
			for(int x=0; x< l.length(); x++){
				if(String.valueOf(l.charAt(x)).equals("-")) {
					if(count == 0) {
						nuevaPersona.setNombre(palabra);
					} 
					if(count == 1) {
						nuevaPersona.setApellido(palabra);
					} 

					count +=1;
					palabra ="";			
				} else {
//				System.out.println(l.charAt(x));
				palabra += l.charAt(x);
				}
			}
			
			try {
				if(!verificarDniInvalido(palabra)) {
					nuevaPersona.setDni(palabra);
					if(nuevaPersona.getNombre()!=null) {
						if(!nuevaPersona.getNombre().equals("")) {
							listadoPersonas.add(new Persona(nuevaPersona.getNombre(),nuevaPersona.getApellido(),nuevaPersona.getDni()));
						}
					}
				}				
			}
			catch(DniInvalido d)
			{
				System.out.println("El DNI es invalido.");
				d.printStackTrace();
			}
			

//			System.out.println(nuevaPersona.getNombre() +" "+ nuevaPersona.getApellido()+" "+ nuevaPersona.getDni());
			count =0;
			palabra ="";
			nuevaPersona.setApellido("");
			nuevaPersona.setNombre("");
			nuevaPersona.setDni("");
		}
	}
	
	public static boolean verificarDniInvalido (String dni) throws DniInvalido {
		Boolean auxContieneLetras = false;
		
		   for(int i=0; i< dni.length() ; i++)
		   {
			   if (!Character.isDigit(dni.charAt(i))) {
				   auxContieneLetras = true;
	           }
		   }
		   System.out.println("DNI: " +dni+"- Contiene letas: " + auxContieneLetras);
		   
		   if(auxContieneLetras == true) {
			   //DniInvalido exc1 = new DniInvalido();
			   throw new DniInvalido();
		   }
		   
		   return auxContieneLetras;
	}
}
