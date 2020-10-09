/** SYSC 3110 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;

public class TeachingAssistant implements CourseAnnouncementListener{
	private String name;
	private Date midterm;

	public TeachingAssistant(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void proctor(Date date){
		this.midterm = date;
		System.out.println(name + " : I have to proctor a midterm on " + this.midterm);
	}
	
	public void postpone(Date date){
		this.midterm = date;
		System.out.println(name + " : Now the midterm is on " + this.midterm);
	}

	//From Inheritance CLass CourseAnnouncementListener
	@Override
	public void handleMidtermDateSet(Date date) {
		proctor(date);
	}

	@Override
	public void handleMidtermPostponed(Date date) {
		postpone(date);
	}

	@Override
	public void handleAssignmentPosted(CourseEvent ce) {

	}
}
