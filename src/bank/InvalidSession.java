package bank;

public class InvalidSession extends Exception {
	public InvalidSession(){super();}
	public InvalidSession(String message) { super(message); }
	public InvalidSession(String message, Throwable cause) { super(message, cause); }
	public InvalidSession(Throwable cause) { super(cause); }
}
