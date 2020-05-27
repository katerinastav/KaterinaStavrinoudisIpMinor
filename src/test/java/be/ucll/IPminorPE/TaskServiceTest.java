package be.ucll.IPminorPE;

import be.ucll.IPminorPE.dto.TaskDTO;
import be.ucll.IPminorPE.service.TaskService;
import be.ucll.IPminorPE.service.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskServiceTest {
    private TaskService taskService = new TaskServiceImpl();
    @Test
    public void testGetTasks(){
        //setup
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("IP minor.");
        taskDTO.setDescription("FInish PE project for IP minor.");
        taskDTO.setDueDate(LocalDateTime.of(2020, 05, 31, 23, 59));
        taskService.addTask(taskDTO);

        //method to be tested
        List<TaskDTO> tasks = taskService.getTasks();

        //checks
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(1, tasks.size());
        TaskDTO task = tasks.get(0);
        assertNotNull(task);
    }
}
