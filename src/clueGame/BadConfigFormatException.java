package clueGame;

public class BadConfigFormatException extends Exception{

	public BadConfigFormatException() {
	}

	public BadConfigFormatException(String message) {
		super(message);
		System.out.println("you are dumb");
	}

	public BadConfigFormatException(Throwable cause) {
		super(cause);
	}

	public BadConfigFormatException(String message, Throwable cause) {
		super(message, cause);
	}
}
