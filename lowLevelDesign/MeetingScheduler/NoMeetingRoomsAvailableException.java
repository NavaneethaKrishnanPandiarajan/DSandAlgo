//$Id$
package lowLevelDesign.MeetingScheduler;

public class NoMeetingRoomsAvailableException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoMeetingRoomsAvailableException()
	{
		super();
	}
	public NoMeetingRoomsAvailableException(String message)
	{
		super(message);
	}
	public NoMeetingRoomsAvailableException(Throwable cause)
	{
		super(cause);
	}
}
