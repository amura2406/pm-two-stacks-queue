package collection.exception;

/**
 * Created by amura on 12/25/16.
 */
public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException(){
        super();
    }

    public EmptyQueueException(String message){
        super(message);
    }
}
