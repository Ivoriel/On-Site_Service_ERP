package pl.kosinski.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kosinski.common.TaskStatus;
import pl.kosinski.unit.UnitCrudService;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskCrudController {

    TaskCrudService taskCrudService;
    UnitCrudService unitCrudService;

    @GetMapping("")
    public String tasksHome(Model model) {
        model.addAttribute("tasks", taskCrudService.findAllTasks());
        return "/tasks/tasksHome";
    }

    @GetMapping("/create/{requestId}")
    public String createTask(@PathVariable long requestId, Model model) {
        TaskInfoDto taskInfoDto = taskCrudService.createTask(requestId);
        model.addAttribute("task", taskInfoDto);
        model.addAttribute("units", unitCrudService.getUnitsByClientId(taskInfoDto.getRequest().getClient().getId()));
        return "/tasks/create";
    }

    @PostMapping("/create/{requestId}")
    public String createTask(@Valid TaskInfoDto taskInfoDto, BindingResult result, @PathVariable long requestId) {
        if (result.hasErrors()) {
            return "/tasks/create";
        }
        taskCrudService.saveTask(taskInfoDto);
        return "redirect:/requests/details/" + requestId;
    }

    @GetMapping("/details/{id}")
    public String getTask(@PathVariable long id, Model model) {
        model.addAttribute("task", taskCrudService.findTaskById(id));
        return "/tasks/details";
    }

    @GetMapping("/update/{id}")
    public String updateTask(@PathVariable long id, Model model) {
        TaskInfoDto taskInfoDto = taskCrudService.findTaskById(id);
        model.addAttribute("task", taskInfoDto);
        model.addAttribute("units", unitCrudService.getUnitsByClientId(taskInfoDto.getRequest().getClient().getId()));
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
        TaskInfoDto taskInfoDto = taskCrudService.findTaskById(id);
        taskCrudService.deleteTask(id);
        return "redirect:/requests/details/" + taskInfoDto.getRequest().getId();
    }

    @ModelAttribute("statuses")
    public TaskStatus[] taskStatuses() {
        return TaskStatus.values();
    }
}
