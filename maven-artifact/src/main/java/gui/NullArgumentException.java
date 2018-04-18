package gui;

public class NullArgumentException extends Exception{
	String field;
	public NullArgumentException(String field)
	{
		this.field=field;
	}
	public String toString()
	{
		return field;
	}
}
