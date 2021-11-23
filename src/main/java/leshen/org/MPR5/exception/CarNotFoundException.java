package leshen.org.MPR5.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(){
        super("CarNotFound");
    }
}
