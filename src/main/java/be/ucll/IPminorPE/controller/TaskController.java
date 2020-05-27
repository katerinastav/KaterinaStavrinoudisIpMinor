package be.ucll.IPminorPE.controller;

import be.ucll.IPminorPE.domain.Task;
import be.ucll.IPminorPE.dto.TaskDTO;
import be.ucll.IPminorPE.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    //@Autowired
    //public TaskController(TaskService taskService){
      //  this.taskService = taskService;
  //  }

    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    @GetMapping
    public String getTasks(Model model){
        if (taskService.getTasks().isEmpty()) return "notasks";
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }
/*
    @PostMapping
    public String addTask(@ModelAttribute TaskDTO taskDTO){
        taskService.addTask(taskDTO);
        return "redirect:/tasks";
    }*/

    @GetMapping("/{id}")
    public String getDetails(@PathVariable("id") int id, Model model) {
        for (Task task : taskService.getTasks()){
            if (task.getId() == id){
                model.addAttribute("task", taskService.getTask(id));
                return "details";
            }
        }
        return "redirect:/tasks/notfound";
    }

    @GetMapping("/notfound")
    public String notFound(){
        return "notfound";
    }

    @GetMapping("/new")
    public String getCreateForm(Model model){
        model.addAttribute("task", new Task());
        return "addtask";
    }

    @PostMapping("/new")
    public String postNewTask(@ModelAttribute @Valid TaskDTO taskDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "addtask";
        }
        taskService.addTask(taskDTO);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(Task task){
        return "addtask";
    }
/*
    @PostMapping("/edit/{id}")
    public String editTask(@ModelAttribute @Valid Task task, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "addtask";
        }
        taskService.addTask(task);
        return "redirect:/tasks/{id}";
    }*/

}
