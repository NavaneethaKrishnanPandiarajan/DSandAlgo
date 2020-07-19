//$Id$
package lowLevelDesign.MeetingScheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class Scheduler 
{
	private static final int MAX_HISTORICAL_MEETING_STORAGE = 20;

	List<MeetingRoom> meetingRooms;
	Meeting[] history;
	int historySize;

	public Scheduler(List<MeetingRoom> rooms) 
	{
		this.meetingRooms = rooms;
		this.history = new Meeting[MAX_HISTORICAL_MEETING_STORAGE];
		this.historySize = 0;
	}

	public Meeting book(Date start, Date end) throws NoMeetingRoomsAvailableException 
	{
		try 
		{
			for (MeetingRoom room : meetingRooms) 
			{
				if (room.isAvailable(start, end)) 
				{
					Meeting meeting = room.scheduleMeeting(start, end);
					saveToHistory(meeting);
					return meeting;
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		throw new NoMeetingRoomsAvailableException();
	}

	private void saveToHistory(Meeting meeting) {
		if (historySize == MAX_HISTORICAL_MEETING_STORAGE) {
			history[0] = null;
			for (int i = 1; i < MAX_HISTORICAL_MEETING_STORAGE; i++) {
				history[i - 1] = history[i]; 
			}
		}

		history[historySize++] = meeting;
	}

	public void invite(Meeting meeting, List<Attendee> attendees) {
		meeting.invite(attendees);
	}

}

// An assumption here is that each meeting room has infinite capacity.
class MeetingRoom 
{
	Calendar calendar;

	public boolean isAvailable(Date start, Date end) {
		return calendar.checkAvailability(start, end);
	}

	public Meeting scheduleMeeting(Date start, Date end) {
		return calendar.scheduleNewMeeting(start, end);
	}
}

class Calendar 
{
	MeetingRoom room;
	List<Meeting> meetings;

	public Calendar() 
	{
		this.meetings = new ArrayList<>();
	}

	public boolean checkAvailability(Date start, Date end) 
	{
		
		for (Meeting meeting : meetings) 
		{
			int val1 = meeting.end.compareTo(start);
			
			int val2 = meeting.start.compareTo(end);
			
			if ( val1 < 0 || val2 > 0)
				return false;
		}
		
		return true;
	}

	public Meeting scheduleNewMeeting(Date start, Date end) 
	{
		Meeting meeting = new Meeting(room, start, end);
		meetings.add(meeting);
		return meeting;
	}
}

class Meeting 
{
	private static final String EMAIL_NOTIFICATION_TEMPLATE_NAME = "Template File Path";
	
	Long id;
	MeetingRoom location;
	List<Attendee> attendees;
	Date start;
	Date end;
	EmailService emailService;
	
	public Meeting(MeetingRoom location, Date start, Date end) 
	{
		this.id = generateId();
		this.location = location;
		this.start = start;
		this.end = end;
		this.emailService = new EmailService();
	}

	
	private Long generateId() 
	{
		return UUID.randomUUID().node();
	}


	public void invite(List<Attendee> attendees) 
	{	
		List<String> emails = new ArrayList();
		for( Attendee attendee : attendees)
		{
			emails.add(attendee.email);
		}
		emailService.sendBulkEmail(EMAIL_NOTIFICATION_TEMPLATE_NAME,emails);
	}
}

class Attendee 
{
	String name;
	String email;
}

class EmailService 
{
	
	//SESClient client;  //Use AWS SES for transactional emails.
	
	public boolean sendBulkEmail(String template, List<String> emails) 
	{
		return true;
	}

}
