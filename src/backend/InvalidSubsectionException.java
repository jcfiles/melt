package backend;

public class InvalidSubsectionException extends Exception
{
  public InvalidSubsectionException()
  {
    super("This subsection already contains Questions and a Subsection can therefore not be added!");
  }
  
  public InvalidSubsectionException(String message)
  {
    super(message);
  }
  
}
