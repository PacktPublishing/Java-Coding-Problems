package modern.challenge;

import java.util.concurrent.ExecutionException;

public class DefectBulbException extends ExecutionException {

    private static final long serialVersionUID = 1L;

    public DefectBulbException() {
        super();
    }

    public DefectBulbException(String message) {
        super(message);
    }

    public DefectBulbException(Throwable cause) {
        super(cause);
    }

    public DefectBulbException(String message, Throwable cause) {
        super(message, cause);
    }
}
