import java.util.Collection;
//import java.util.HashMap;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;


public class ToDoListTest extends TestCase{
	// Define Test Fixtures
	private Task t1, t2;
	private String s1, s2;

	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
		t1 = new Task("login");
		t2 = new Task("logout");
		s1 = "login";
		s2 = "logout";
	}
	@After
	 public void tearDown() throws Exception{
		// Uninitialise test Fixtures
		t1 = null;
		t2 = null;
		s1 = null;
		s2 = null;
	}

	@Test
	public void testAddTask() {
		ToDoList tdl = new ToDoList();
		assertTrue (tdl.isEmpty());
		tdl.addTask(t1);
		assertFalse ("Task has not been added.", tdl.isEmpty());
		assertSame ("Added task is not same.", t1, tdl.getTask(s1));
	}
	@Test
	public void testgetStatus() {
		ToDoList tdl = new ToDoList();
		tdl.addTask(t1);
		tdl.addTask(t2);
		tdl.completeTask(s2);
		assertFalse("Status was wrong.", tdl.getStatus(s1));
		assertTrue("Status was wrong.", tdl.getStatus(s2));
	}
	@Test
	public void testRemoveTask() {
		ToDoList tdl = new ToDoList();
		tdl.addTask(t1);
		assertFalse ("Task has not been added.", tdl.isEmpty());
		Task task = tdl.removeTask(s1);
		assertSame ("Removed task is not same.", task, t1);
		assertTrue ("Task was not removed.", tdl.isEmpty());
	}
	@Test
	public void testGetCompletedTasks() {
		ToDoList tdl = new ToDoList();
		tdl.addTask(t1);
		tdl.addTask(t2);
		tdl.completeTask(s2);
		Collection<Task> complete = tdl.getCompletedTasks();
		assertFalse ("Nothing is completed.", tdl.isEmpty());
		for (Task t : complete) {
			assertSame (t, t2);
		}
	}
}
