import java.util.Date;
import java.util.EventObject;

public class CourseEvent extends EventObject {

    private Date midtermDate, assignmentDeadLine;
    private String assignmentText;

    public CourseEvent(Object source, Date midtermDate) {
        super(source);
        this.midtermDate = midtermDate;
    }

    public CourseEvent(Object source, String text, Date assignmentDeadLine){
        super(source);
        this.assignmentText = text;
        this.assignmentDeadLine = assignmentDeadLine;
    }

    public Date getMidtermDate() {
        return midtermDate;
    }

    public Date getAssignmentDeadLine() {
        return assignmentDeadLine;
    }

    public String getAssignmentText() {
        return assignmentText;
    }
}
