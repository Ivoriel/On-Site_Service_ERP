package pl.kosinski.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kosinski.common.TaskStatus;
import pl.kosinski.unit.UnitCrudService;
import pl.kosinski.unit.UnitInfoDto;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskCrudController {

    TaskCrudService taskCrudService;
    UnitCrudService unitCrudService;

    @GetMapping("")
    public String tasksHome(Model model) {
        model.addAttribute("tasks", taskCrudService.findAllTasks());
        return "tasksHome";
    }

    @GetMapping("/create")
    public String createTask(Model model) {
        model.addAttribute("task", new TaskInfoDto());
        return "/tasks/create";
    }

    @PostMapping("/create")
    public String createTask(@Valid TaskInfoDto taskInfoDto, BindingResult result) {
        if (result.hasErrors()) {
            return "/tasks/create";
        }
        taskInfoDto = taskCrudService.saveTask(taskInfoDto);
        return "redirect:/tasks/details/" + taskInfoDto.getId();
    }

    @GetMapping("/details/{id}")
    public String getTask(@PathVariable long id, Model model) {
        model.addAttribute("task", taskCrudService.findTaskById(id));
        return "/tasks/details";
    }

    @GetMapping("/update/{id}")
    public String updateTask(@PathVariable long id, Model model) {
        model.addAttribute("task", taskCrudService.findTaskById(id));
        return "/tasks/update";
    }

    @PostMapping("update/{id}")
    public String updateTask(@Valid TaskInfoDto taskInfoDto, BindingResult result) {
        if (result.hasErrors()) {
            return "/tasks/update";
        }
        taskInfoDto = taskCrudService.saveTask(taskInfoDto);
        return "redirect:/tasks/details/" + taskInfoDto.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable long id, Model model) {
        model.addAttribute("taskId", id);
        return "/tasks/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable long id) {
        taskCrudService.deleteTask(id);
        return "redirect:/tasks";
    }

    @ModelAttribute("units")
    public List<UnitInfoDto> units() {
        return unitCrudService.findAllUnits();
    }

    @ModelAttribute("statuses")
    public TaskStatus[] taskStatuses() {
        return TaskStatus.values();
    }
}
