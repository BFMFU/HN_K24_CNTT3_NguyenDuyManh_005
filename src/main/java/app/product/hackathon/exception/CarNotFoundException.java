package app.product.hackathon.exception;

public class CarNotFoundException extends RuntimeException {
	public CarNotFoundException(String message) {
		super(message);
	}
}
