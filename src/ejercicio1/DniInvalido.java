package ejercicio1;

public class DniInvalido extends RuntimeException {
	
	public DniInvalido() {
		
	}
	
	@Override
	public String getMessage() {
		
		return "DniInvalido";
	}
}