/** SYSC 2101 - Prof-Student-TA Example
 *
 * @author: Desmond Blake 101073534
 */

import java.util.Date;

public class Student implements ProfListener{
    private String name;
    private Date midterm;
    private String prof;

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

    public void addProf(Prof prof){
        this.prof = prof.getName();
    }


    /**
     * Method: handleMidtermSet: Depends on Prof name
     */
    @Override
    public void handleMidtermSet(ProfEvent pe) {
        Object source = pe.getSource();
        Prof p;
        if (source instanceof Prof){
            p = (Prof) source;
            if (this.prof == p.getName()) {
                study(pe.getMidtermDate());
            }
        }
    }

    @Override
    public void handleMidtermPostponed(ProfEvent pe) {
        Object source = pe.getSource();
        Prof p;
        if (source instanceof Prof) {
            p = (Prof) source;
            if (this.prof == p.getName()) {
                party(pe.getMidtermDate());
            }
        }
    }

    @Override
    public void handleAssignmentPosted(ProfEvent ce) {

    }
}
