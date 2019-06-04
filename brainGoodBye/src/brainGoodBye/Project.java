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
	
	/**
	 * @author Jacob Ficker
	 * @param mat
	 * @param tas
	 * @param nam
	 * @param desc
	 * @param img
	 * @param saving
	 * @param costs
	 * @param theDate
	 * @param theSize
	 * @param theSkill
	 */
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
	
	/**
	 * @author Jacob Ficker
	 * @param nam
	 */
	public void setName(String nam) {
		name = nam;
	}
	/**
	 * @author Jacob Ficker
	 * @param desc
	 */
	public void setDescription(String desc) {
		description = desc;
	}
	/**
	 * @author Jacob Ficker
	 * @param img
	 */
	public void setImageFile(String img) {
		imageFile = img;
	}
	
	/**
	 * @author Jacob Ficker
	 * @param cost
	 */
	public void setCostPerMonth(Double cost) {
		costPerMonth = cost;
	}
	/**
	 * @author Jacob Ficker
	 * @param savings
	 */
	public void setSavingsPerMonth(Double savings) {
		savingsPerMonth = savings;
	}
	/**
	 * @author Jacob Ficker
	 * @param list
	 */
	public void setMaterialsList(List<Material> list) {
		materials = list;
	}
	
	/**
	 * @author Jacob Ficker
	 * @param list
	 */
	public void setTaskList(List<Task> list) {
		tasks = list;
	}
	/**
	 * @author Jacob Ficker
	 * @param theDate
	 */
	public void setModified(Date theDate) {
		lastModified = (Date) theDate.clone();
	}
	 
	/**
	 * @author Jacob Ficker
	 * @param s
	 */
	public void setSize(String s) {
		size = s;
	}
	/**
	 * @author Jacob Ficker
	 * @param d
	 */
	public void setDifficulty(String d) {
		skill = d;
	}
	/**
	 * @author Jacob Ficker
	 * @param t
	 */
	public void addTask(Task t) {
		tasks.add(t);
	}
	/**
	 * @author Jacob Ficker
	 * @param t
	 */
	public void removeTask(Task t) {
		tasks.remove(t);
	}
	/**
	 * @author Jacob Ficker
	 * @param before
	 * @param after
	 */
	public void replaceTask(Task before, Task after) {
		int i = tasks.indexOf(before);
		tasks.remove(i);
		tasks.add(i, after);
	}
	
	/**
	 * @author Jacob Ficker
	 * @param m
	 */
	public void addMaterial(Material m) {
		materials.add(m);
	}
	
	/**
	 * @author Jacob Ficker
	 * @param m
	 */
	public void removeMaterial(Material m) {
		materials.remove(m);
	}
	
	/**
	 * @author Jacob Ficker
	 * @param before
	 * @param after
	 */
	public void replaceMaterial(Material before, Material after) {
		int i = materials.indexOf(before);
		materials.remove(i);
		materials.add(i, after);
	}

	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public List<Task> getTaskListCopy() {
		List<Task> returnMe = new ArrayList<Task>();
		for (int i = 0; i < tasks.size(); i++) {
			returnMe.add(tasks.get(i).clone());
		}
		return returnMe;
	}

	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public List<Material> getMaterialListCopy() {
		List<Material> returnMe = new ArrayList<Material>();
		for (int i = 0; i < materials.size(); i++) {
			returnMe.add(materials.get(i).clone());
		}
		return returnMe;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public String getName() {
		return name;
	}


	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public String getImageFile() {
		return imageFile;
	}

	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public String getDifficulty() {
		return skill;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public Date getLastModified() {
		return lastModified;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public Double getSavingsPerMonth() {
		return savingsPerMonth;
	}

	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public Double getCostPerMonth() {
		return costPerMonth;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public Double getTotalHours() {
		Double done = 0.0;
		for (int i = 0; i < tasks.size(); i++) {
			done += tasks.get(i).getHoursToComplete();
		}
		return done;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public Double getHoursDone() {
		Double done = 0.0;
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).isDone()) {
				done += tasks.get(i).getHoursToComplete();
			}
		}
		return done;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public Double totalCost() {
		Double done = 0.0;
		for (int i = 0; i < materials.size(); i++) {
			done += materials.get(i).getPrice() * materials.get(i).getQuantity();
		}
		return done;
	}
	
	/**
	 * @author Jacob Ficker
	 * @return
	 */
	public Double getSpent() {
		Double done = 0.0;
		for (int i = 0; i < materials.size(); i++) {
			if (materials.get(i).isAcquired()) {
				done += materials.get(i).getPrice() * materials.get(i).getQuantity();
			}
		}
		return done;
	}
	
	/**
	 * @author Jacob Ficker
	 */
	public Project clone() {
		return new Project(this.getMaterialListCopy(), this.getTaskListCopy(), 
				name, description, imageFile, savingsPerMonth, costPerMonth,
				(Date) lastModified.clone(), size, skill);
	}
	
	/**
	 * @author Jacob Ficker
	 */
	@Override
	public boolean equals(Object o) {
		boolean b = (((Project) o).getName()).equals(this.getName())
					&& (((Project) o).getSize()).equals(this.getSize())
					&& (((Project) o).getDifficulty()).equals(this.getDifficulty())
					&& (((Project) o).getDescription()).equals(this.getDescription())
					&& (((Project) o).getImageFile()).equals(this.getImageFile())
					&& (((Project) o).getLastModified()).equals(this.getLastModified())
					&& (((Project) o).getSavingsPerMonth()) == (this.getSavingsPerMonth())
					&& (((Project) o).getCostPerMonth()) == (this.getCostPerMonth());
		
		boolean t = this.tasks.equals(((Project) o).getTaskListCopy());
		boolean m = this.materials.equals(((Project) o).getMaterialListCopy());
		
		return b && m && t;
	}
	
	/**
	 * @author Jacob Ficker
	 */
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
}
