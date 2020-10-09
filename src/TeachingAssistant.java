/** SYSC 2101 - Prof-Student-TA Example
 *
 * @author: Desmond Blake 101073534
 */

import java.util.Date;

public class TeachingAssistant implements ProfListener{
	private String name;
	private Date midterm;
	private String prof;

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

	public void addProf(Prof p){
		this.prof = p.getName();
	}

	@Override
	public void handleMidtermSet(ProfEvent pe) {
		Object source = pe.getSource();
		Prof p;
		if(source instanceof Prof){
			p = (Prof) source;
			if (this.prof == p.getName()) {
				proctor(pe.getMidtermDate());
			}
		}
	}

	@Override
	public void handleMidtermPostponed(ProfEvent pe) {
		Object source = pe.getSource();
		if (source instanceof Prof){
			postpone(pe.getMidtermDate());
		}
	}

	@Override
	public void handleAssignmentPosted(ProfEvent ce) {

	}
}
