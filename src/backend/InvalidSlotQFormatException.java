package backend;

public class InvalidSlotQFormatException extends Exception {
	
	public InvalidSlotQFormatException()
	{
		super("The question string must at least contain one answer wrapped in [...]");
	}

}
