package byKhaoula.controle2021;

public class IlligalArgumentException extends Exception {
	  public IlligalArgumentException(double valeur) {
	        super("valeur de la note(" +valeur+") doit etre dans l intervale 0-20");
	    }
}
