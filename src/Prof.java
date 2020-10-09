/** SYSC 2101 - Prof-Student-TA Example
 *
 * @author: Desmond Blake 101073534
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prof {
	private String name;
	private Date midtermDate;
	private List<ProfListener> profListenerList; 	//ProfListener List

	public Prof(String aName) {
		this.name = aName;
		this.profListenerList = new ArrayList<>();
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {
		this.midtermDate = date;

		for(ProfListener profL: profListenerList){
			profL.handleMidtermSet(new ProfEvent(this, date));
		}
	}

	public void postponeMidterm(Date date){
		this.midtermDate = date;

		for(ProfListener profL: profListenerList){
			profL.handleMidtermPostponed(new ProfEvent(this, date));
		}
	}

	/**
	 * Allows Prof class to talk about students and TA in a more general term, thus reduces coupling between classes.
	 * Method: Adds a profListener to the Proflistener's List
	 * @param profL profListenerList
	 */
	public void addProfListener(ProfListener profL){
		this.profListenerList.add(profL);
	}

	/**
	 * Removes a Listener from the ProfListener List
	 * @param profL ProfListener
	 */
	public void removeProfListener(ProfListener profL){
		this.profListenerList.remove(profL);
	}

	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");


		p.addProfListener(s);
		p.addProfListener(s2);
		p.addProfListener(ta);

		//Add prof to student Instance
		s.addProf(p);
		s2.addProf(p);
		ta.addProf(p);

		Date midterm = new Date();
		p.setMidterm(midterm);

		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));


		/**Added commands to test removeProfListener **/
		System.out.println();
		System.out.println("Testing: Student s will now be removed ")
		;		p.removeProfListener(s);
		Date midterm1 = new Date();
		p.setMidterm(midterm1);
	}

}
