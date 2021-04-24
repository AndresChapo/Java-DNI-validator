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

			nuevaPersona.setDni(palabra);
			if(nuevaPersona.getNombre()!=null) {
				if(!nuevaPersona.getNombre().equals("")) {
					listadoPersonas.add(new Persona(nuevaPersona.getNombre(),nuevaPersona.getApellido(),nuevaPersona.getDni()));
				}
			}
			
//			System.out.println(nuevaPersona.getNombre() +" "+ nuevaPersona.getApellido()+" "+ nuevaPersona.getDni());
			count =0;
			palabra ="";
			nuevaPersona.setApellido("");
			nuevaPersona.setNombre("");
			nuevaPersona.setDni("");
		}
	}
}
