//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ToDoList {
private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask (Task task) {
		try{
			tasks.put(task.getDescription(), task);
		} catch(IndexOutOfBoundsException e) {}
	}
	
	public void completeTask(String description) {
		Task task = null;
		if ((task = tasks.get(description)) != null){
			task.setComplete(true);
		};
	}
	public boolean getStatus(String description) {
		return tasks.get(description).isComplete();
	}
	public Task getTask(String description) {
		return tasks.get(description);
	}
	public Task removeTask(String description) {
		return tasks.remove(description);
	}
	public Collection<Task> getAllTasks() {
		return tasks.values();
	}
	public Collection<Task> getCompletedTasks() {
		Collection<Task> completedtasks = new ArrayList<Task>();
		Collection<Task> allTasks = new ArrayList<Task> ();
		allTasks = getAllTasks();
		for(Task task : allTasks) {
			if(task.isComplete()) completedtasks.add(task);
		}
		return completedtasks;
	}
}
