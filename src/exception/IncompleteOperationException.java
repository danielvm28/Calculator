package exception;

public class IncompleteOperationException extends Exception{
	public IncompleteOperationException() {
		super("The operation is incomplete");
	}
}
