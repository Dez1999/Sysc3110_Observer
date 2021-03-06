/**
 * Interface: methods with no implementation that define a contract. Contract is made up off lots of methods with no implementation
 * Different Classes can have the same methods of the Inheritance class, but the individually, the methods will perform different tasks
 */

public interface ProfListener {

    //handles an event:Midterm
    void handleMidtermSet(ProfEvent pe);
    void handleMidtermPostponed(ProfEvent pe);
    void handleAssignmentPosted(ProfEvent ce);
}
