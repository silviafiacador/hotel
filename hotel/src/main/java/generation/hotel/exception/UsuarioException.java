package generation.hotel.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	public UsuarioException(String message) {
		super(message);
	}

}
