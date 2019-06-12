package brainGoodBye;

import java.io.Serializable;

/**
 * 
 * @author Jacob Ficker
 * @author Joey Hunt (minor edits)
 */
public class Task implements Cloneable, Serializable {

	/**
	 * Generated SUID
	 */
	private static final long serialVersionUID = 4416485524825278158L;
	private Double myHoursToComplete;
	private String myDescription;
	private boolean isDone;
	
	/**
	 * Basic constructor. Assumes task is not yet completed.
	 * @author Jacob Ficker
	 * @param hours
	 * @param desc
	 */
	public Task(Double hours, String desc) {
		myDescription = desc;
		myHoursToComplete = hours;
		isDone = false;
	}
	
	/**
	 * This constructor allows the specification of whether or not
	 * a task is completed.
	 * @author Jacob Ficker
	 * @param hours
	 * @param desc
	 * @param done
	 */
	public Task(Double hours, String desc, boolean done) {
		myDescription = desc;
		myHoursToComplete = hours;
		isDone = done;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public Double getHoursToComplete() {
		return myHoursToComplete;
	}

	/**
	 * @author Jacob Ficker
	 * @param myHoursToComplete
	 */
	public void setHoursToComplete(Double myHoursToComplete) {
		this.myHoursToComplete = myHoursToComplete;
	}

	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public String getDescription() {
		return myDescription;
	}

	/**
	 * @author Jacob Ficker
	 * @param myDescription
	 */
	public void setDescription(String myDescription) {
		this.myDescription = myDescription;
	}

	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public boolean isDone() {
		return isDone;
	}

	/**
	 * @author Jacob Ficker
	 * @param isDone
	 */
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	/**
	 * @author Jacob Ficker
	 */
	public Task() {
		myDescription = "A Task";
		myHoursToComplete = 0.0;
		isDone = false;
	}
	
	/**
	 * @author Jacob Ficker
	 */
	public Task clone() {
		return new Task(myHoursToComplete, myDescription, isDone);
	}

	/**
	 * @author Jacob Ficker
	 */
	@Override
	public boolean equals(Object o) {
		Task t = (Task) o;
		return this.isDone == t.isDone() 
				&& this.getDescription().equals(t.getDescription())
				&& this.getHoursToComplete() == t.getHoursToComplete();
	}
	
	/**
	 * @author Jacob Ficker
	 * @author Joey Hunt (minor edits)
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = (int) (prime * result + getHoursToComplete());
		result = prime * result + getDescription().hashCode();
		
		return result;
	}
	
}
