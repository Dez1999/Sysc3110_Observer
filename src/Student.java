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
}
