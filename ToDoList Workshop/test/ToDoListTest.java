import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;


public class ToDoListTest extends TestCase{
	// Define Test Fixtures
	private Task t1, t2, t3, t4;
	private ToDoList tdl;

	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
		t1 = new Task("login");
		t2 = new Task("logout");
		t3 = new Task("create");
		t4 = new Task("delete");
		tdl = new ToDoList();
	}
	@After
	 public void tearDown() throws Exception{
		// Uninitialise test Fixtures
		t1 = null;
		t2 = null;
		tdl = null;
	}

	@Test
	public void testAddTask() {
		assertNotNull (tdl);
		tdl.addTask(t1);
		assertEquals(1, tdl.getAllTasks().size());
		assertEquals(t1, tdl.getTask(t1.getDescription()));
	}
	@Test
	public void testgetStatus() {
		assertNotNull (tdl);
		tdl.addTask(t1);
		tdl.addTask(t2);
		tdl.completeTask(t2.getDescription());
		assertEquals(false, tdl.getStatus(t1.getDescription()));
		assertEquals(true, tdl.getStatus(t2.getDescription()));
	}
	@Test
	public void testRemoveTask() {
		assertNotNull (tdl);
		tdl.addTask(t1);
		tdl.addTask(t2);
		tdl.removeTask(t1.getDescription());
		assertNull (tdl.getTask(t1.getDescription()));
	}
	@Test
	public void testGetCompletedTasks() {
		ToDoList tdl = new ToDoList();
		tdl.addTask(t1);
		tdl.addTask(t2);
		tdl.completeTask(t2.getDescription());
		Collection<Task> complete = tdl.getCompletedTasks();
		assertEquals (1, complete.size());
		for (Task t : complete) {
			assertSame (t, t2);
		}
	}
	@Test

	public void testGetTasksByPriority() {
		tdl.addTask(t1);
		tdl.addTask(t2);
		tdl.addTask(t3);
		tdl.addTask(t4);

	public void testSetPriority() {
		assertNotNull(tdl);
		assertNull(tdl.getTask(null));
		t1.setPriority(1);
		tdl.addTask(t1);
		assertEquals(tdl.getTask("login").getPriority(), 1);

	}
}

