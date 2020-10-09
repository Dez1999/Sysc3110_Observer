/** SYSC 3110 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;

//Implements the methods defined in CourseAnnouncementListener
public class Student implements CourseAnnouncementListener {
	private String name;
	private Date midterm;

	public Student(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void study(Date date){
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}
	
	public void party(Date date){
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}

	/**
	 * Uses Inheritance Class: CourseAnnouncementListener
	 **/
	@Override
	public void handleMidtermDateSet(Date date) {
		study(date);    //Calls study to set date
	}

	@Override
	public void handleMidtermPostponed(Date date) {
		party(date);
	}

	@Override
	public void handleAssignmentPosted(CourseEvent ce) {
		Object source = ce.getSource();
		Prof p;
		if (source instanceof Prof) {         //We are checking if the source is a prof.
			p = (Prof) source;
			System.out.println(p.getName());        //If it is a prof we print this line
		}
		

	}
}
