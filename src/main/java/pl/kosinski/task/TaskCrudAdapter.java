package pl.kosinski.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskCrudAdapter implements TaskCrudService{

    TaskRepository repository;

    @Override
    public TaskInfoDto saveTask(TaskInfoDto taskInfoDto) {
        Task task = new Task();
        if (taskInfoDto.getId() != null) {
            task = getById(taskInfoDto.getId());
            task.setTaskInfo(taskInfoDto.getRequest(), taskInfoDto.getUnit(), taskInfoDto.getDescription());
            repository.save(task);
        } else {
            task.setTaskInfo(taskInfoDto.getRequest(), taskInfoDto.getUnit(), taskInfoDto.getDescription());
            repository.save(task);
        }
        taskInfoDto.setId(task.getId());
        return taskInfoDto;
    }

    private Task getById(long id) {
        return repository.getById(id);
    }

    @Override
    public TaskInfoDto findTaskById(Long id) {
        return translateToDto(getById(id));
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TaskInfoDto> findAllTasks() {
        List<TaskInfoDto> infoDtoList = new ArrayList<>();
        List<Task> taskList = repository.findAll();
        for (Task t : taskList) {
            infoDtoList.add(translateToDto(t));
        }
        return infoDtoList;
    }

    private TaskInfoDto translateToDto(Task task) {
        TaskInfoDto infoDto = new TaskInfoDto();
        infoDto.setId(task.getId());
        infoDto.setRequest(task.getRequest());
        infoDto.setUnit(task.getUnit());
        infoDto.setDescription(task.getDescription());
        return infoDto;
    }

}
