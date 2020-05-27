package be.ucll.IPminorPE.repository;

import be.ucll.IPminorPE.domain.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryOud {
	private List<Task> list;

	public TaskRepositoryOud() {
		list = new ArrayList<>();
		list.add(new Task("Task 1", LocalDateTime.of(2020, 6, 30, 10, 0), "Move-out of dorm."));
		list.add(new Task("Task 2", LocalDateTime.of(2020, 7, 30, 10, 0), "WebGoat hacken."));
		list.add(new Task("Task 3", LocalDateTime.of(2020, 8, 30, 23, 59), "Organize workshop for ISW about hacking."));

	}

	public List<Task> getTasks() {
		return list;
	}


	public void addTask(Task task) {
		list.add(task);
	}
}
