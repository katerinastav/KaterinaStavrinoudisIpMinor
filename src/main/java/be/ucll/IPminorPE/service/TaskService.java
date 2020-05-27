package be.ucll.IPminorPE.service;

import be.ucll.IPminorPE.domain.Task;
import be.ucll.IPminorPE.dto.TaskDTO;
import java.util.List;

public interface TaskService {
	public List<TaskDTO> getTasks();

	void addTask(TaskDTO taskDTO);

	Task getTask(int id);
}
