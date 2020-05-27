package be.ucll.IPminorPE.service;

import be.ucll.IPminorPE.domain.Task;
import be.ucll.IPminorPE.dto.TaskDTO;
import be.ucll.IPminorPE.repository.TaskRepositoryOud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
	private final TaskRepositoryOud repository;

	@Autowired
	public TaskServiceImpl(TaskRepositoryOud repository) {
		this.repository = repository;
	}

	@Override
	public List<TaskDTO> getTasks() {
		return repository.getTasks();
	}

	@Override
	public void addTask(TaskDTO taskDTO) {
		Task task = new Task(taskDTO.getTitle(), taskDTO.getDueDate(), taskDTO.getDescription());
		repository.addTask(task);
	}

	@Override
	public Task getTask(int id){
		Task tasktemp= null;
		for (Task task : repository.getTasks()){
			if (task.getId() == id) tasktemp = task;
		}
		return tasktemp;
	}
}
