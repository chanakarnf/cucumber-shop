package ku.shop;

public class NotEnoughProductException extends Exception{
    public NotEnoughProductException() {
    }

    public NotEnoughProductException(String message) {
        super(message);
    }
}
