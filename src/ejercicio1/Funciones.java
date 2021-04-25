package ejercicio1;

import java.util.Collections;
import java.util.Comparator;
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
							if(!verificarRepetido(nuevaPersona.getDni(), listadoPersonas)) {
								listadoPersonas.add(new Persona(nuevaPersona.getNombre(),nuevaPersona.getApellido(),nuevaPersona.getDni()));
							} else {
								System.out.println("DNI REPETIDO: " + nuevaPersona.getDni());
							}
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
			   DniInvalido exc1 = new DniInvalido();
			   throw exc1;
			   //throw new DniInvalido();
		   }
		   
		   return auxContieneLetras;
	}
	
	public static boolean verificarRepetido(String dni,LinkedList<Persona> listadoPersonas) {
		//Boolean auxRepetido = false;
		
		for(Persona per: listadoPersonas) {
			if(dni.equals(per.getDni())) {
				return true;
			}
		}
		
		return false;
	}
	
	public void ordenaAlfabeticamente(LinkedList<Persona> listadoPersonas) {
		Collections.sort(listadoPersonas, new Comparator<Persona>() {
			   public int compare(Persona obj1, Persona obj2) {
			      return obj1.getApellido().compareTo(obj2.getApellido());
			   }
			});
	}
}
