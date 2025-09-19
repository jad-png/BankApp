package bankaMeak.exception;

public class SoldeInsuffisantException extends Exception{
	private static final long serialVersionUID = -9170571601866224170L;

	public SoldeInsuffisantException(String msg) {
        super(msg);
    }
}
