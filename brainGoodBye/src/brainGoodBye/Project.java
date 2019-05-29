package brainGoodBye;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Jacob Ficker
 */
public class Project implements Serializable {

	/**
	 * Generated UID
	 */
	private static final long serialVersionUID = 7096668793067214228L;

	private List<Material> materials;
	private List<Task> tasks;
	private String name;
	private String description;
	private String imageFile;
	private String size;
	private String skill;
	private Date lastModified;
	private Double savingsPerMonth;
	private Double costPerMonth;
	
	public Project(List<Material> mat, List<Task> tas, String nam, String desc, String img, 
			Double saving, Double costs, Date theDate, String theSize, String theSkill) {
		
		materials = mat;
		tasks = tas;
		name = nam;
		description = desc;
		imageFile = img;
		savingsPerMonth = saving;
		costPerMonth = costs;
		skill = theSkill;
		size = theSize;
		lastModified = theDate;
	}
	
	
	public void setName(String nam) {
		name = nam;
	}
	
	public void setDescription(String desc) {
		description = desc;
	}
	
	public void setImageFile(String img) {
		imageFile = img;
	}
	
	public void setCostPerMonth(Double cost) {
		costPerMonth = cost;
	}
	
	public void setSavingsPerMonth(Double savings) {
		savingsPerMonth = savings;
	}
	
	public void setMaterialsList(List<Material> list) {
		materials = list;
	}
	
	public void setTaskList(List<Task> list) {
		tasks = list;
	}
	
	public void addTask(Task t) {
		tasks.add(t);
	}
	
	public void removeTask(Task t) {
		tasks.remove(t);
	}
	
	public void replaceTask(Task before, Task after) {
		int i = tasks.indexOf(before);
		tasks.remove(i);
		tasks.add(i, after);
	}
	
	public void addMaterial(Material m) {
		materials.add(m);
	}
	
	public void removeMaterial(Material m) {
		materials.remove(m);
	}
	
	public void replaceMaterial(Material before, Material after) {
		int i = materials.indexOf(before);
		materials.remove(i);
		materials.add(i, after);
	}

	public List<Task> getTaskListCopy() {
		List<Task> returnMe = new ArrayList<Task>();
		for (int i = 0; i < tasks.size(); i++) {
			returnMe.add(tasks.get(i).clone());
		}
		return returnMe;
	}

	public List<Material> getMaterialListCopy() {
		List<Material> returnMe = new ArrayList<Material>();
		for (int i = 0; i < materials.size(); i++) {
			returnMe.add(materials.get(i).clone());
		}
		return returnMe;
	}
	
	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public String getImageFile() {
		return imageFile;
	}


	public Double getSavingsPerMonth() {
		return savingsPerMonth;
	}


	public Double getCostPerMonth() {
		return costPerMonth;
	}
	
	public Double getTotalHours() {
		Double done = 0.0;
		for (int i = 0; i < tasks.size(); i++) {
			done += tasks.get(i).getHoursToComplete();
		}
		return done;
	}
	
	public Double getHoursDone() {
		Double done = 0.0;
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).isDone()) {
				done += tasks.get(i).getHoursToComplete();
			}
		}
		return done;
	}
	
	public Double totalCost() {
		Double done = 0.0;
		for (int i = 0; i < materials.size(); i++) {
			done += materials.get(i).getPrice() * materials.get(i).getQuantity();
		}
		return done;
	}
	
	public Double getSpent() {
		Double done = 0.0;
		for (int i = 0; i < materials.size(); i++) {
			if (materials.get(i).isAcquired()) {
				done += materials.get(i).getPrice() * materials.get(i).getQuantity();
			}
		}
		return done;
	}
	
	public Project clone() {
		return new Project(this.getMaterialListCopy(), this.getTaskListCopy(), 
				name, description, imageFile, savingsPerMonth, costPerMonth,
				(Date) lastModified.clone(), size, skill);
	}
	
}
