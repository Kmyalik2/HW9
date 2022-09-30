import java.io.FileNotFoundException;
import java.io.IOException;

public class EmptySourceFileException extends Exception
{
    public  EmptySourceFileException (String message)
    { super (message);
    }
}