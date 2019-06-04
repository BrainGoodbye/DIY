package brainGoodBye;

public class Task implements Cloneable {

	private Double myHoursToComplete;
	private String myDescription;
	private boolean isDone;
	
	public Task(Double hours, String desc) {
		myDescription = desc;
		myHoursToComplete = hours;
		isDone = false;
	}
	
	public Task(Double hours, String desc, boolean done) {
		myDescription = desc;
		myHoursToComplete = hours;
		isDone = done;
	}
	
	public Double getHoursToComplete() {
		return myHoursToComplete;
	}

	public void setHoursToComplete(Double myHoursToComplete) {
		this.myHoursToComplete = myHoursToComplete;
	}

	public String getDescription() {
		return myDescription;
	}

	public void setDescription(String myDescription) {
		this.myDescription = myDescription;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public Task() {
		myDescription = "A Task";
		myHoursToComplete = 0.0;
		isDone = false;
	}
	
	public Task clone() {
		return new Task(myHoursToComplete, myDescription, isDone);
	}

	@Override
	public boolean equals(Object o) {
		Task t = (Task) o;
		return this.isDone == t.isDone() 
				&& this.getDescription().equals(t.getDescription())
				&& this.getHoursToComplete() == t.getHoursToComplete();
	}
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
}
