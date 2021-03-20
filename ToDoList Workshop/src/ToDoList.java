//import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ToDoList {
private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask (Task task) {
		tasks.put(task.getDescription(), task);
	}
	public void completeTask(String description) {
		tasks.get(description).setComplete(true);
	}
	public boolean getStatus(String description) {
		return tasks.get(description).isComplete();
	}
	public Task getTask(String description) {
		return tasks.get(description);
	}
	public Task removeTask(String description) {
		Task task1 = tasks.remove(description);
		return task1;
	}
	public Collection<Task> getAllTasks() {
		return tasks.values();
	}
	public Collection<Task> getCompletedTasks() {
		HashMap<String, Task> completedtasks = new HashMap<String, Task>();
		for(Task task : tasks.values()) {
			if(task.isComplete()) {
				completedtasks.put(task.getDescription(), task);
			}
		}
		return completedtasks.values();
	}
	public boolean isEmpty() {
		return tasks.isEmpty();
	}
}
