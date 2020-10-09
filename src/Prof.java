/** SYSC 3110 - Prof-Student-TA Example
 * 
 *
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prof {
	private String name;
	private Date midtermDate;
	private List<CourseAnnouncementListener> courseAnnouncementListeners;    //Listener for Interface as a List(Good to be general, so it can change later)

	public Prof(String aName) {
		this.name = aName;
		this.courseAnnouncementListeners = new ArrayList<>();  //Initialization
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {
		this.midtermDate = date;
		for(CourseAnnouncementListener cal: courseAnnouncementListeners) cal.handleMidtermDateSet(date);
	}
	
	public void postponeMidterm(Date date){
		this.midtermDate = date;

		for(CourseAnnouncementListener cal: courseAnnouncementListeners)
			cal.handleMidtermPostponed(date);
	}

	/**
	 * Allows Prof class to talk about students and TA in a more general term, thus reduces coupling between classes.
	 * @param cal CourseAnnouncementListener
	 */
	public void addCourseAnnouncementListener(CourseAnnouncementListener cal){
		this.courseAnnouncementListeners.add(cal);
	}


	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		p.addCourseAnnouncementListener(s);   //Student Class must implement CourseAnnouncementListener
		p.addCourseAnnouncementListener(s2);
		p.addCourseAnnouncementListener(ta);   //TA Class must implement CourseAnnouncementListener
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}
